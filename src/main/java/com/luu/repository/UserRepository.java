package com.luu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luu.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
