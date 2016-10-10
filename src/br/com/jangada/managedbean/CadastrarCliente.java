package br.com.jangada.managedbean;



import java.util.ArrayList;
import java.util.List;

import br.com.jangada.bd.Clientes;
import br.com.jangada.bo.FiltroPesquisas;
import br.com.jangada.dao.ClientesDAO;



public class CadastrarCliente {
	
	private Clientes cliente;
	private String pesquisa;
	private int filtroPrincipal;
	private int filtroCondicional;
	private int filtroExclusivo;
	private int filtroLinha = 1;
	private int tipoPesquisa;
	
	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}

	public int getFiltroPrincipal() {
		return filtroPrincipal;
	}

	public void setFiltroPrincipal(int filtroPrincipal) {
		this.filtroPrincipal = filtroPrincipal;
	}

	public int getFiltroCondicional() {
		return filtroCondicional;
	}

	public void setFiltroCondicional(int filtroCondicional) {
		this.filtroCondicional = filtroCondicional;
	}

	public int getFiltroExclusivo() {
		return filtroExclusivo;
	}

	public void setFiltroExclusivo(int filtroExclusivo) {
		this.filtroExclusivo = filtroExclusivo;
	}

	public int getFiltroLinha() {
		return filtroLinha;
	}

	public void setFiltroLinha(int filtroLinha) {
		this.filtroLinha = filtroLinha;
	}

	public int getTipoPesquisa() {
		return tipoPesquisa;
	}

	public void setTipoPesquisa(int tipoPesquisa) {
		this.tipoPesquisa = tipoPesquisa;
	}

	public void setListaCliente(List<Clientes> listaCliente) {
		this.listaCliente = listaCliente;
	}

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
		return listaCliente;
	}
	
	public void setListaClientes(List<Clientes> listaCliente){
		this.listaCliente = listaCliente;
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
    
    public String atualizarClientes(){
		
		try{
			ClientesDAO dao = new ClientesDAO();
			dao.attachDirty(cliente);
			if (tipoPesquisa == 1)
    			listarClientes();
    		
    		return pesquisarClientes();
		}catch(Exception e){
			return "error";
		}
	}
    
    public String listarClientes(){
    	try{
    		ClientesDAO dao = new ClientesDAO();
    		listaCliente.clear();
    		listaCliente = dao.listarClientes();
    		tipoPesquisa  = 1;
    		
    		return "listaclientes";
    	}catch(Exception e){
    		return "erro";
    	}
    }
    
    public String excluirCliente(Clientes cl){
    	try{    		
    		ClientesDAO dao = new ClientesDAO();
    		dao.delete(cl);
    		
    		if (tipoPesquisa == 1)
    			return listarClientes();
    		
    		return pesquisarClientes();
    	}catch(Exception e){
    		return "erro";
    	}
    }
    
    public String pesquisarClientes(){
		try{
			FiltroPesquisas pesq = new FiltroPesquisas();	
			listaCliente.clear();
			listaCliente = pesq.pesquisaClientes(filtroPrincipal, filtroLinha, filtroCondicional, filtroExclusivo, pesquisa);			
			tipoPesquisa  = 2;
			
			return "listaclientes";
		}catch(Exception e){
			return "erro";
		}
		
	}

    public String limparPesquisa(){
		try{
			pesquisa = null;
			filtroPrincipal = 1;
			filtroCondicional = 1;
			filtroExclusivo = 0;
			filtroLinha = 1;
			tipoPesquisa = 1;
			
			return listarClientes();
		}catch(Exception e){
			return "erro";
		}
		
	}
    
    public String editarCliente(Clientes cliente){
		try{
			this.cliente = cliente;
			
			return "editarclientes";
		}catch(Exception e){
			return "erro";
		}
	}


}
