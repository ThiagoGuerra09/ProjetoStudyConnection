package model;


public class Usuario {
	
	private String email;
	private String name;
	private String lastname;
	private String password;
	private int id;
	public Usuario() {
		this.email = email;
		this.name = name;
		this.lastname = lastname;
		this.password = password;
		this.id = id;
	}
	
	public Usuario(String email, String name, String lastname, String password, int id) {
		this.email = email;
		this.name = name;
		this.lastname = lastname;
		this.password = password;
		this.id = id;
	}

	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}

	public String getLastname() {
		// TODO Auto-generated method stub
		return lastname;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	public int getid() {
		return id;
	
	}
	
}