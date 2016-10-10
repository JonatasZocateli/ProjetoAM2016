package br.com.jangada.managedbean;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Part;

import br.com.jangada.bd.Noticias;
import br.com.jangada.bo.FiltroPesquisas;
import br.com.jangada.bo.IncluirImagem;
import br.com.jangada.dao.NoticiasDAO;


public class CadastrarNoticias {
	
	private Noticias noticias;
	private Part arquivo;
	private String pesquisa;
	private int filtroPrincipal;
	private int filtroCondicional;
	private int filtroExclusivo;
	private int filtroLinha = 1;
	private int tipoPesquisa;
	
	public int getFiltroExclusivo() {
		return filtroExclusivo;
	}

	public void setFiltroExclusivo(int filtroExclusivo) {
		this.filtroExclusivo = filtroExclusivo;
	}

	public int getFiltroCondicional() {
		return filtroCondicional;
	}

	public void setFiltroCondicional(int filtroCondicional) {
		this.filtroCondicional = filtroCondicional;
	}

	public int getTipoPesquisa() {
		return tipoPesquisa;
	}

	public void setTipoPesquisa(int tipoPesquisa) {
		this.tipoPesquisa = tipoPesquisa;
	}

	public int getFiltroPrincipal() {
		return filtroPrincipal;
	}

	public void setFiltroPrincipal(int filtroPrincipal) {
		this.filtroPrincipal = filtroPrincipal;
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}

	public Noticias getNoticias() {
		return noticias;
	}

	public void setNoticias(Noticias noticias) {
		this.noticias = noticias;
	}
	
	public Part getArquivo(){
		return arquivo;
	}
	
	public void setArquivo(Part arquivo){
		this.arquivo = arquivo;
	}
	
	public int getFiltroLinha() {
		return filtroLinha;
	}

	public void setFiltroLinha(int filtroLinha) {
		this.filtroLinha = filtroLinha;
	}
	
	public CadastrarNoticias(){
		noticias = new Noticias();
		listaNoticias = new ArrayList<Noticias>();
	}
	
	private List<Noticias> listaNoticias;
	
	public List<Noticias> getListaNoticias(){			
		return listaNoticias;
	}
	
	
	public String incluirNoticias(){
		try{
			IncluirImagem bo = new IncluirImagem();		
			String urlImagem = bo.incluirImagem(arquivo);
			
			noticias.setUrlImagem(urlImagem);
			
			NoticiasDAO dao = new NoticiasDAO();
			dao.persist(noticias);			
			
			
			return listarNoticias();
		}catch(Exception e){
			return "erro";
		}
		
		
	}
	
	public String atualizarNoticias(){
		try{
			IncluirImagem bo = new IncluirImagem();		
			String urlImagem = bo.incluirImagem(arquivo);			
			noticias.setUrlImagem(urlImagem);
			
			NoticiasDAO dao = new NoticiasDAO();
			dao.attachDirty(noticias);			
			
			if (tipoPesquisa == 1)
				return listarNoticias();
			
			return pesquisarNoticias();
		}catch(Exception e){
			return "erro";
		}
	}
	
	
	public String listarNoticias(){
		try{
			NoticiasDAO dao = new NoticiasDAO();
			listaNoticias = dao.listaNoticias();			
			tipoPesquisa = 1;
			
			return "listagem";
		}catch(Exception e){
			return "erro";
		}
	}
	
	public String listarNoticiasIndex(){
		try{
			NoticiasDAO dao = new NoticiasDAO();
			listaNoticias = dao.listaNoticias();
			
			return "index";
		}catch(Exception e){
			return "erro";
		}
	}
	
	public String excluirNoticias(Noticias nt){
		try{
			NoticiasDAO dao = new NoticiasDAO();
			dao.delete(nt);		
			
			if (tipoPesquisa == 1)
				return listarNoticias();
			
			return pesquisarNoticias();
		}catch(Exception e){
			return "erro";
		}
		
	}
	
	public String pesquisarNoticias(){
		try{
			FiltroPesquisas pesq = new FiltroPesquisas();	
			listaNoticias.clear();
			listaNoticias = pesq.pesquisaNoticias(filtroPrincipal, filtroLinha, filtroCondicional, filtroExclusivo, pesquisa);			
			tipoPesquisa  = 2;
			
			return "listagem";
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
			
			return listarNoticias();
		}catch(Exception e){
			return "erro";
		}
		
	}

	public String editarNoticia(Noticias noticia){
		try{
			this.noticias = noticia;
			
			return "editarpostagem";
		}catch(Exception e){
			return "erro";
		}
	}

	
	
	

}
