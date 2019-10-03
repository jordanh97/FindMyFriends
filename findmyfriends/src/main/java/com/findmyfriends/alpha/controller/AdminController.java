package com.findmyfriends.alpha.controller;

import com.findmyfriends.alpha.domain.Admin;

import com.findmyfriends.alpha.repository.impl.AdminRepositoryImpl;
import com.findmyfriends.alpha.service.AdminService;
import com.findmyfriends.alpha.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminServiceImpl adminService;

    @PostMapping("/new")
    public Admin create(@RequestBody Admin t) {

        return adminService.create(t);
    }

    @GetMapping(path = "/find/{id}")
    public Admin findById(@PathVariable String id){

        Admin admin = adminService.read(id);
        return admin;
    }

    @PutMapping("/update")
    public void update(@RequestBody Admin admin){

        adminService.update(admin);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){
        adminService.delete(id);
    }

    @GetMapping("/getAll")
    public Set<Admin> getAll(){
        return adminService.getAll();
    }


}

