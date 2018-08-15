package com.yc.dao.impl;

import com.yc.dao.BaseDao;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository(value ="baseDao")
public class BaseDaoMybatisimpl<T>  implements BaseDao<T> {
    private final String MAPPERPATH = "com.yc.bean.";

    //重写了父类SqlSessionDaoSupport方法实现注入SqlSessionTemplate
    //为什么要重写？如果不重写的话，则需要xml配置spring
    @Autowired
   private SqlSession sqlSession;
    @Override
    public void save(T t, String sqlId) {
        sqlSession.insert(MAPPERPATH + t.getClass().getSimpleName() + "Mapper." + sqlId, t);
    }

    @Override
    public void save(Class<T> clazz, String sqlId, Map<String, Object> parameterMap) {

        sqlSession.insert(MAPPERPATH + clazz.getSimpleName() + "Mapper." + sqlId, parameterMap);

    }

    @Override
    public void save(Class<T> clazz, String sqlId, List<T> list) {
        sqlSession.insert(MAPPERPATH + clazz.getSimpleName() + "Mapper." + sqlId, list);
    }


    @Override
    public List<T> findAll(Class<T> clazz, String sqlId) {
        return sqlSession.selectList(MAPPERPATH + clazz.getSimpleName() + "Mapper." + sqlId);
    }

    @Override
    public List<T> findAll(Class<T> clazz, String sqlId, Map<String, Object> parameterMap) {
        return sqlSession.selectList(MAPPERPATH + clazz.getSimpleName() + "Mapper." + sqlId, parameterMap);

    }

    @Override
    public List<T> findAll(T t, String sqlId) {
        return sqlSession.selectList(MAPPERPATH + t.getClass().getSimpleName() + "Mapper." + sqlId, t);

    }

    @Override
    public T find(T t, String sqlId) {
        return sqlSession.selectOne(MAPPERPATH + t.getClass().getSimpleName() + "Mapper." + sqlId, t);
    }


    @Override
    public T findOne(Class<T> clazz, String sqlId) {
        List<T> list = sqlSession.selectList(MAPPERPATH + clazz.getSimpleName() + "Mapper." + sqlId);
        if (list != null && list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    public T findOne(T t, String sqlId) {
        List<T> list = sqlSession.selectList(MAPPERPATH + t.getClass().getSimpleName() + "Mapper." + sqlId, t);

        if (list != null && list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    public T findOne(Class<T> clazz, String sqlId, Map<String, Object> parameterMap) {
        List<T> list = sqlSession.selectList(MAPPERPATH + clazz.getSimpleName() + "Mapper." + sqlId, parameterMap);

        if (list != null && list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<T> findList(Class<T> clazz, Map<String, Object> map, String sqlId) {
        List<T> list =sqlSession.selectList(MAPPERPATH + clazz.getSimpleName() + "Mapper." + sqlId, map);

        return list;
    }


}

