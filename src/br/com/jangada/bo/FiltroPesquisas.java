package br.com.jangada.bo;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.faces.convert.BigDecimalConverter;

import org.hibernate.mapping.Value;

import br.com.jangada.bd.Administrador;
import br.com.jangada.bd.Clientes;
import br.com.jangada.bd.Investidor;
import br.com.jangada.bd.Investimento;
import br.com.jangada.bd.Noticias;
import br.com.jangada.dao.AdministradorDAO;
import br.com.jangada.dao.ClientesDAO;
import br.com.jangada.dao.InvestidorDAO;
import br.com.jangada.dao.InvestimentoDAO;
import br.com.jangada.dao.NoticiasDAO;

public class FiltroPesquisas {
	
	
	public List<Noticias> pesquisaNoticias(int filtroPrincipal, int filtroLinha, int filtroCondicional, 
			                               int filtroExclusivo, String pesquisa){
		NoticiasDAO dao = new NoticiasDAO();
		List<Noticias> list = null;
				
		switch (filtroPrincipal) {
		case 1:
			  list = dao.findByExample("idNoticias", Integer.parseInt(pesquisa));
			break;
        case 2:
        	if (filtroCondicional == 1)        		
        		list = dao.findByExample("tituloNoticia", pesquisa);        	 
        	else        		
            	list = dao.findByConteudo("tituloNoticia", pesquisa, filtroLinha, filtroCondicional, filtroExclusivo);	
			break;
        case 3:
        	if (filtroCondicional == 1) 
        		list = dao.findByExample("subtituloNoticia", pesquisa);
        	else
        		list = dao.findByConteudo("subtituloNoticia", pesquisa, filtroLinha, filtroCondicional, filtroExclusivo);
			break;
        case 4:
        	if (filtroCondicional == 1) 
        		list = dao.findByExample("conteudoNoticia", pesquisa);
        	else
        		list = dao.findByConteudo("conteudoNoticia", pesquisa, filtroLinha, filtroCondicional, filtroExclusivo);
			break;		
		}
		return list;				
	}
	
	public List<Administrador> pesquisaAdministrador(int filtroPrincipal, int filtroLinha, int filtroCondicional, 
            	int filtroExclusivo, String pesquisa){
			AdministradorDAO dao = new AdministradorDAO();
			List<Administrador> list = null;

			switch (filtroPrincipal) {
			case 1:
				list = dao.findByExample("idAdministrador", Integer.parseInt(pesquisa));
				break;
			case 2:
				if (filtroCondicional == 1)        		
					list = dao.findByExample("loginAdministrador", pesquisa);        	 
				else        		
					list = dao.findByConteudo("loginAdministrador", pesquisa, filtroLinha, filtroCondicional, filtroExclusivo);	
				break;
			case 3:
				if (filtroCondicional == 1) 
					list = dao.findByExample("email", pesquisa);
				else
					list = dao.findByConteudo("email", pesquisa, filtroLinha, filtroCondicional, filtroExclusivo);
				break;	
			}
			return list;				
		}
	
	public List<Clientes> pesquisaClientes(int filtroPrincipal, int filtroLinha, int filtroCondicional, 
            int filtroExclusivo, String pesquisa){
		ClientesDAO dao = new ClientesDAO();
		List<Clientes> list = null;
		
		switch (filtroPrincipal) {
		case 1:
			list = dao.findByExample("idClientes", Integer.parseInt(pesquisa));
			break;
		case 2:
			if (filtroCondicional == 1)        		
				list = dao.findByExample("nomeCliente", pesquisa);        	 
			else        		
				list = dao.findByConteudo("nomeCliente", pesquisa, filtroLinha, filtroCondicional, filtroExclusivo);	
			break;
		case 3:
			if (filtroCondicional == 1) 
				list = dao.findByExample("emailCliente", pesquisa);
			else
				list = dao.findByConteudo("emailCliente", pesquisa, filtroLinha, filtroCondicional, filtroExclusivo);
			break;
		case 4:
			list = dao.findByExample("nascimentoCliente", Date.parse(pesquisa));			
			break;	
		case 5:
			if (filtroCondicional == 1) 
				list = dao.findByExample("bairroCliente", pesquisa);
			else
				list = dao.findByConteudo("bairroCliente", pesquisa, filtroLinha, filtroCondicional, filtroExclusivo);
			break;	
		case 6:
			if (filtroCondicional == 1) 
				list = dao.findByExample("cidadeCliente", pesquisa);
			else
				list = dao.findByConteudo("cidadeCliente", pesquisa, filtroLinha, filtroCondicional, filtroExclusivo);
			break;	
		case 7:
			if (filtroCondicional == 1) 
				list = dao.findByExample("estadoCliente", pesquisa);
			else
				list = dao.findByConteudo("estadoCliente", pesquisa, filtroLinha, filtroCondicional, filtroExclusivo);
			break;
		case 8:
			if (filtroCondicional == 1) 
				list = dao.findByExample("paisCliente", pesquisa);
			else
				list = dao.findByConteudo("paisCliente", pesquisa, filtroLinha, filtroCondicional, filtroExclusivo);
			break;	
		}
		return list;				
	}
	
