package com.wnn.bs.servlet;

import com.wnn.bs.bean.User;
import com.wnn.bs.service.UserService;
import com.wnn.bs.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserServlet extends BaseServlet {

    private UserService us = new UserServiceImpl();

/*    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);
    }

    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {

        String method = request.getParameter("method");
        if("regist".equals(method)){
            regist(request,response);
        }else if("login".equals(method)){
            login(request,response);
        }else if("logout".equals(method)){

        }

    }*/

    protected void regist(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String codeKey = (String) session.getAttribute("codeKey");

        String code = request.getParameter("code");

        if(!code.equals(codeKey)){
            //表单重复提交
            request.setAttribute("msg", "此表单已经提交过，请重新刷新表单后再提交");
            //转发到注册页面，同时提示用户“此用户名已经注册过，请重新设置"
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
        }

        session.removeAttribute("codeKey");

        //获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        //封装成User对象
        User user = new User(null, username, password, email);

        //调用UserService,保存到数据库
        boolean flag = us.regist(user);

        //根据service层返回结果跳转页面
        if (flag) {
            //成功重定向到页面
//            response.sendRedirect(request.getContextPath() + "/pages/user/login.jsp");
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
        } else {

            request.setAttribute("msg", "此用户名已经注册过，请重新注册");
            //转发到注册页面，同时提示用户“此用户名已经注册过，请重新设置"
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);

        }
    }

    protected void login(final HttpServletRequest request,final HttpServletResponse response) throws ServletException, IOException {

        //获取用户名与密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //封装成用户
        User user = new User(null, username, password, null);

        //调用service方法
        User dbUser = us.login(user);

        //根据返回结果跳转页面
        if(dbUser==null){
            //不成功回登录页面
            request.setAttribute("msg","您输入的用户名或密码不正确");
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
        }else{
            //成功去首页

            //获取session对象，将用户放置到session域中
            HttpSession session = request.getSession();
            session.setAttribute("user",dbUser);

            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }
    }
    //退出
    protected void logout(final HttpServletRequest request,final HttpServletResponse response) throws ServletException, IOException {

        //获取session对象，将用户放置到session域中
        HttpSession session = request.getSession();
        session.invalidate();

        response.sendRedirect(request.getContextPath()+"/index.jsp");

    }
}

