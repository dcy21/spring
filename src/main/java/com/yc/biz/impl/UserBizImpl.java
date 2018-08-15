package com.yc.biz.impl;

import com.yc.beans.User;
import com.yc.biz.UserBiz;
import com.yc.dao.BaseDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserBizImpl implements UserBiz {
    @Resource(name ="baseDao")
    private BaseDao<User> baseDao;
    @Override
    public boolean register(User user) {
        baseDao.save(user,"saveUser");
        return true;
    }

    @Override
    public boolean validate(User user) {
        user=baseDao.find(user,"isUserExists");
        if(user !=null){
            return true;
        }
        return false;
    }

    @Override
    public User getUserById(Integer id) {
        User u=new User();
        u.setId(id);
        return baseDao.find(u,"getUser");
    }

    @Override
    public User login(User user) {
        User u=baseDao.find(user,"getUserByLogin");
        return u;
    }
}
