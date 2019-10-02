package com.findmyfriends.alpha.repository.impl;

import com.findmyfriends.alpha.domain.User;
import com.findmyfriends.alpha.repository.UserRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository("UserInMemory")
public class UserRepositoryImpl implements UserRepository {
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public List<User> findAll(Sort sort) {
        return null;
    }

    @Override
    public List<User> findAllById(Iterable<String> iterable) {
        return null;
    }

    @Override
    public <S extends com.findmyfriends.alpha.domain.User> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends com.findmyfriends.alpha.domain.User> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<User> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public User getOne(String s) {
        return null;
    }

    @Override
    public <S extends com.findmyfriends.alpha.domain.User> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends com.findmyfriends.alpha.domain.User> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends com.findmyfriends.alpha.domain.User> S save(S s) {
        return null;
    }

    @Override
    public Optional<User> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void deleteAll(Iterable<? extends User> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends com.findmyfriends.alpha.domain.User> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends com.findmyfriends.alpha.domain.User> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends com.findmyfriends.alpha.domain.User> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends com.findmyfriends.alpha.domain.User> boolean exists(Example<S> example) {
        return false;
    }

    private static  UserRepositoryImpl repository = null;
    private Set<User> Users;

    public UserRepositoryImpl(){
        Users = new HashSet<>();
    }


    public static UserRepositoryImpl getRepository() {

        if(repository == null){
            return new UserRepositoryImpl();
        }
        return repository;
    }

    public User create(User userInstance) {

        Users.add(userInstance);
        return userInstance;
    }

    public User read(String id) {

        return Users.stream().filter(userInstance -> userInstance.getUser().equals(id)).findAny().orElse(null);
    }

    public User update(User userInstance) {

        User inDB = read(userInstance.getUser());

        if(inDB != null){
            Users.remove(inDB);
            Users.add(userInstance);
            return userInstance;
        }

        return null;
    }

    public void delete(String id) {

        User inDB = read(id);
        Users.remove(inDB);

    }

    @Override
    public Set<User> getAll() {
        return Users;
    }

}

