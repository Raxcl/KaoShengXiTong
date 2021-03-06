package com.raxcl.service.impl;

import com.raxcl.dao.RouteDao;
import com.raxcl.dao.impl.RouteDaoImpl;
import com.raxcl.domain.PageBean;
import com.raxcl.domain.Route;
import com.raxcl.service.RouteService;

import java.util.List;

public class RouteServiceImpl implements RouteService{
    private RouteDao routeDao = new RouteDaoImpl();
    @Override
    public PageBean<Route> PageQuery(int cid, int currentPage, int pageSize) {
        //封装pageBean
        PageBean<Route> pb = new PageBean<Route>();
        //设置当前页码
        pb.setCurrentPage(currentPage);
        //设置每页显示条数
        pb.setPageSize(pageSize);
        //设置总记录数
        int totalCount = routeDao.findTotalCount(cid);
        pb.setTotalPage(totalCount);
        //设置当前页显示的数据集合
        int start = (currentPage - 1) * pageSize;
        List<Route> list = routeDao.findByPage(cid,start,pageSize);
        pb.setList(list);

        //设置总页数 = 总记录数/每页显示条数
        int totalPage = totalCount % pageSize == 0 ? totalCount/pageSize : (totalCount/pageSize) + 1 ;
        pb.setTotalPage(totalPage);


        return pb;
    }
}
