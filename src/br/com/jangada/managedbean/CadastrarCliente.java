package br.com.jangada.managedbean;

<<<<<<< HEAD
=======
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

>>>>>>> e09a970b6c9424b77550ec6abf194106510739b7
import br.com.jangada.bd.Clientes;
import br.com.jangada.dao.ClientesDAO;



public class CadastrarCliente {
	
	private Clientes cliente;
	
<<<<<<< HEAD
	
=======
>>>>>>> e09a970b6c9424b77550ec6abf194106510739b7
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
<<<<<<< HEAD
			ClientesDAO dao = new ClientesDAO();
=======
			
			/*
			cliente.setNomeCliente("Davi");
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			java.sql.Date data = new java.sql.Date(format.parse("13/05/1981").getTime());
			cliente.setNascimentoCliente(data);
			cliente.setEmailCliente("testes@teste.com");
			*/
			
			ClientesHome dao = new ClientesHome();
>>>>>>> e09a970b6c9424b77550ec6abf194106510739b7
			dao.persist(cliente);
			
			return "confirmacao";
		}catch(Exception e){
			return "error";
		}
	}


}
