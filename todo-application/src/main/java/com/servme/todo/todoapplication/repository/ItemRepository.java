package com.servme.todo.todoapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.servme.todo.todoapplication.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
