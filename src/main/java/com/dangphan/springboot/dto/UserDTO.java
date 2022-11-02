package com.dangphan.springboot.dto;

import java.util.ArrayList;
import java.util.List;

public class UserDTO extends AbstractDTO<UserDTO> {
	
	private String userName;
	private String password;
	private String fullName;
	private Integer status;
	private List<String> roleNames = new ArrayList<String>();
	
	private String token;
	
	public UserDTO() {
	}

	public UserDTO(String userName, String password, String fullName, Integer status, List<String> roleNames) {
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.status = status;
		this.roleNames = roleNames;
	}
	
	public UserDTO(String token, String userName) {
        this.token = token;
		this.userName = userName;
    }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<String> getRoleNames() {
		return roleNames;
	}

	public void setRoleNames(List<String> roleNames) {
		this.roleNames = roleNames;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
}
