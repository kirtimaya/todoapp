package com.servme.todo.todoapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servme.todo.todoapplication.entity.Item;
import com.servme.todo.todoapplication.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	ItemService itemService;
	
	@PostMapping("/addItem")
	public Item addItem(@RequestBody Item item) {
		return itemService.addItem(item);
	}
	
	@GetMapping("/getItem/{category}")
	public List<Item> getItemByCategory(@PathVariable String category) {
		return itemService.getItemByCategory(category);
	}

}
