package br.com.ideias;

public class UserEmail {
	
	private final Long id;
	private final String email;
	
	
	public UserEmail(Long id, String email) {
		super();
		this.id = id;
		this.email = email;
	}
	
	
	public Long getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	
	

}
