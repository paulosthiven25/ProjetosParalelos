package br.com.fiap.repository;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.TO.GastoTO;
import br.com.fiap.exception.ResponseException;


public class GastoRepository {
	
	Client client = Client.create();
	private static final String URL ="http://localhost:8080/Servidor-WS-Gastos/rest/gasto/";
	
	
	public void cadastrar(GastoTO gasto)throws ResponseException {
		WebResource resource = client.resource(URL);
		ClientResponse resp = resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class,gasto);
		
		
				if(resp.getStatus()!=201) {
					throw new ResponseException(""+resp.getStatus());	
					
					
					
				}
				
	}
	
	
	public List<GastoTO>listar()throws ResponseException{
		Client client =Client.create();
		
		WebResource resource = client.resource("http://localhost:8080/Servidor-WS-Gastos/rest/gasto");
		
		ClientResponse resp = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

		//valida o status http da resposta
		if(resp.getStatus()==200) {
			GastoTO[] filmes = resp.getEntity(GastoTO[].class);
			return  Arrays.asList(filmes);
		}
		else{
			throw new ResponseException("Erro ao conectar no servidor");
		}
	}
	
	public void remover(int codigo)throws ResponseException{
		Client client =Client.create();
		
		WebResource resource = client.resource("http://localhost:8080/Servidor-WS-Gastos/rest/gasto/").path(Integer.toString(codigo));
		
		ClientResponse resp = resource.type(MediaType.APPLICATION_JSON).delete(ClientResponse.class);
		
		if(resp.getStatus()!=204) {
			throw new ResponseException();
		}
	}
	
	
	public void atualizar(GastoTO gasto,int codigo)throws ResponseException{
		Client client =Client.create();
		
		WebResource resource = client.resource("http://localhost:8080/Servidor-WS-Gastos/rest/gasto/").path(Integer.toString(gasto.getCodigo()));
		
		ClientResponse resp = resource.type(MediaType.APPLICATION_JSON).put(ClientResponse.class);
		
		if(resp.getStatus()!=200) {
			throw new ResponseException();
		}
	}
}
