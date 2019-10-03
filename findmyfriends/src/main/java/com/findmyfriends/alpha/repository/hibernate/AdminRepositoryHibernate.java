package com.findmyfriends.alpha.repository.hibernate;

import com.findmyfriends.alpha.domain.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepositoryHibernate extends CrudRepository<Admin, String> {


}
