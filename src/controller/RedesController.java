package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	public RedesController() {
		super();
	}
	
	public String ip(String SO){
		StringBuffer ip = new StringBuffer();
		if(SO.contains("Windows")){
			
			try {
				Process p = Runtime.getRuntime().exec("ipconfig");
				InputStream fluxo = p.getInputStream();
				InputStreamReader lerFluxo= new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(lerFluxo);
				String linha = buffer.readLine();
				String adaptador="";
				while(linha != null){
					if(linha.contains("Adaptador")){
						adaptador = linha;
						
					}
					if(linha.contains("IPv4")){
						ip.append(adaptador+"\n"+linha+"\n");
						
						
					}
					linha = buffer.readLine();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return ip.toString();
	}

}
