package com.findmyfriends.alpha.repository.impl;


import com.findmyfriends.alpha.domain.Admin;
import com.findmyfriends.alpha.repository.AdminRepository;
import org.springframework.stereotype.Repository;


import java.lang.annotation.Annotation;
import java.util.*;

public class AdminRepositoryImpl implements AdminRepository {

    private static AdminRepositoryImpl adminRepository = null;
    private Set<Admin> admins;

    public AdminRepositoryImpl(){
        admins = new HashSet<>();
    }

    public static AdminRepositoryImpl getAdminRepository() {

        if(adminRepository == null){
            return new AdminRepositoryImpl();
        }

        return adminRepository;
    }


    public Admin create(Admin admin) {
        admins.add(admin);
        return admin;
    }


    public Admin read(String id) {

        return admins.stream().filter(admin -> admin.getAdmin().equals(id)).findAny().orElse(null);

    }


    public Admin update(Admin admin) {

        Admin inDB = read(admin.getAdmin());

        if(inDB != null){
            admins.remove(inDB);
            admins.add(admin);
            return admin;
        }

        return null;
    }


    public void delete(String id) {

        Admin inDB = read(id);
        admins.remove(inDB);
    }

    @Override
    public Set<Admin> getAll() {

        return admins;
    }



    public String value() {
        return null;
    }


    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
