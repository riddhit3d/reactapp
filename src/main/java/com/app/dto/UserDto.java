package com.app.dto;

import jakarta.persistence.Column;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @NotBlank(message = "email should not be blank")
    @Email(message = "invalid email address")
    private String email;

    @NotBlank(message = "password should not be blank")
    private String password;

    @NotBlank(message = "name should not be blank")
    private String firstName;

    @NotBlank(message = "lastname required")
    private String lastName;

    @NotBlank(message = "location is mandatory")
    private String location;

    @Pattern(regexp = "^\\d{10}$",message = "invalid mobile number entered ")
    private String mobile;

    @Min(15)
    @Max(60)
    private int age;

    private String role;

	public UserDto(
			@NotBlank(message = "email should not be blank") @Email(message = "invalid email address") String email,
			@NotBlank(message = "password should not be blank") String password,
			@NotBlank(message = "name should not be blank") String firstName,
			@NotBlank(message = "lastname required") String lastName,
			@NotBlank(message = "location is mandatory") String location,
			@Pattern(regexp = "^\\d{10}$", message = "invalid mobile number entered ") String mobile,
			@Min(15) @Max(60) int age, String role) {
		super();
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.location = location;
		this.mobile = mobile;
		this.age = age;
		this.role = role;
	}

	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


}
