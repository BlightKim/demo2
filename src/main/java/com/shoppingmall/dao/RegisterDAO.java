package com.shoppingmall.dao;

import com.shoppingmall.vo.UserVO;

import java.util.List;
import java.util.Map;

public interface RegisterDAO {
  public List<UserVO> selectAll();
  public int insertOne(UserVO userVO);
  public UserVO selectUserById(String userId);
    int updateDelete(int userIdx);

    int updateName(Map map);

  int updateCellphone(Map map);

    UserVO selectUserByIdx(int userIdx);
}
