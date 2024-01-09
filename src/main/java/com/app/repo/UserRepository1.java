package com.app.repo;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.User1;


public interface UserRepository1 extends JpaRepository<User1,Integer>
{
	
	public Optional<User1>findByEmail(String email);
	 public   List<User1>findByName(String name);
	  public User1 findByEmailAndPassword(String email,String name);
	   public   List<User1>findByActiveTrue();
        public    List<User1>    findByAboutIsNotNull();
        public List<User1> findByNameStartingWith(String prifix);
        public List<User1> findByNameContaining(String infix);
        public List<User1> findByNameLike(String like);
        

        
        
        // Createing Query Method
        @Query("select u from User u")
        public List<User1> getAllUser();
        
       
	  
}
