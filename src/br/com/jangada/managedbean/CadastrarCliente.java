package br.com.jangada.managedbean;



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


}
