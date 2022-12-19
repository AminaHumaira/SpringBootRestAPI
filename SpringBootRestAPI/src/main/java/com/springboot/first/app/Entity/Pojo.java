package com.springboot.first.app.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pojo 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int id;
	private String name;
	private String address;
	
	public int getId()
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getAddress() 
	{
		return address;
	}
	public void setAddress(String address) 
	{
		this.address = address;
	}
	public Pojo(int id, String name, String address) 
	{
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	public Pojo()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() 
	{
		return "Pojo [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
	

}
