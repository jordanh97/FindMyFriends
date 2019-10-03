package com.findmyfriends.alpha.service.impl;

import com.findmyfriends.alpha.domain.Admin;
import com.findmyfriends.alpha.repository.hibernate.AdminRepositoryHibernate;
import com.findmyfriends.alpha.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("AdminServiceImpl")
public class AdminServiceImpl implements AdminService {

    private AdminServiceImpl service = null;
    @Autowired
    private AdminRepositoryHibernate repository;

    public AdminServiceImpl(){

    }

    public AdminServiceImpl getService(){
        if (service == null){
            service = new AdminServiceImpl();
        }
        return service;
    }

    @Override
    public Set<Admin> getAll() {

        List<Admin> list = (List<Admin>) repository.findAll();

        return new HashSet<>(list);
    }

    @Override
    public Admin create(Admin appointment) {
        return this.repository.save(appointment);
    }

    @Override
    public Admin read(String integer) {
        return this.repository.findById(integer).orElse(null);
    }

    @Override
    public Admin update(Admin appointment) {
        return this.repository.save(appointment);
    }

    @Override
    public void delete(String integer) {

        repository.deleteById(integer);
    }
}