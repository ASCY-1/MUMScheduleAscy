package com.ascy.security;

public class UserToken {
	public static final String secretKey = "ascygroupSecretkey";
	private String token;

	public UserToken(String compact) {
		token= compact;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
