package com.raxcl.service.impl;

import com.raxcl.dao.UserDao;
import com.raxcl.dao.impl.UserDaoImpl;
import com.raxcl.domain.User;
import com.raxcl.service.UserService;
import com.raxcl.util.MailUtils;
import com.raxcl.util.UuidUtil;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    public boolean regist(User user) {
        //1.根据用户id查询用户对象
        User u = userDao.queryUserById(user.getId());
        //判断u是否为null
        if (u != null){
            //用户名存在，注册失败
            return false;
        }
        //2.保存用户信息
        userDao.addUser(user);
        return true;
    }

    public User login(User user) {
        return userDao.findByIdAndPassword(user.getId(),user.getPassword());
    }

    public int deleteUserById(String id) {
        return 0;
    }

    public int updateUser(User user) {
        return 0;
    }



    public List<User> queryAllUser() {
        return null;
    }
    /**
     * 注册用户
     * @param user
     * @return
     */
   /* @Override


    @Override
    public boolean active(String code) {
        //1.根据激活码查询用户对象
        User user = userDao.findByCode(code);
        if (user !=null){
            //2.调用dao的修改激活状态的方法
            userDao.updateStatus(user);
            return true;
        }else {
            return false;
        }
    }
*/
}
