package br.com.jangada.bo;

import java.io.IOException;

import javax.servlet.http.Part;

public class IncluirImagem {
	
	public String incluirImagem(Part arquivo) throws IOException{
		String nomeArquivo = null; 
		nomeArquivo = getFileName(arquivo);		
		
		arquivo.write("D:\\ProjetoAM2016\\WebContent\\images\\"+getFileName(arquivo));	
		
		return nomeArquivo;
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
