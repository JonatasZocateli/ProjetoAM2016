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
			
			
			return "confirmacao";
		}catch(Exception e){
			return "erro";
		}
		
		
	}
	
	public String listarNoticias(){
		try{
			List<Noticias> list = new NoticiasDAO().listaNoticias(noticias);
			listaNoticias = new ArrayList<Noticias>(list);
			
			return "listagem";
		}catch(Exception e){
			return "erro";
		}
	}
	
	public String listarNoticiasIndex(){
		try{
			List<Noticias> list = new NoticiasDAO().listaNoticias(noticias);
			listaNoticias = new ArrayList<Noticias>(list);
			
			return "index";
		}catch(Exception e){
			return "erro";
		}
	}
	
	public String excluirNoticias(Noticias nt){
		try{
			NoticiasDAO dao = new NoticiasDAO();
			dao.delete(nt);		
			
			return listarNoticias();
		}catch(Exception e){
			return "erro";
		}
		
	}
	
	public String pesquisarNoticias(){
		try{
			FiltroPesquisas pesq = new FiltroPesquisas();			
			listaNoticias = pesq.pesquisaConteudo(1, pesquisa);			
			
			return "listagem";
		}catch(Exception e){
			return "erro";
		}
		
	}
	
	

}
