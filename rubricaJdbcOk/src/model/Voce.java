package model;

public class Voce {
	
	private int id_voce;
	private String nome;
	private String cognome;
	private String telefono;
	private int id_rubrica;
	
	
	
	
	
	
//Costruttori

	public Voce(int id_voce, String nome, String cognome, String telefono,
			int id_rubrica) {
		
		this.id_voce = id_voce;
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
		this.id_rubrica = id_rubrica;
	}


	public Voce() {
		
	}


	public Voce(int id_voce, String nome, String cognome, String telefono) {
	
		this.id_voce = id_voce;
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
	}


	
	
	
	public int getId_voce() {
		return id_voce;
	}


	public void setId_voce(int id_voce) {
		this.id_voce = id_voce;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	public int getId_rubrica() {
		return id_rubrica;
	}
	
	
	public void setId_rubrica(int id_rubrica) {
		this.id_rubrica = id_rubrica;
	}

}
