package br.com.jangada.managedbean;

import java.util.ArrayList;
import java.util.List;

import br.com.jangada.bd.Investimento;
import br.com.jangada.bo.FiltroPesquisas;
import br.com.jangada.dao.InvestimentoDAO;

public class CadastrarInvestimento {
	
	private Investimento investimento;
	private List<Investimento> listaInvestimento;
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

	public List<Investimento> getListaInvestimento() {
		return listaInvestimento;
	}

	public void setListaInvestimento(List<Investimento> listaInvestimento) {
		this.listaInvestimento = listaInvestimento;
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

	
	public Investimento getInvestimento() {
		return investimento;
	}

	public void setInvestimento(Investimento investimento) {
		this.investimento = investimento;
	}
	
	public CadastrarInvestimento(){
		investimento = new Investimento();
		listaInvestimento = new ArrayList<Investimento>();
	}
	
	public String incluirInvestimento(){
		try{
			InvestimentoDAO dao = new InvestimentoDAO();
			dao.persist(investimento);
			
			return listarInvestimentos();
		}catch(Exception e){
			return "erro";
		}
	}
	
	public String atualizarInvestimento(){
		try{
			InvestimentoDAO dao = new InvestimentoDAO();
			dao.attachDirty(investimento);
			
			
			if (tipoPesquisa == 1)
				return listarInvestimentos();
			
			return pesquisarInvestimento();
		}catch(Exception e){
			return "erro";
		}
	}
	
	public String listarInvestimentos(){
		try{
			InvestimentoDAO dao = new InvestimentoDAO();
			listaInvestimento.clear();
			listaInvestimento = dao.listaInvestimento();
			tipoPesquisa = 1;
			
			return "listaplanos";
		}catch(Exception e){
			return "erro";
		}
	}
	
	public String selecaoInvestimentos(){
		try{
			InvestimentoDAO dao = new InvestimentoDAO();
			listaInvestimento.clear();
			listaInvestimento = dao.listaInvestimento();
			tipoPesquisa = 1;
			
			return "escolhaplano";
		}catch(Exception e){
			return "erro";
		}
	}
	
	public String excluirInvestimento(Investimento inv){
		try{
			InvestimentoDAO dao = new InvestimentoDAO();
			dao.delete(inv);		
			
			if (tipoPesquisa == 1)
				return listarInvestimentos();
			
			return pesquisarInvestimento();
		}catch(Exception e){
			return "erro";
		}
		
	}
	
	public String pesquisarInvestimento(){
		try{
			FiltroPesquisas pesq = new FiltroPesquisas();	
			listaInvestimento.clear();
			listaInvestimento = pesq.pesquisaInvestimento(filtroPrincipal, filtroLinha, filtroCondicional, filtroExclusivo, pesquisa);			
			tipoPesquisa  = 2;
			
			return "listaplanos";
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
			
			return listarInvestimentos();
		}catch(Exception e){
			return "erro";
		}
		
	}

	public String editarInvestimento(Investimento investimento){
		try{
			this.investimento = investimento;
			
			return "editarinvestimento";
		}catch(Exception e){
			return "erro";
		}
	}
	 
}

