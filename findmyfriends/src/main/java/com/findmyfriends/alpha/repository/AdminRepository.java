package com.findmyfriends.alpha.repository;

import com.findmyfriends.alpha.domain.Admin;
import org.springframework.data.repository.Repository;


import java.util.Set;

public interface AdminRepository extends Repository<Admin, String> {

    Set<Admin> getAll();

}