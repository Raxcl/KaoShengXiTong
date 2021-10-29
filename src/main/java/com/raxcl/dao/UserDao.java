package com.raxcl.dao;

import com.raxcl.domain.User;

import java.util.List;

public interface UserDao {
    /**
     * 增加一个考生
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 根据id查询一个考生
     * @param id
     * @return
     */
    User queryUserById(String id);

    /**
     * 根据id和密码查询一个考生
     * @param id
     * @return
     */
    User findByIdAndPassword(String id, String password);

    /**
     * 删除一个考生
     * @param id
     * @return
     */
    int deleteUserById(String id);

    /**
     * 更新一个考生
     * @param user
     * @return
     */
    int updateUser(User user);




    /**
     * 查询全部的考生
     * @return
     */
    List<User> queryAllUser();
}
