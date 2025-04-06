package com.complaintProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.complaintProject.Model.User;

public interface UserRepository extends JpaRepository<User,Integer>{

}
