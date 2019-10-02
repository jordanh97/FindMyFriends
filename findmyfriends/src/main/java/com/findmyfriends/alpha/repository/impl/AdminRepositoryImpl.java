package com.findmyfriends.alpha.repository.impl;

import com.findmyfriends.alpha.domain.Admin;
import com.findmyfriends.alpha.repository.AdminRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository("AdminInMemory")
public class AdminRepositoryImpl implements AdminRepository {

    private static  AdminRepositoryImpl repository = null;
    private Set<Admin> Admins;

    public AdminRepositoryImpl(){
        Admins = new HashSet<>();
    }


    public static AdminRepositoryImpl getRepository() {

        if(repository == null){
            return new AdminRepositoryImpl();
        }
        return repository;
    }


    public Admin create(Admin adminInstance) {

        Admins.add(adminInstance);
        return adminInstance;
    }


    public Admin read(String id) {

        return Admins.stream().filter(adminInstance -> adminInstance.getAdmin().equals(id)).findAny().orElse(null);
    }


    public Admin update(Admin adminInstance) {

        Admin inDB = read(adminInstance.getAdmin());

        if(inDB != null){
            Admins.remove(inDB);
            Admins.add(adminInstance);
            return adminInstance;
        }

        return null;
    }

    public void delete(String id) {

        Admin inDB = read(id);
        Admins.remove(inDB);

    }


    @Override
    public List<Admin> findAll() {
        return null;
    }

    @Override
    public List<Admin> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Admin> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Admin> findAllById(Iterable<String> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(Admin admin) {

    }

    @Override
    public void deleteAll(Iterable<? extends Admin> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends com.findmyfriends.alpha.domain.Admin> S save(S s) {
        return null;
    }

    @Override
    public <S extends com.findmyfriends.alpha.domain.Admin> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Admin> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends com.findmyfriends.alpha.domain.Admin> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Admin> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Admin getOne(String s) {
        return null;
    }

    @Override
    public <S extends com.findmyfriends.alpha.domain.Admin> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends com.findmyfriends.alpha.domain.Admin> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends com.findmyfriends.alpha.domain.Admin> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends com.findmyfriends.alpha.domain.Admin> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends com.findmyfriends.alpha.domain.Admin> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends com.findmyfriends.alpha.domain.Admin> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public Set<Admin> getAll() {
        return null;
    }
}

