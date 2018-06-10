package com.user.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.user.model.User;

 
 
@Transactional
public interface UserDAO  extends CrudRepository<User, Integer>{

}
