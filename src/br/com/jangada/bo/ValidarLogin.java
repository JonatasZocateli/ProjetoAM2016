package br.com.jangada.bo;

import java.util.List;

import br.com.jangada.bd.Administrador;
import br.com.jangada.dao.AdministradorDAO;

public class ValidarLogin {
	
	public Boolean validaLogin(Administrador adm){
		try{
			Boolean uservalido = false;
			
			AdministradorDAO dao = new AdministradorDAO();
			List<Administrador> list = dao.findByExample(adm);
			
			if(! list.isEmpty())
				uservalido = true;
				
			return uservalido;
		}catch(Exception e){
			return false;
		}
		
	}

}
