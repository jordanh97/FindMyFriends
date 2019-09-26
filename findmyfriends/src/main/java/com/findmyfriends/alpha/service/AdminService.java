package com.findmyfriends.alpha.service;

import com.findmyfriends.alpha.domain.Admin;
import com.findmyfriends.alpha.repository.IRepository;

import java.util.Set;

public interface AdminService extends IRepository<Admin, String> {

    Set<Admin> getAll();
}
