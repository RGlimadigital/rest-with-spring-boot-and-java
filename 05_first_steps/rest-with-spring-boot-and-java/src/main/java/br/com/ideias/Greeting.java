package br.com.ideias;

public class Greeting {
	
	private final Long id;
	private final String cotent;
	
	
	public Greeting(Long id, String cotent) {
		this.id = id;
		this.cotent = cotent;
	}


	public Long getId() {
		return id;
	}


	public String getCotent() {
		return cotent;
	}
	
		
	
}
