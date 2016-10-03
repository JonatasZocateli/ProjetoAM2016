package br.com.jangada.managedbean;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Part;

import br.com.jangada.bd.Noticias;
import br.com.jangada.dao.NoticiasDAO;

public class CadastrarNoticias {
	
	private Noticias noticias;
	private Part arquivo;

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
	}
	
	private List<Noticias> listaNoticias;
	
	public List<Noticias> getListaNoticias(){
		List<Noticias> list = new NoticiasDAO().listaNoticias(noticias);
		listaNoticias = new ArrayList<Noticias>(list);
		
		return listaNoticias;
	}
	
	public String incluirNoticias(){
		try{
			String nomeArquivo = null; 
			nomeArquivo = getFileName(arquivo);		
			
			arquivo.write("C:\\uploadfile\\"+getFileName(arquivo));			
			noticias.setUrlImagem(nomeArquivo);
			
			NoticiasDAO dao = new NoticiasDAO();
			dao.persist(noticias);			
			
			
			return "confirmacao";
		}catch(Exception e){
			return "erro";
		}
		
		
	}
	
	public String listarNoticias(){
		try{
			return "listagem";
		}catch(Exception e){
			return "erro";
		}
	}
	
	public String excluirNoticias(Noticias noticia){
		try{
			NoticiasDAO dao = new NoticiasDAO();
			dao.delete(noticia);		
			
			return listarNoticias();
		}catch(Exception e){
			return "erro";
		}
		
	}
	
	public static String getFileName(Part part){
		for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
	}
	
	

}
