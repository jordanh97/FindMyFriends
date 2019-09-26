package com.findmyfriends.alpha.repository.impl;

import com.findmyfriends.alpha.domain.Admin;
import com.findmyfriends.alpha.repository.AdminRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
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

