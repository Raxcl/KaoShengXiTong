package com.raxcl.service;

import com.raxcl.domain.PageBean;
import com.raxcl.domain.Route;

public interface RouteService {
    PageBean<Route> PageQuery(int cid, int currentPage, int pageSize);
}
