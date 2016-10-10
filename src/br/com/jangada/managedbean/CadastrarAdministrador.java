package br.com.jangada.managedbean;


import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.jangada.bd.Administrador;
import br.com.jangada.bo.FiltroPesquisas;
import br.com.jangada.dao.AdministradorDAO;


@SessionScoped
public class CadastrarAdministrador {
	
	private Administrador administrador;
	private List<Administrador> listaAdministrador;
	private String repetirSenha;
	private String pesquisa;
	private int filtroPrincipal;
	private int filtroCondicional;
	private int filtroExclusivo;
	private int filtroLinha = 1;
	private int tipoPesquisa;
	
	public List<Administrador> getListaAdministrador() {
		return listaAdministrador;
	}

	public void setListaAdministrador(List<Administrador> listaAdministrador) {
		this.listaAdministrador = listaAdministrador;
	}

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

	
	
	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}
	
		
	public List<Administrador> getlistaAdministrador(){		
		
		
		return  listaAdministrador;
	}
	
	
	public String getRepetirSenha() {
		return repetirSenha;
	}

	public void setRepetirSenha(String repetirSenha) {
		this.repetirSenha = repetirSenha;
	}
	
	public CadastrarAdministrador(){
		administrador = new Administrador();
		listaAdministrador = new ArrayList<Administrador>();
	}
	
	public String incluirAdministrador(){
		
		try{
			AdministradorDAO dao = new AdministradorDAO();
			dao.persist(administrador);
			
			return listarAdministradores();
		}catch(Exception e){
			return "error";
		}
				
	}	
	
	public String atualizarAdministrador(){
		
		try{
			AdministradorDAO dao = new AdministradorDAO();
			dao.attachDirty(administrador);
			
			if (tipoPesquisa == 1)
				return listarAdministradores();
			
			return pesquisarAdministrador();
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
			AdministradorDAO dao = new AdministradorDAO(); 
			listaAdministrador.clear();
			listaAdministrador = dao.listaAdministrador();
			tipoPesquisa = 1;
			
			return "listausuarios";
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
			
			return listarAdministradores();
		}catch(Exception e){
			return "erro";
		}
		
	}
	
	public String pesquisarAdministrador(){
		try{
			FiltroPesquisas pesq = new FiltroPesquisas();	
			listaAdministrador.clear();
			listaAdministrador = pesq.pesquisaAdministrador(filtroPrincipal, filtroLinha, filtroCondicional, filtroExclusivo, pesquisa);			
			tipoPesquisa  = 2;
			
			return "listausuario";
		}catch(Exception e){
			return "erro";
		}
		
	}
	public String editarAdministrador(Administrador administrador){
		try{
			this.administrador = administrador;
			
			return "editarusuario";
		}catch(Exception e){
			return "erro";
		}
		
		
	}

}
