package com.jwebcoder.groceryauth.common.repository;


import com.jwebcoder.groceryauth.common.entity.PersonalInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalInfoRepository extends CrudRepository<PersonalInfo, String> {
}
