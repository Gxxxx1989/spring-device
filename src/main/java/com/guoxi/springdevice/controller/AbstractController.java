package com.guoxi.springdevice.controller;

import com.guoxi.springdevice.Repository.AbstractRepository;
import com.guoxi.springdevice.common.AbstractEntity;
import com.guoxi.springdevice.mapper.AbstractMapper;
import com.guoxi.springdevice.mybatis.entity.UserEntity;
import com.guoxi.springdevice.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author guoxi@tg-hd.com
 * @since 2022/6/9$
 */
public class AbstractController<T extends AbstractEntity, R extends AbstractRepository<T>, M extends AbstractMapper<T>, S extends AbstractService<T, R, M>> {

    @Autowired
    private S service;

    @GetMapping(value = "/selectOne")
    public T selectOne(String id) {
        return service.getData(id);
    }

    @PostMapping(value = "/savaOrUpdateData")
    public T savaOrUpdateUser(@RequestBody T entity) {
        return service.saveOrUpdateData(entity);
    }

    @DeleteMapping(value = "/deleteUser")
    public Boolean deleteUser(@RequestBody T entity) {
        return service.deleteData(entity);
    }

    @PostMapping
    public List<T> listAll() {
        return service.listAllData();
    }
}