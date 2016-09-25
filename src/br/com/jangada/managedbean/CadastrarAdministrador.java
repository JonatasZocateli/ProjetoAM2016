package br.com.jangada.managedbean;

import br.com.jangada.bd.Administrador;
import br.com.jangada.dao.AdministradorDAO;

public class CadastrarAdministrador {
	
	private Administrador administrador;
	private String repetirSenha;

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}
	
	public CadastrarAdministrador(){
		administrador = new Administrador();
	}
	
	public String getRepetirSenha() {
		return repetirSenha;
	}

	public void setRepetirSenha(String repetirSenha) {
		this.repetirSenha = repetirSenha;
	}
	
	public String incluirAdministrador(){
		
		try{
			AdministradorDAO dao = new AdministradorDAO();
			dao.persist(administrador);
			
			return "confirmacao";
		}catch(Exception e){
			return "error";
		}
				
	}
	
	
	

}
