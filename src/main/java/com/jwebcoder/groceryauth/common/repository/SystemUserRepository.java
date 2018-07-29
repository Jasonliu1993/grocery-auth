package com.jwebcoder.groceryauth.common.repository;


import com.jwebcoder.groceryauth.common.entity.SystemUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemUserRepository extends CrudRepository<SystemUser, String> {

    SystemUser getSystemUserByUserNameOrEmailAndPassword(String userName, String email, String password);

    @Query(value = "SELECT COUNT(*) FROM SYSTEM_USER WHERE USER_NAME = ?1", nativeQuery = true)
    Integer checkUserName(String userName);

    @Query(value = "SELECT COUNT(*) FROM SYSTEM_USER WHERE EMAIL = ?1", nativeQuery = true)
    Integer checkEmail(String email);

}
