package model;

public class Rubrica {
	
	private int id_rubrica;
	private String nome;
	
	//costruttori
	public Rubrica() {
	}


	public Rubrica(int id_rubrica, String nome) {
		this.id_rubrica = id_rubrica;
		this.nome = nome;
	}

	
	
	public Rubrica(String nome) {
		// TODO Auto-generated constructor stub
	}


	//getter setter
	public int getId_rubrica() {
		return id_rubrica;
	}


	public void setId_rubrica(int id_rubrica) {
		this.id_rubrica = id_rubrica;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
