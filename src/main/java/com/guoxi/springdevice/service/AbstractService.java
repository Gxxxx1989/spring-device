package com.guoxi.springdevice.service;

import com.google.common.collect.Lists;
import com.guoxi.springdevice.Repository.AbstractRepository;
import com.guoxi.springdevice.common.AbstractEntity;
import com.guoxi.springdevice.mapper.AbstractMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * 基础通用service,增删改查数据
 *
 * @author guoxi@tg-hd.com
 * @since 2022/6/9$
 */
public abstract class AbstractService<T extends AbstractEntity, R extends AbstractRepository<T>, M extends AbstractMapper<T>> {

    @SuppressWarnings("all")
    @Autowired
    private R repository;


    @SuppressWarnings("all")
    @Autowired
    private M mapper;

    public T getData(String id) {
        return repository.findById(id).orElse(null);
    }

    public T saveOrUpdateData(T entity) {
        return repository.save(entity);
    }

    public Boolean deleteData(T entity) {
        repository.delete(entity);
        return getData(entity.getId()) == null;
    }

    public List<T> listAllData() {
        Iterable<T> all = repository.findAll();
        ArrayList<T> arrayList = Lists.newArrayList(all);
        return arrayList;
    }
}
