package com.example.hiberRegistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hiberRegistration.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
