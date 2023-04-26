package com.shoppingmall.controller;

import com.shoppingmall.service.RegisterService;
import com.shoppingmall.service.RegisterServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class IdCheckController implements MyController {

  RegisterService registerService;

  public IdCheckController() {
    registerService = new RegisterServiceImpl();
  }

  @Override
  public void process(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    String checkId = request.getParameter("checkId");
    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();

    if (registerService.checkDuplicate(checkId)) {
      out.print("Duplicate");
    } else {
      out.print("Available");
    }
  }
}
