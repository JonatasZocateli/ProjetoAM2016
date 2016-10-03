package br.com.jangada.managedbean;



import java.util.ArrayList;
import java.util.List;

import br.com.jangada.bd.Clientes;
import br.com.jangada.dao.ClientesDAO;



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
		listaCliente = new ArrayList<Clientes>();
	}
	
	private List<Clientes> listaCliente;
	
	public List<Clientes> getListaCliente() {		
		List<Clientes> list = new ClientesDAO().listarClientes(cliente);
		listaCliente = new ArrayList<Clientes>(list);
		
		return listaCliente;
	}
	
    public String incluirClientes(){
		
		try{
			ClientesDAO dao = new ClientesDAO();
			dao.persist(cliente);
			
			return "confirmacao";
		}catch(Exception e){
			return "error";
		}
	}
    
    public String listarClientes(){
    	try{
    		
    		
    		return "listaClientes";
    	}catch(Exception e){
    		return "erro";
    	}
    }
    
    public String excluirCliente(Clientes cliente){
    	try{    		
    		ClientesDAO dao = new ClientesDAO();
    		dao.delete(cliente);
    		
    		return listarClientes();
    	}catch(Exception e){
    		return "erro";
    	}
    }

	


}
