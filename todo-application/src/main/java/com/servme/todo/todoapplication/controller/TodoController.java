package com.servme.todo.todoapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servme.todo.todoapplication.entity.User;
import com.servme.todo.todoapplication.service.TodoService;

@RestController
@RequestMapping("/todo")
public class TodoController {
	
	@Autowired
	TodoService todoService;
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return todoService.addUser(user);
	}
	
	@GetMapping("/{id}")
	public User getUser(@PathVariable Long id) {
		return todoService.getUser(id);
	}
	
	@PutMapping("/")
	public User editUserDetails(@RequestBody User user) {
		return todoService.editUser(user);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable Long id) {
		return todoService.deleteUser(id);
	}

}
