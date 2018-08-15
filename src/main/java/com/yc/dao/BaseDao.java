package com.yc.dao;

import java.util.List;
import java.util.Map;

public interface BaseDao<T> {
    public void save(T t, String sqlId);

    public void save(Class<T> clazz, String sqlId, Map<String, Object> parameterMap);

    public void save(Class<T> clazz, String sqlId, List<T> list);

    /**
     * 更新对象
     * @param
     * @param ：带有参数的待更新对象
     * @param sqlId：mapper中的方法名
     */

    /**
     * 查集合，没有条件属性
     * @param
     * @param clazz 对象的反射实例用于存放mapper文件的位置
     * @param sqlId mapper中的方法名
     * @return 集合
     */
    public List<T> findAll(Class<T> clazz,String sqlId);
    public List<T> findAll(Class<T> clazz, String sqlId, Map<String, Object> parameterMap);
    public List<T> findAll(T t, String sqlId);
    /**
     * 条件查询，查一条数据
     * @param
     * @param t  条件对象，用于确认mapper文件的位置及条件值
     * @param sqlId mapper中的方法名
     * @return 对象
     */
    public T find(T t,String sqlId);

    public T findOne(Class<T> clazz,String sqlId);
    public T findOne(T t,String sqlId);
    public T findOne(Class<T> clazz, String sqlId, Map<String, Object> parameterMap);

    /**
     * 根据条件分页查询
     * @param
     * @param clazz 用于确认mapper文件的位置
     * @param map 参数键为字段名，值为参数值
     * @param sqlId mapper里面的方法名
     * @param // 从第几条数据开始查
     * @param // 每页几条
     * @return
     */
    public List<T> findList(Class<T> clazz, Map<String, Object> map, String sqlId);

}


