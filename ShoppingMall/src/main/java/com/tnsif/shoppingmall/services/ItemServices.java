package com.tnsif.shoppingmall.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tnsif.shoppingmall.entity.Item;
import com.tnsif.shoppingmall.entity.User;
import com.tnsif.shoppingmall.repository.ItemRepository;
import com.tnsif.shoppingmall.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ItemServices {
	@Autowired
	private ItemRepository repo;
	
	
	public List<Item> listAll(){
		return repo.findAll();
	}
	
	public void save(Item item)  {
		repo.save(item);
	}   
	
	public Item get(Integer id) {
		return repo.findById(id).get();
	}
	 public void delete(Integer id) 
	 {
	 repo.deleteById(id);
	 }
}
