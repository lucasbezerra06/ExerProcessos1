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
		String comando="";
		if(SO.contains("Windows")){
			comando = "ipconfig";
		}
		else if(SO.contains("Linux")){
			comando = "ifconfig";
		}
		try {
			Process p = Runtime.getRuntime().exec(comando);
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
		return ip.toString();
	}
	
	public void ping(String SO){
		try {
			Process p = Runtime.getRuntime().exec("ping google.com");
			InputStream fluxo = p.getInputStream();
			InputStreamReader lerFluxo= new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(lerFluxo);
			int tamanho;
			int ping = 0;
			int media = 0;
//			setCharacterEncoding("UTF8");
			String linha = buffer.readLine();
			while(linha != null){
				tamanho = linha.length();
				
				if(linha.contains("tempo")){
					System.out.println(linha.substring(linha.lastIndexOf("=")+1, tamanho));
					media += Integer.parseInt(linha.substring(linha.lastIndexOf("=")+1, linha.lastIndexOf("ms")));
					ping++;
				}
				/*if(linha.contains("M�dia"))
					System.out.println(linha.substring(linha.lastIndexOf("M�dia"), tamanho));*/
				linha = buffer.readLine();
			}
			media = media / ping;
			System.out.println("Média = "+media+"ms");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
