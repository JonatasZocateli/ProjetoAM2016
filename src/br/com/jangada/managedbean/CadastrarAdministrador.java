package br.com.jangada.managedbean;


import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.jangada.bd.Administrador;
import br.com.jangada.dao.AdministradorDAO;


@SessionScoped
public class CadastrarAdministrador {
	
	private Administrador administrador;
	private List<Administrador> listaAdministrador;
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
		
	public List<Administrador> getlistaAdministrador(){		
		List<Administrador> list = new AdministradorDAO().listaAdministrador(administrador);
		listaAdministrador = new ArrayList<Administrador>(list);
		
		return  listaAdministrador;
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
	
		
	public String excluirAdministrador(Administrador adm){
		try{
			AdministradorDAO dao = new AdministradorDAO();
			dao.delete(adm);
			
			return listarAdministradores();
		}catch(Exception e){
			return "error";
		}
	}
	
	public String listarAdministradores(){
		try{
			
			return "listausuarios";
		}catch(Exception e){
			return "erro";
		}
		
		
	}
	

}
