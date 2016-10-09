package br.com.jangada.bo;

import java.util.List;

import br.com.jangada.bd.Noticias;
import br.com.jangada.dao.NoticiasDAO;

public class FiltroPesquisas {
	
	
	public List<Noticias> pesquisaConteudo(int filtro, String pesquisa){
		NoticiasDAO dao = new NoticiasDAO();
		List<Noticias> list = null;
		
		if (filtro == 1){
			//Noticias nt = new Noticias();			
			//nt.setIdNoticias(Integer.parseInt(pesquisa));
			
			list = dao.findByExample("idNoticias", Integer.parseInt(pesquisa));
		}
		
		return list;
				
	}

}
