package br.com.fiap.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.dao.GastoDAO;
import br.com.fiap.daoImpl.GastodaoImpl;
import br.com.fiap.entity.Gasto;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

@Path("/gasto")
public class GastoResource {
	private GastoDAO gdao;
	
	public GastoResource() {
		gdao=new GastodaoImpl(EntityManagerFactorySingleton.getInstance().createEntityManager());
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Gasto gasto,@Context UriInfo uri) {
		try {
			gdao.cadastrar(gasto);
			gdao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		
		//Criar a URL para acessar o recurso (filme) cadastrado.
		UriBuilder url = uri.getAbsolutePathBuilder();
		//Adiviona na url o codigo do filme cadastrado
		url.path(Integer.toString(gasto.getCodigo()));
		//retorna o codigo 201 created e a url para o filme cadastrado.
		return Response.created(url.build()).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Gasto> buscar() {
		return gdao.buscarTudo(); 
	}
}
