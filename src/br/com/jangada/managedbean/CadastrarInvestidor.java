package br.com.jangada.managedbean;

import java.util.ArrayList;
import java.util.List;

import br.com.jangada.bd.Investidor;
import br.com.jangada.bd.Noticias;
import br.com.jangada.bo.FiltroPesquisas;
import br.com.jangada.dao.InvestidorDAO;
import br.com.jangada.dao.NoticiasDAO;



public class CadastrarInvestidor {
	
	private Investidor investidor;
	private List listaInvestidor;
	private String pesquisa;
	private int filtroPrincipal;
	private int filtroCondicional;
	private int filtroExclusivo;
	private int filtroLinha = 1;
	private int tipoPesquisa;
	
	public List getListaInvestidor() {
		return listaInvestidor;
	}

	public void setListaInvestidor(List listaInvestidor) {
		this.listaInvestidor = listaInvestidor;
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

	
	
	public Investidor getInvestidor() {
		return investidor;
	}

	public void setInvestidor(Investidor investidor) {
		this.investidor = investidor;
	}
	
	public CadastrarInvestidor(){
		investidor = new Investidor();
		listaInvestidor = new ArrayList<Investidor>();
	}
	
	public String incluirInvestidor(){
		try{
			InvestidorDAO dao = new InvestidorDAO();
			dao.persist(investidor);
			
			return "confirmacao";
		}catch(Exception e){
			return "erro";
		}
	}
	
	public String atualizarInvestidor(){
		try{
			InvestidorDAO dao = new InvestidorDAO();
			dao.attachDirty(investidor);
			
			if (tipoPesquisa == 1)
				return listarInvestidor();
			
			return pesquisarInvestidor();
		}catch(Exception e){
			return "erro";
		}
	}
	
	public String listarInvestidor(){
		try{
			InvestidorDAO dao = new InvestidorDAO();
			listaInvestidor.clear();
			listaInvestidor = dao.listaInvestidor();			
			tipoPesquisa = 1;
			
			return "listainvestidores";
		}catch(Exception e){
			return "erro";
		}
	}
	
	public String excluirInvestidor(Investidor inv){
		try{
			InvestidorDAO dao = new InvestidorDAO();
			dao.delete(inv);		
			
			if (tipoPesquisa == 1)
				return listarInvestidor();
			
			return pesquisarInvestidor();
		}catch(Exception e){
			return "erro";
		}
		
	}
	
	public String pesquisarInvestidor(){
		try{
			FiltroPesquisas pesq = new FiltroPesquisas();	
			listaInvestidor.clear();
			listaInvestidor = pesq.pesquisaInvestidor(filtroPrincipal, filtroLinha, filtroCondicional, filtroExclusivo, pesquisa);			
			tipoPesquisa  = 2;
			
			return "listainvestidores";
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
			
			return listarInvestidor();
		}catch(Exception e){
			return "erro";
		}
		
	}

	public String editarInvestidor(Investidor investidor){
		try{
			this.investidor = investidor;
			
			return "editarinvestidor";
		}catch(Exception e){
			return "erro";
		}
	}
	

}
