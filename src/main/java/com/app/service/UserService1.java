package com.app.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.dto.UserDto1;
import com.app.exception.ResourceNotFoundException;
import com.app.repo.RoleRepository1;
import com.app.repo.UserRepository;
import com.app.repo.UserRepository1;
import com.app.entity.User1;



@Service
public class  UserService1 {
	
	@Autowired
	private UserRepository1 userRepositroy;
	@Autowired
	RoleRepository1 roleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	
	public UserDto1 create(UserDto1 userDto) {
		  User1 user=this.toEntity(userDto);
		        String passEncode = this.passwordEncoder.encode(user.getPassword());
		        user.setPassword(passEncode);
		  User1 userCreate=this.userRepositroy.save(user);
		return this.toDto(userCreate);
	}

	public UserDto1 update(UserDto1 t, int userId) {
		User1 u=userRepositroy.findById(userId).orElseThrow(()->new ResourceNotFoundException("User not found by this id"));
		u.setPhone(t.getPhone());
		u.setPassword(t.getPassword());
		u.setName(t.getName());
		u.setGender(t.getGender());
		u.setEmail(t.getEmail());
		u.setDate(t.getDate());
		u.setAddress(t.getAddress());
		u.setActive(t.isActive());
		u.setAbout(t.getAbout());
		User1 Updateuser=this.userRepositroy.save(u);
		return this.toDto(Updateuser);
	}


	public void delete(int userId) {
		com.app.entity.User1 u=userRepositroy.findById(userId).orElseThrow(() ->new ResourceNotFoundException("UserId not Found"));
		        userRepositroy.delete(u);
	
	}


	public List<UserDto1> getAll() {
	        List<User1> alluser=userRepositroy.findAll();	
		               List<UserDto1> allUserDto=alluser.stream().map(user -> this.toDto(user)).collect(Collectors.toList());
		
		return allUserDto;
	}


	public UserDto1 getByUserId(int userId) {
				User1 finduser=userRepositroy.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User Not Found"+userId));
		          
				return this.toDto(finduser); 
	}


	public UserDto1 getByEmailId(String emailId) {
		       User1 findemail=userRepositroy.findByEmail(emailId).orElseThrow(() -> new ResourceNotFoundException("User Email Is is Not Exit"+emailId));
		return this.toDto(findemail);
	}
	@Autowired
	private ModelMapper mapper;
	public UserDto1 toDto(User1 u) {
//		UserDto dto=new UserDto();
//		dto.setUserId(u.getUserId());
//		dto.setName(u.getName());
//		dto.setEmail(u.getEmail());
//		dto.setPassword(u.getPassword());
//		dto.setAbout(u.getAbout());
//		dto.setAddress(u.getAddress());
//		dto.setGender(u.getGender());
//		dto.setDate(u.getDate());
//		dto.setPhone(u.getPhone());
//		dto.setActive(u.isActive());
		//dto.setRoles(u.getRoles());
		//return dto;
		
		return this.mapper.map(u,UserDto1.class);
	}
	
public User1 toEntity(UserDto1 dto) {
//	User  u=new User();
//	u.setUserId(dto.getUserId());
//	u.setPhone(dto.getPhone());
//	u.setPassword(dto.getPassword());
//	u.setName(dto.getName());
//	u.setGender(dto.getGender());
//	u.setEmail(dto.getEmail());
//	u.setDate(dto.getDate());
//	u.setAddress(dto.getAddress());
//	u.setActive(dto.isActive());
//	u.setAbout(dto.getAbout());
//	//u.setRoles(u.getRoles());
//	return u;
	return this.mapper.map(dto,User1.class);
}
}
