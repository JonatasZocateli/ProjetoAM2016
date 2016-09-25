package br.com.jangada.managedbean;

import br.com.jangada.bd.Investidor;
import br.com.jangada.dao.InvestidorDAO;



public class CadastrarInvestidor {
	
	private Investidor investidor;

	public Investidor getInvestidor() {
		return investidor;
	}

	public void setInvestidor(Investidor investidor) {
		this.investidor = investidor;
	}
	
	public CadastrarInvestidor(){
		investidor = new Investidor();
	}
	
	public String incluirInvestidor(){
		try{
			InvestidorDAO dao = new InvestidorDAO();
			dao.persist(investidor);
			
			return "confirmacao";
		}catch(Exception e){
			return "error";
		}
	}
	
	

}
