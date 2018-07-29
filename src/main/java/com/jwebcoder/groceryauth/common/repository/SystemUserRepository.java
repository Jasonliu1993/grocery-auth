package com.jwebcoder.groceryauth.common.repository;


import com.jwebcoder.groceryauth.common.entity.SystemUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemUserRepository extends CrudRepository<SystemUser, String> {
}
