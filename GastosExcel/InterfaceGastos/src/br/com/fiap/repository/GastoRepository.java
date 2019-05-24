package br.com.fiap.repository;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.TO.GastoTO;


public class GastoRepository {
	
	Client client = Client.create();
	private static final String URL = "http://localhost:8080/InterfaceGastos/rest/gasto/";
	
	
	public void cadastrar(GastoTO gasto)throws Exception {
		WebResource resource = client.resource(URL);
		ClientResponse resp = resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class,gasto);
		
		
				if(resp.getStatus()!=201) {
					throw new Exception("Ero ao conectar no servidor");	
					
					
					
				}
				
	}
	
	
	public List<GastoTO>listar()throws Exception{
		Client client =Client.create();
		
		WebResource resource = client.resource("http://localhost:8080/11-WS-Restful/rest/filme");
		
		ClientResponse resp = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

		//valida o status http da resposta
		if(resp.getStatus()==200) {
			GastoTO[] filmes = resp.getEntity(GastoTO[].class);
			return  Arrays.asList(filmes);
		}
		else{
			throw new Exception("Ero ao conectar no servidor");
		}
	}
}
