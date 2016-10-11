package dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Rubrica;
import model.Voce;

public class Rubricadao {

	// 1) CREATE
	public boolean creaRubrica(String nome) {
		
			boolean creata=false;
			
			Connection con = null;
		    String sql="insert into RUBRICA(NOME) VALUES (?)";
			PreparedStatement pst = null;
			int res = 0;
			
			try {
				con = DataSource.getInstance().getConnection();
				pst= con.prepareStatement(sql);
				
				pst.setString(1, nome);
				res= pst.executeUpdate();

				if(res==1){
					
					creata=true;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException | PropertyVetoException e1) {
				e1.printStackTrace();
			
			}finally{
				
				if (pst != null) try { pst.close(); } catch (SQLException e) {e.printStackTrace();}
				if (con != null) try { con.close(); } catch (SQLException e) {e.printStackTrace();}
			}
			
			return creata;
		
		}

	

		
		
	
	//2)READ
    public  Rubrica leggiRubricaconId(int id_rubrica){
    	
    	Rubrica rubrica =null;
		
		Connection con = null;
	    String sql="select * from RUBRICA where id_rubrica=?";
		PreparedStatement pst = null;
		ResultSet res = null;
		
		try {
			
			pst = con.prepareStatement(sql);
			pst.setInt(1,id_rubrica);
			res=pst.executeQuery(); 
			
			if(res.next()){		//se esiste
				
				int id_rubrica1=res.getInt(1);
				String nome =res.getString(2);
				
				Rubrica rubrica1 = new Rubrica(id_rubrica,nome);
				rubrica= rubrica1;
			}
			
		} catch (SQLException e) {

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

		return rubrica;

	}
	
	
	
		
    // 3)UPDATE
    public boolean aggiornaRubrica(int id_rubrica, String nome){
		
    	boolean prendeAggiorna=false;
    	
    	Connection con = null;
	    String sql="update RUBRICA set id_rubrica=?,nome=?";
		PreparedStatement pst = null;
		int res = 0;
		
		try {
			con = DataSource.getInstance().getConnection();
			pst= con.prepareStatement(sql);
			
			pst.setInt(1, id_rubrica);
			pst.setString(2, nome);
			
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
		    String sql="delete from RUBRICA  where id_rubrica=?";
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

