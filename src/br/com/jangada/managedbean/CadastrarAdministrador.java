package br.com.jangada.managedbean;

import java.util.ArrayList;
import java.util.List;

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
	
	private List<Administrador> listaAdministrador;
	
	public List<Administrador> getlistaAdministrador() {
		return listaAdministrador;
	}
	
	public CadastrarAdministrador(){
		administrador = new Administrador();
		//listaAdministrador = new ArrayList<Administrador>();
		
		AdministradorDAO dao = new AdministradorDAO();
		listaAdministrador = dao.listaAdministrador(administrador);
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
	
	public String listarAdministradores(){
		
		try{
			AdministradorDAO dao = new AdministradorDAO();
			listaAdministrador = dao.listaAdministrador(administrador);
			
			return "listausuarios.jsf";
		}catch(Exception e){
			return "error";
		}
	}
	

}
