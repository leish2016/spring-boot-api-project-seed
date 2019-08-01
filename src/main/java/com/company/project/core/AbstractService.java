package com.company.project.core;


import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 基于通用MyBatis Mapper插件的Service接口的实现
 */
public abstract class AbstractService<T> {

    @Autowired
    protected Mapper<T> mapper;

    /**
     * 保存数据
     */
    public T save(T model) {
        mapper.insertSelective(model);
        return mapper.selectOne(model);
    }


    /**
     * 根据id删除数据
     */
    public int deleteById(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }


    /**
     * 更新数据
     */
    public T update(T model) {
        mapper.updateByPrimaryKeySelective(model);
        return mapper.selectOne(model);
    }

    /**
     * 根据id获取数据
     */
    public T findById(Long id) {
        return mapper.selectByPrimaryKey(id);
    }


    /**
     * 获取全部数据
     */
    public List<T> findAll() {
        return mapper.selectAll();
    }
}
