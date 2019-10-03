package com.findmyfriends.alpha.service;


import com.findmyfriends.alpha.domain.Admin;

import java.util.Set;

public interface AdminService extends IService<Admin, String> {

    Set<Admin> getAll();

}
