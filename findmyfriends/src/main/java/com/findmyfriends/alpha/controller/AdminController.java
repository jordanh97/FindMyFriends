package com.findmyfriends.alpha.controller;

import com.findmyfriends.alpha.domain.Admin;
import com.findmyfriends.alpha.service.Impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;


import java.util.Set;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    @Qualifier("AdminServiceImpl")
    private AdminServiceImpl service;

    @PostMapping("/new")
    public Admin create(@RequestBody Admin Admin){

        return service.create(Admin);
    }

    @GetMapping(path = "/find/{id}")
    public Admin findById(@PathVariable String id){

        Admin Admin = service.read(id);

        return Admin;
    }

    @PutMapping("/update")
    public void update(@RequestBody Admin Admin){

        service.update(Admin);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/getall")
    public Set<Admin> getAll(){
        return service.getAll();
    }

}

