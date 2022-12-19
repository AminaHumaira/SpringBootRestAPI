package com.springboot.first.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.first.app.Entity.Pojo;
import com.springboot.first.app.Repository.Repository;

@RestController
public class Controller 
{
	
	@Autowired
	Repository repo;
	
	@PostMapping("/postdata")
	public ResponseEntity<Pojo> postdata(@RequestBody Pojo p)
	{
		return new ResponseEntity<>(repo.save(p),HttpStatus.OK);
	}
	
	@GetMapping("/getdata")
	public ResponseEntity<List<Pojo>> getdata()
	{
		return new ResponseEntity<>(repo.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/getdata/{id}")
	public ResponseEntity<Pojo> getsingledata(@PathVariable int id)
	{
		Optional<Pojo> obj=repo.findById(id);
		if(obj.isPresent())
		{
			return new ResponseEntity<>(obj.get(),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/putdata/{id}")
	public ResponseEntity<Pojo> putdata(@PathVariable int id,@RequestBody Pojo p)
	{
		Optional<Pojo> obj=repo.findById(id);
		if(obj.isPresent())
		{
			obj.get().setId(p.getId());
			obj.get().setName(p.getName());
			obj.get().setAddress(p.getAddress());
			return new ResponseEntity<>(repo.save(obj.get()),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/deletedata/{id}")
	public ResponseEntity<Pojo> deletedata(@PathVariable int id)
	{
		Optional<Pojo> obj=repo.findById(id);
		if(obj.isPresent())
		{
			repo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
