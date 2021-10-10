package com.servme.todo.todoapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.servme.todo.todoapplication.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
