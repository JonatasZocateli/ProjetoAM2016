package br.com.jangada.managedbean;

import br.com.jangada.bd.Administrador;
import br.com.jangada.bo.ValidarLogin;

public class LoginAdministrador {
	
	private Administrador administrador;

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}
	
	public String logarUsuario(){
		try{
			ValidarLogin bo = new ValidarLogin();
			
			if(bo.validaLogin(administrador))
			  return "login";
			else		
			  return "listagem";
		}catch(Exception e){
			return "erro";
		}
	}
	

}
