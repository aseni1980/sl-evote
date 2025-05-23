package com.aseni.slevote.service;


import com.aseni.slevote.model.AbstractModel;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.Optional;

public abstract class AbstractService<T extends Serializable> {

    private static final int PAGE_SIZE = 5;
    protected abstract JpaRepository<T, Long> getRepository();

    public T save(T entity) {
        return getRepository().save(entity);
    }

    public T get(Long id) {
        Optional<T> entityOpt = getRepository().findById(id);
        T entity = entityOpt.get();
        return entity;
    }

    public void delete(Long id) {
        try {
            getRepository().deleteById(id);
        } catch (EmptyResultDataAccessException e) {}
    }


}