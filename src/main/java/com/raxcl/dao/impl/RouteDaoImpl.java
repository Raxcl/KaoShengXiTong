package com.raxcl.dao.impl;

import com.raxcl.dao.RouteDao;
import com.raxcl.domain.Route;
import com.raxcl.util.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RouteDaoImpl implements RouteDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public int findTotalCount(int cid) {
        return 0;
    }

    @Override
    public List<Route> findByPage(int cid, int start, int pageSize) {
        return null;
    }
}
