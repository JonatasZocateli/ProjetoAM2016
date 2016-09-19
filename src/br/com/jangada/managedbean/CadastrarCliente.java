package br.com.jangada.managedbean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import br.com.jangada.bd.Clientes;
import br.com.jangada.dao.ClientesHome;


public class CadastrarCliente {
	
	private Clientes cliente;
	
	public Clientes getCliente(){
		return cliente;
	}
	
	public void setCliente(Clientes cliente){
		this.cliente = cliente;
	}
	
	public CadastrarCliente(){
		cliente = new Clientes();
	}
	
	public String incluirClientes(){
		
		try{
			
			/*
			cliente.setNomeCliente("Davi");
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			java.sql.Date data = new java.sql.Date(format.parse("13/05/1981").getTime());
			cliente.setNascimentoCliente(data);
			cliente.setEmailCliente("testes@teste.com");
			*/
			
			ClientesHome dao = new ClientesHome();
			dao.persist(cliente);
			
			return "confirmacao";
		}catch(Exception e){
			return "error";
		}
	}

}
