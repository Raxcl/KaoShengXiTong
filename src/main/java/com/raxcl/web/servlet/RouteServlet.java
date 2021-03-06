package com.raxcl.web.servlet;

import com.raxcl.domain.PageBean;
import com.raxcl.domain.Route;
import com.raxcl.service.RouteService;
import com.raxcl.service.impl.RouteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/route/*")
public class RouteServlet extends BaseServlet {
    private RouteService routeService = new RouteServiceImpl();


    /**
     * 分页查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void pageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收参数
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        String cidStr = request.getParameter("cid");
        int cid = 0;
        //2.处理参数
        if(cidStr !=null && cidStr.length()>0 && !"null".equals(cidStr)){
            cid = Integer.parseInt(cidStr);
        }
        int currentPage = 0;//当前页码，如果不传递，则默认为第一页
        if(currentPageStr != null && currentPageStr.length() > 0){
            currentPage = Integer.parseInt(currentPageStr);
        }else {
            currentPage=1;
        }
        int pageSize = 0;//每页显示条数，如果不传递，默认每页显示5条记录
        if(pageSizeStr != null && pageSizeStr.length() > 0){
            currentPage = Integer.parseInt(pageSizeStr);
        }else {
            pageSize=5;
        }
        //3.调用service查询PageBean对象
        PageBean<Route> pb = routeService.PageQuery(cid,currentPage,pageSize);
        //4.将pageBean对象序列化为json，返回
        writeValue(pb,response);

    }

    protected void dofGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
