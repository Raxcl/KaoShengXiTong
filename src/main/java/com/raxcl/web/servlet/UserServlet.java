package com.raxcl.web.servlet;

import com.raxcl.domain.ResultInfo;
import com.raxcl.domain.User;
import com.raxcl.service.UserService;
import com.raxcl.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
    UserService service  = new UserServiceImpl();


    public void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取数据
        Map<String, String[]> map = request.getParameterMap();
        //2.封装对象
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //3.调用service完成注册
        boolean flag = service.regist(user);
        ResultInfo info = new ResultInfo();
        //4.响应结果
        if(flag){
            //注册成功
            info.setFlag(true);
        }else {
            //注册失败
            info.setFlag(false);
            info.setErrorMsg("注册失败");
        }
        //将info对象序列化为json
        //将json数据写回客户端
        writeValue(info,response);
    }

    /**
     * 登录功能
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取用户名和密码
        Map<String, String[]> map = request.getParameterMap();
        //封装User
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //3.调用service完成查询
        User u = service.login(user);
        ResultInfo info = new ResultInfo();
        //4.判断用户对象是否为null
        if (u == null){
            //用户名或密码错误
            info.setFlag(false);
            info.setErrorMsg("用户名或密码错误");
        }
        //6.判断登录成功
            request.getSession().setAttribute("user",u);//登录成功标记
            //登录成功
            info.setFlag(true);
        //响应数据
        writeValue(info,response);
    }

    /**
     * 退出功能
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.销毁session
        request.getSession().invalidate();
        //2.跳转页面
        response.sendRedirect(request.getContextPath()+"/login.html");
    }

    /**
     * 查询单个对象
     */

    public void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从session中获取登录用户
        Object user = request.getSession().getAttribute("user");
        //将user写回客户端
        writeValue(user,response);
    }

    public void baoming(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ResultInfo info = new ResultInfo();

        info.setFlag(true);
        writeValue(info,response);
    }



}
