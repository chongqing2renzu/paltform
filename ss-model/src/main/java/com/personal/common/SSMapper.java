package com.personal.common;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.MySqlMapper;
import tk.mybatis.mapper.common.SqlServerMapper;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

public interface SSMapper<T> extends BaseMapper<T>, ConditionMapper<T> ,SqlServerMapper<T>{

    /**
     * 根据实体中的属�?�进行查询，只能有一个返回�?�，有多个结果是抛出异常，查询条件使用等�?
     *
     * @param record
     * @return
     */
    default public T selectTheOne(T record) {
        PageHelper.startPage(1, 1, false);
        return selectOne(record);
    }

    /**
     * 单表分页查询
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    default public List<T> selectPage(int pageNum, int pageSize, T record) {
        PageHelper.startPage(pageNum, pageSize);
        return select(record);
    }

    /**
     * 单表分页查询
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    default public PageInfo<T> selectPage(T record, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<T>(select(record));
    }

    /**
     * 单表分页查询
     *
     * @param condition 条件
     * @param pageNum
     * @param pageSize
     * @return
     */
    default public PageInfo<T> selectPage(Condition condition, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<T>(selectByCondition(condition));
    }
}
