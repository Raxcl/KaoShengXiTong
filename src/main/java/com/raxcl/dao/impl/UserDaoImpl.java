package com.raxcl.dao.impl;

import com.raxcl.dao.UserDao;
import com.raxcl.domain.User;
import com.raxcl.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public int addUser(User user) {
        //1.定义sql
        String sql = "insert into User(id,name,password,status) value(?,?,?,?)";
        return template.update(sql,user.getId(),
                user.getName(),
                user.getPassword(),
                user.getStatus());
    }

    public User findByIdAndPassword(String id, String password) {
        User user = null;
        try {
            //1.定义sql
            String sql = "select * from user where id=? and password=?";
            //2.执行sql
            user = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),id,password);
        } catch (DataAccessException e) {

        }
        return user;
    }

    /*public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
        User user = new User("11112","chenf","123444",1);
        System.out.println(userDao.addUser(user));
    }*/

    public int deleteUserById(String id) {
        return 0;
    }

    public int updateUser(User user) {
        return 0;
    }

    public User queryUserById(String id) {
        User user = null;
        try {
            //1.定义sql
            String sql = "select * from user where id = ?";
            //2.执行sql
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
        } catch (DataAccessException e) {
        }
        return user;
    }

    public List<User> queryAllUser() {
        return null;
    }


   /*

    public User findByCode(String code) {
        User user = null;
        try {
            String sql = "select * from tab_user where code=?";
            user = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),code);
        } catch (DataAccessException e) {
            //e.printStackTrace();
        }
        return user;
    }

    *//**
     * 修改制定用户激活状态
     * @param user
     *//*

    public void updateStatus(User user) {
        String sql ="update tab_user set status = 'Y' where uid= ?";
        template.update(sql,user.getUid());
    }


    */
}
