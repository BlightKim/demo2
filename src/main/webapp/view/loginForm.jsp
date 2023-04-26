<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
  <title>shoppingmall</title>
  <!-- Bootstrap CSS -->
  <link rel="stylesheet"
        href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous">
  
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script
    src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.1/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<section class="py-4 py-xl-5">
  <div class="container">
    <div class="row mb-5">
      <div class="col-md-8 col-xl-6 text-center mx-auto">
        <h2 class="font-weight-bold">로그인</h2>
      </div>
    </div>
    <div class="row d-flex justify-content-center">
      <div class="col-md-6 col-xl-4">
        <div class="card">
          <div class="card-body text-center d-flex flex-column align-items-center">
            <div class="bs-icon-xl bs-icon-circle bs-icon-primary bs-icon my-4">
              <svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" fill="currentColor" viewBox="0 0 16 16"
                   class="bi bi-person">
                <path
                  d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10z"></path>
              </svg>
            </div>
            <form action="/login/login" method="post">
              <div class="mb-3"><input class="form-control" id="userId" name="userId" value="${empty cookie.id.value ? '' : cookie.id.value}" type="text" placeholder="아이디">
              </div>
              <div class="mb-3"><input class="form-control" id="password" name="password" type="password"
                                       placeholder="비밀번호"></div>
              <div class="mb-3">
                <button id="login_btn" class="btn btn-primary d-block w-100" type="submit" onclick="return loginCheck()">Log in
                </button>
              </div>
              <c:if test="${requestScope.result == '0'}">
              <div class="mb-3" id="login_warning">
                <span style="color: red;">아이디 비밀번호를 다시 한번 확인해주세요.</span>
              </div>
              </c:if>
              <div class="form-check text-center"><input name="rememberId" class="form-check-input" type="checkbox" id="rememberId"
                                                         value="true" ${empty cookie.id.value ? '' : 'checked'}><label
                class="form-check-label" for="rememberId">아이디 기억</label></div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="container text-center d-flex float-none justify-content-sm-center align-items-sm-center"><a
    class="social-link" href="#" style="margin: 0px 5px;"><i class="fa fa-facebook social-link-icon"></i>
    <div class="social-link-effect"></div>
  </a><a class="social-link" href="#" style="margin: 0px 5px;"><i class="fa fa-twitter social-link-icon"></i>
    <div class="social-link-effect"></div>
  </a><a class="social-link" href="#" style="margin: 0px 5px;"><i class="fa fa-instagram social-link-icon"></i>
    <div class="social-link-effect"></div>
  </a><a class="social-link" href="#" style="margin: 0px 5px;"><i class="fa fa-github social-link-icon"></i>
    <div class="social-link-effect"></div>
  </a></div>
</section>

<script>
    $(document).ready(function () {
        $("#userId").focus();

        $("#login_btn").click(loginCheck);

    });

    function loginCheck() {
        if ($("#userId").val() == "") {
            alert("아이디를 입력해주세요.");
            $("#userId").focus();
            return false;
        }
        if ($("#password").val() == "") {
            alert("비밀번호를 입력해주세요.");
            $("#password").focus();
            return false;
        }
        return true;
        // const id = $("#userId").val();
        // const password = $("#password").val();
        //
        // $.ajax({
        //     type: 'POST',
        //     url: '/login/login',
        //     header: {
        //         'Content-Type': 'application/json'
        //     },
        //     dataType: 'text',
        //     data: {
        //         id: id,
        //         password: password
        //     },
        //     success: (data) => {
        //         console.log(data);
        //         if(data === 'Success') {
        //             $('#login_warning').attr('hidden', 'hidden');
        //             sessionStorage.setItem("id", id);
        //             location.href = '/home';
        //         } else {
        //             $('#login_warning').removeAttr('hidden');
        //             $('#login_warning').html('<b style="font-size: 14px; color:red">[아이디 비밀번호를 다시 확인해주세요.]</b>');
        //         }
        //     },
        //     error: (status, error) => {
        //         console.log('통신 실패');
        //         console.log(status, error);
        //     }
        // });
    }
</script>
</body>
</html>