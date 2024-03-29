package com.shoppingmall.controller;

import com.shoppingmall.service.RegisterService;
import com.shoppingmall.service.RegisterServiceImpl;
import com.shoppingmall.vo.UserVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class JoinController implements MyController{
  RegisterService registerService;
  public JoinController() {
    registerService = new RegisterServiceImpl();
  }

  @Override
  public void process(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=UTF-8");

    String userId = request.getParameter("userId");
    String password = request.getParameter("password1");
    String userName = request.getParameter("userName");
    String Email = request.getParameter("email");
    String cellPhone = request.getParameter("cellphone");
    String address = String.join(" ", request.getParameterValues("address"));
    String introduction = request.getParameter("introduction");
    int gender = Integer.parseInt(request.getParameter("gender"));

//    cellPhone.
    System.out.println("userId = " + userId);
    System.out.println("password = " + password);
    System.out.println("userName = " + userName);
    System.out.println("cellPhone = " + cellPhone);
    System.out.println("Email = " + Email);
    System.out.println("introduction = " + introduction);
    System.out.println("address = " + address);

    UserVO userVO = new UserVO( userId, password, userName, cellPhone,address, Email, introduction,gender,0,0);

    registerService.join(userVO);


    PrintWriter out = response.getWriter();

    out.println("<script>alert('계정이 등록 되었습니다'); location.href='/home';</script>");

    out.flush();

  }
}
