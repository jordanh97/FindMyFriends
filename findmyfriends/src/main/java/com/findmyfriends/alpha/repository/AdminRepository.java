package com.findmyfriends.alpha.repository;

import com.findmyfriends.alpha.domain.Admin;
import com.findmyfriends.alpha.repository.IRepository;

import java.util.Set;

public interface AdminRepository extends IRepository<Admin, String>{

    Set<Admin> getAll();
}
