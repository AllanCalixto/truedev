package br.com.truedev.ecommerce.security;

public class ECToken {
	public String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public ECToken(String token) {
		super();
		this.token = token;
	}

	public ECToken() {
		super();
	}
	
	
}
