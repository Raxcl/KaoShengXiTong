package com.raxcl.service;

import com.raxcl.domain.User;

import java.util.List;

public interface UserService {
    /**
     * 增加一个考生
     * @param user
     * @return
     */
    boolean regist(User user);

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
     * 查询一个考生
     * @param id
     * @return
     */
    User login(User user);

    /**
     * 查询全部的考生
     * @return
     */
    List<User> queryAllUser();
}