	public List<Investimento> pesquisaInvestimento(int filtroPrincipal, int filtroLinha, int filtroCondicional, 
            int filtroExclusivo, String pesquisa) throws ParseException{
		InvestimentoDAO dao = new InvestimentoDAO();
		List<Investimento> list = null;

		switch (filtroPrincipal) {
		case 1:
			list = dao.findByExample("idInvestimento", Integer.parseInt(pesquisa));
			break;
		case 2:
			if (filtroCondicional == 1)        		
				list = dao.findByExample("descricaoInvestimento", pesquisa);        	 
			else        		
				list = dao.findByConteudo("descricaoInvestimento", pesquisa, filtroLinha, filtroCondicional, filtroExclusivo);	
			break;
		case 3:
			list = dao.findByExample("quantidadeInvestimento", Integer.parseInt(pesquisa));
			
			break;
		case 4: 
			DecimalFormatSymbols symbols = new DecimalFormatSymbols();
			symbols.setGroupingSeparator(',');
			symbols.setDecimalSeparator('.');
			String pattern = "#,##0.0#";
			DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
			decimalFormat.setParseBigDecimal(true);
			
			BigDecimal bigDecimal = (BigDecimal) decimalFormat.parse(pesquisa); 
			list = dao.findByExample("valorInvestimento", bigDecimal);			
			break;		
		}
		return list;				
	}
	
	public List<Investidor> pesquisaInvestidor(int filtroPrincipal, int filtroLinha, int filtroCondicional, 
            int filtroExclusivo, String pesquisa){
		InvestidorDAO dao = new InvestidorDAO();
		List<Investidor> list = null;
		
		switch (filtroPrincipal) {
		case 1:
			list = dao.findByExample("idInvestidor", Integer.parseInt(pesquisa));
			break;
		case 2:
			if (filtroCondicional == 1)        		
				list = dao.findByExample("nomeInvestidor", pesquisa);        	 
			else        		
				list = dao.findByConteudo("nomeInvestidor", pesquisa, filtroLinha, filtroCondicional, filtroExclusivo);	
			break;
		case 3:
			if (filtroCondicional == 1) 
				list = dao.findByExample("emailInvestidor", pesquisa);
			else
				list = dao.findByConteudo("emailInvestidor", pesquisa, filtroLinha, filtroCondicional, filtroExclusivo);
			break;
		case 4:
			list = dao.findByExample("nascimentoInvestidor", Date.parse(pesquisa));			
			break;	
		case 5:
			if (filtroCondicional == 1) 
				list = dao.findByExample("nomeEmpresaInvestidor", pesquisa);
			else
				list = dao.findByConteudo("nomeEmpresaInvestidor", pesquisa, filtroLinha, filtroCondicional, filtroExclusivo);
			break;	
		case 6:
			if (filtroCondicional == 1) 
				list = dao.findByExample("cidadeInvestidor", pesquisa);
			else
				list = dao.findByConteudo("cidadeInvestidor", pesquisa, filtroLinha, filtroCondicional, filtroExclusivo);
			break;	
		case 7:
			if (filtroCondicional == 1) 
				list = dao.findByExample("estadoInvestidor", pesquisa);
			else
				list = dao.findByConteudo("estadoInvestidor", pesquisa, filtroLinha, filtroCondicional, filtroExclusivo);
			break;
		case 8:
			if (filtroCondicional == 1) 
				list = dao.findByExample("paisInvestidor", pesquisa);
			else
				list = dao.findByConteudo("paisInvestidor", pesquisa, filtroLinha, filtroCondicional, filtroExclusivo);
			break;	
		}
		return list;				
	}
	
	
	
	
}
