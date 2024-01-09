package com.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Role1;


@Repository
public interface RoleRepository1 extends JpaRepository<Role1,Integer> {
	 

}
