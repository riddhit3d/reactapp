package com.app.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginResponse {

    String message;
    Boolean status;
    String firstName;
    String lastName;
    String role;


    public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public LoginResponse(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }

    public LoginResponse(String message, Boolean status, String firstName, String lastName) {
        this.message = message;
        this.status = status;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public LoginResponse(String message, Boolean status, String firstName, String lastName,String role) {
        this.message = message;
        this.status = status;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }
}
