package com.findmyfriends.alpha.repository;

public interface IRepository<T, ID>{
    T create(T t);

    T read(ID id);

    T update(T t);

    void delete(ID id);
}