package com.findmyfriends.alpha.service.impl;

import com.findmyfriends.alpha.domain.Admin;
import com.findmyfriends.alpha.service.AdminService;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("AdminServiceImpl")
public class AdminServiceImpl implements AdminService {

    private static  AdminServiceImpl repository = null;
    private Set<Admin> Admins;

    public AdminServiceImpl(){
        Admins = new HashSet<>();
    }


    public static AdminServiceImpl getRepository() {

        if(repository == null){
            return new AdminServiceImpl();
        }
        return repository;
    }

    @Override
    public Admin create(Admin adminInstance) {

        Admins.add(adminInstance);
        return adminInstance;
    }

    @Override
    public Admin read(String id) {

        return Admins.stream().filter(adminInstance -> adminInstance.getAdmin().equals(id)).findAny().orElse(null);
    }

    @Override
    public Admin update(Admin adminInstance) {

        Admin inDB = read(adminInstance.getAdmin());

        if(inDB != null){
            Admins.remove(inDB);
            Admins.add(adminInstance);
            return adminInstance;
        }

        return null;
    }

    @Override
    public void delete(String id) {

        Admin inDB = read(id);
        Admins.remove(inDB);

    }

    @Override
    public Set<Admin> getAll() {
        return Admins;
    }

}

