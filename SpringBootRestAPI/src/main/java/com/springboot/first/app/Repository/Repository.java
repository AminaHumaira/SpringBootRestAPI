package com.springboot.first.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.first.app.Entity.Pojo;

public interface Repository extends JpaRepository<Pojo,Integer> 
{

}
