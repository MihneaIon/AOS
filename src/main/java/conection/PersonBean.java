package conection;

import javax.sql.DataSource;

public class PersonBean {
	
	private int idperson;
	private String name;
	private String email;

	public PersonBean() {
		
	}

	public PersonBean(int idperson, String name, String email) {
		this.idperson = idperson;
		this.name = name;
		this.email = email;
	}

	public int getIdpersoana() {
		return idperson;
	}
	public void setIdpersoana(int idpersoana) {
		this.idperson = idpersoana;
	}
	public String getName() {
		return name;
	}
	public void setName(String nume) {
		this.name = nume;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
