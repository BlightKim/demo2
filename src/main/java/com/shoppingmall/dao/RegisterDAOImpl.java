package com.shoppingmall.dao;

import com.shoppingmall.mybatis.DBService;
import com.shoppingmall.vo.UserVO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;
import java.util.Map;

public class RegisterDAOImpl implements RegisterDAO{
  private DBService dbService;

  public RegisterDAOImpl() {
    dbService = new DBService();
  }

  @Override
  public List<UserVO> selectAll() {
    SqlSessionFactory factory = DBService.getFactory();
    SqlSession ss = factory.openSession();
    List<UserVO> list = ss.selectList("shop.findAllUser");
    ss.close();

    return list;
  }

  @Override
  public int insertOne(UserVO userVO) {
    SqlSessionFactory factory = DBService.getFactory();
    SqlSession ss = factory.openSession(true);
    int result = ss.insert("shop.insertUser", userVO);
    ss.close();
    return result;
  }

  @Override
  public UserVO selectUserById(String userId) {
    SqlSessionFactory factory = DBService.getFactory();
    SqlSession ss = factory.openSession();
    UserVO userVO = ss.selectOne("shop.findUserById", userId);
    ss.close();
    return userVO;
  }

  @Override
  public int updateDelete(int userIdx) {
    SqlSession ss = null;
    int result = 0;
    try {
      SqlSessionFactory factory = DBService.getFactory();
      ss = factory.openSession();
      result = ss.update("shop.updateUserStatus", userIdx);
      ss.commit();
      return result;
    } catch (Exception e) {
      e.printStackTrace();
      ss.rollback();
    } finally {
      ss.close();
    }
    return result;
  }

  @Override
  public int updateCellphone(Map map) {
    SqlSession ss = null;
    int result = 0;
    try {
      SqlSessionFactory factory = DBService.getFactory();
      ss = factory.openSession();
      result = ss.update("shop.updateCellphone", map);
      ss.commit();
      return result;
    } catch (Exception e) {
      ss.rollback();
      return 0;
    } finally {
      ss.close();
    }
  }

  @Override
  public int updateName(Map map) {
    SqlSession ss = null;
    int result = 0;
    try {
      SqlSessionFactory factory = DBService.getFactory();
      ss = factory.openSession();
      result = ss.update("shop.updateName", map);
      ss.commit();
      return result;
    } catch (Exception e) {
      ss.rollback();
      return 0;
    } finally {
      ss.close();
    }
  }
}
