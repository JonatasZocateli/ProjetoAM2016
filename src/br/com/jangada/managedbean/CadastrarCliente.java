package br.com.jangada.managedbean;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import br.com.jangada.bd.Clientes;
import br.com.jangada.dao.ClientesHome;

public class CadastrarCliente {
	
	private Clientes cliente;
	
	public Clientes getClientes(){
		return cliente;
	}
	
	public void setClientes(Clientes cliente){
		this.cliente = cliente;
	}
	
	public CadastrarCliente(){
		cliente = new Clientes();
	}
	
	public String incluirClientes(){
		
		try{
			//ClientesHome dao = new ClientesHome();
			//dao.persist(cliente);
			
			return "confirmacao";
		}catch(Exception e){
			return "error";
		}
	}

}
