package com.servme.todo.todoapplication.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servme.todo.todoapplication.entity.Item;
import com.servme.todo.todoapplication.entity.User;
import com.servme.todo.todoapplication.repository.ItemRepository;
import com.servme.todo.todoapplication.repository.UserRepository;

@Service
public class ItemService {
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	UserRepository userRepository;

	public Item addItem(Item item) {
		if(item.getUserMappingId()!=null) {
			User user = userRepository.findById(item.getUserMappingId()).orElse(null);
			item.setUser(user);
		}
		return itemRepository.save(item);
	}

	public List<Item> getItemByCategory(String category) {
		List<Item> items = itemRepository.findAll();
		List<Item> filteredList = items.stream()
			.filter(item -> item.getCategory().equalsIgnoreCase(category))
			.collect(Collectors.toList());
		
		return filteredList!=null?filteredList:null;
	}
	
	

}
