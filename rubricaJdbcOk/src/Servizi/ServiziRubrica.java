package Servizi;

import java.util.Map;

import dao.VoceDao;
import model.Rubrica;
import model.Voce;

public class ServiziRubrica {
	
	VoceDao vD = new VoceDao();
	
	// aggiungiVoce
	public Voce aggiungiVoce(Rubrica r,String nome, String cognome, String telefono) {

		Voce voce = vD.creaVoce(nome, cognome, telefono, r.getId_rubrica() );

		return voce;
	}
	
	//ottieniVoce
	public Voce getVoce(Rubrica r, String nome, String cognome){
		
		Voce voce = vD.leggiVoceConNominativo(nome, cognome, r.getId_rubrica());
		
		return voce;
		
	}
	
	//ottieni tutte le voci
	public Map<Integer, Voce> getAll(Rubrica r){
		
		return vD.leggiTutteleVoci(r.getId_rubrica());
	}
	
	//modifica voce
	public Voce updateVoce(Rubrica r, String nomeVecchio, String cognomeVecchio, 
			String nome, String cognome, String telefono){
		
		Voce v = vD.leggiVoceConNominativo(nomeVecchio, cognomeVecchio, r.getId_rubrica());
		
		if(v!=null){
		vD.aggiornaVoce(v.getId_voce(), nome, cognome, telefono); //ritorna boolean...non posso mettere v= vD.agg
		v = vD.leggiVoceConNominativo(nome, cognome, r.getId_rubrica());
		}
		return v;
	}
	
	//delete
	public void deleteVoce(Rubrica r, String nome, String cognome){
		Voce v = vD.leggiVoceConNominativo(cognome, cognome, r.getId_rubrica());
		vD.rimuoviVoce(v.getId_voce());		
}
	
	
}
