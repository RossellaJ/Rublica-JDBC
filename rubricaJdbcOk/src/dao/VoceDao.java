package dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.Map;

import model.Voce;

public class VoceDao {      //devo creare metodi C R U D

	// Metodo utile al metodo 1) per scrivere create(come avere in output id della voce(quale
	// tipo di ritorno)
	public int trovaIdVoce(String telefono) {
		int id = 0;

		Connection con = null;
		String sql = "select id_voce from VOCE where telefono=?";
		PreparedStatement pst = null;
		ResultSet res = null;

		try {
			con = DataSource.getInstance().getConnection();
			pst = con.prepareStatement(sql);

			pst.setString(1, telefono);
			res = pst.executeQuery();

			if (res.next()) { // se esiste
				id = res.getInt(1);
			}
		} catch (SQLException | IOException | PropertyVetoException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		} finally {

			if (pst != null)

				try {

					pst.close();

				} catch (SQLException e) {

					e.printStackTrace();

				}

		}
		return id;

	}
	
	//1) CREATE

	public Voce creaVoce(String nome,String cognome,String telefono,int id_rubrica){
		
		Voce voce=null;
		
		Connection con = null;
	    String sql="insert into VOCE(NOME,COGNOME,TELEFONO,ID_RUBRICA) VALUES (?,?,?,?)";
		PreparedStatement pst = null;
		int res = 0;
		
		try {
			con = DataSource.getInstance().getConnection();
			pst= con.prepareStatement(sql);
			
			
			pst.setString(1, nome);
			pst.setString(2, cognome);
			pst.setString(3, telefono);
			pst.setInt(4,id_rubrica);
			
			res= pst.executeUpdate();

			if(res==1){
				
				VoceDao vD = new VoceDao();
				voce= new Voce(vD.trovaIdVoce(telefono),nome,cognome,telefono);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException | PropertyVetoException e1) {
			e1.printStackTrace();
		
		}finally{
			
			if (pst != null) try { pst.close(); } catch (SQLException e) {e.printStackTrace();}
			if (con != null) try { con.close(); } catch (SQLException e) {e.printStackTrace();}
		}
		
		return voce;
	
	}


		
		
		
		
	
	//2)READ
    public Voce leggiVoceconId(int id_voce , int id_rubrica){
    	
    	Voce voce=null;
		
		Connection con = null;
	    String sql="select * from Voce where id_voce=? and id_rubrica=?";
		PreparedStatement pst = null;
		ResultSet res = null;
		
		try {
			
			pst = con.prepareStatement(sql);
			pst.setInt(1,id_voce);
			pst.setInt(2,id_rubrica);
			res=pst.executeQuery(); 
			
			if(res.next()){		//se esiste
				
				int id_voce1=res.getInt(1);
				String nome =res.getString(2);
				String cognome =res.getString(3);
				String telefono =res.getString(4);
				int id_rubrica1=res.getInt(5);
						
				voce=new Voce(id_voce,nome,cognome,telefono,id_rubrica);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
			if (pst != null) try { pst.close(); } catch (SQLException e) {e.printStackTrace();}
			if (con != null) try { con.close(); } catch (SQLException e) {e.printStackTrace();}
		}
		
		return voce;
    
}
	// 2b) READ
    public Voce leggiVoceConNominativo(String nome, String cognome,int id_rubrica){
    	Voce voce=null;
		
		Connection con = null;
	    String sql="select * from Voce where nome=? and cognome=? and id_rubrica=?";
		PreparedStatement pst = null;
		ResultSet res = null;
		
		try {
			
			pst = con.prepareStatement(sql);
			pst.setString(1,nome);
			pst.setString(2,cognome);
			pst.setInt(3,id_rubrica);
			res=pst.executeQuery(); 
			
			if(res.next()){		//se esiste
				
				int id_voce1=res.getInt(1);
				String nome1 =res.getString(2);
				String cognome1 =res.getString(3);
				String telefono =res.getString(4);
				int id_rubrica1=res.getInt(5);
						
				voce=new Voce(id_voce1,nome1,cognome1,telefono,id_rubrica);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
			if (pst != null) try { pst.close(); } catch (SQLException e) {e.printStackTrace();}
			if (con != null) try { con.close(); } catch (SQLException e) {e.printStackTrace();}
		}
		
		return voce;
    
}	
    	
    //READ 3) tutte le voci
    public Map<Integer,Voce> leggiTutteleVoci(int id_rubrica){
    	
		Map<Integer, Voce> contatti = null;
		Voce voce=null;
		
		Connection con = null;
	    String sql="select * from Voce where id_rubrica=?";
		PreparedStatement pst = null;
		ResultSet res = null;
		
		try {
			
			pst = con.prepareStatement(sql);
			pst.setInt(1,id_rubrica);
			res=pst.executeQuery(); 
			
				if(res.next()){		//se esiste
				
				int id_voce1=res.getInt(1);
				String nome1 =res.getString(2);
				String cognome1 =res.getString(3);
				String telefono =res.getString(4);
				int id_rubrica1=res.getInt(5);
						
				voce=new Voce(id_voce1,nome1,cognome1,telefono,id_rubrica);
				contatti.put(voce.getId_voce(), voce);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
			if (pst != null) try { pst.close(); } catch (SQLException e) {e.printStackTrace();}
			if (con != null) try { con.close(); } catch (SQLException e) {e.printStackTrace();}
		}
		
		return contatti;
    	
    }
    
    
    
    // 3)UPDATE
    public boolean aggiornaVoce(int id_voce, String nome,String cognome,String telefono){
		
    	boolean prendeAggiorna=false;
    	
    	Connection con = null;
	    String sql="update VOCE set nome=?,cognome=?,telefono=? where id_voce=?";
		PreparedStatement pst = null;
		int res = 0;
		
		try {
			con = DataSource.getInstance().getConnection();
			pst= con.prepareStatement(sql);
			
			pst.setString(1, nome);
			pst.setString(2, cognome);
			pst.setString(3, telefono);
			pst.setInt(4, id_voce);
			
			res= pst.executeUpdate();

			if(res==1){
				
				prendeAggiorna=true;
			}
    	
		return prendeAggiorna;
    	
		} catch (SQLException | IOException | PropertyVetoException e) {


			e.printStackTrace();

		}finally{

			if (pst != null)

				try {

					pst.close();

				} catch (SQLException e) {

					e.printStackTrace();

				}

		}	return prendeAggiorna;
    }
  
		//4)DELETE
		
		public boolean rimuoviVoce(int id_voce){

			boolean prendeElimina = false;

			Connection con = null;
		    String sql="delete from VOCE  where id_voce=?";
			PreparedStatement pst = null;
			int res = 0;

			try {

				con = DataSource.getInstance().getConnection();
				pst = con.prepareStatement(sql);

				pst.setInt(1, id_voce);

				 res = pst.executeUpdate();

				if(res==1){

					prendeElimina = true;

				}

			} catch (SQLException | IOException | PropertyVetoException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}finally{

				if (pst != null)

					try {

						pst.close();

					} catch (SQLException e) {

						e.printStackTrace();

					}

			}

			return prendeElimina;

		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
    
    }   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   	

    
		

