package br.com.jangada.managedbean;

import br.com.jangada.bd.Investimento;
import br.com.jangada.dao.InvestimentoDAO;

public class CadastrarInvestimento {
	
	private Investimento investimento;

	public Investimento getInvestimento() {
		return investimento;
	}

	public void setInvestimento(Investimento investimento) {
		this.investimento = investimento;
	}
	
	public CadastrarInvestimento(){
		investimento = new Investimento();
	}
	
	public String incluirInvestimento(){
		try{
			InvestimentoDAO dao = new InvestimentoDAO();
			dao.persist(investimento);
			
			return "confirmacao";
		}catch(Exception e){
			return "erro";
		}
	}
	
}
