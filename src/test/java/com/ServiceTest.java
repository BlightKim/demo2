package com;

import com.shoppingmall.service.RegisterService;
import com.shoppingmall.service.RegisterServiceImpl;
import com.shoppingmall.vo.UserVO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Transactional
public class ServiceTest {
    RegisterService registerService;
    @BeforeEach
    public void beforeEach() {
        registerService = new RegisterServiceImpl();
    }

    @Test
    public void getUserByIdTest() {
        UserVO userById = registerService.getUserById("testid");

        Assertions.assertThat(userById.getUserId()).isEqualTo("testid");
        Assertions.assertThat(userById.getPassword()).isEqualTo("test12345678!");
    }
    @Test
    public void 유저인덱스로유저한명찾기() {
        UserVO userByIdx = registerService.getUserByIdx(1);

        Assertions.assertThat(userByIdx.getUserId()).isEqualTo("test");
        Assertions.assertThat(userById.getPassword()).isEqualTo("test12345678!");
    }

    @Test
    public void 회원탈퇴 () {
        UserVO userById = registerService.getUserById("testid");

        Assertions.assertThat(registerService.withDrawl(userById.getUserIdx())).isEqualTo(1);

    }
    @Test
    public void 이름수정() {
        UserVO userVO = registerService.getUserById("testid");

        Map<String, Object> map = new HashMap<>();
        int userIdx = userVO.getUserIdx();
        String newName = "김세빈3";
        map.put("userIdx", userIdx);
        map.put("newName", newName);

        int result = registerService.changeName(map);

        assertThat(result).isEqualTo(1);

    }

    @Test
    public void 전화번호수정() {
        UserVO userVO = registerService.getUserById("testid");

        Map<String, Object> map = new HashMap<>();
        int userIdx = userVO.getUserIdx();
        String newCellphone = "010-1234-5678(2)";
        map.put("userIdx", userIdx);
        map.put("newCellphone", newCellphone);

        int result = registerService.changeCellphone(map);

        UserVO userVO2 = registerService.getUserById("testid");

        assertThat(result).isEqualTo(1);
        assertThat(userVO2.getCellPhone()).isEqualTo(newCellphone);
    }
}
