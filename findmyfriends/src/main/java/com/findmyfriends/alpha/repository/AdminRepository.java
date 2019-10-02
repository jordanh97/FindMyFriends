package com.findmyfriends.alpha.repository;

import com.findmyfriends.alpha.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {

    Set<Admin> getAll();

}
