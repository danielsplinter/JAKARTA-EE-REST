package net.rhuanrocha.samplerestful.controllers;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Link;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import net.rhuanrocha.samplerestful.dto.ProdutoDTO;
import net.rhuanrocha.samplerestful.entity.Produto;
import net.rhuanrocha.samplerestful.services.ProdutoService;

import java.net.URI;

@Path("/produtos")
public class ProdutoController {

	/*@Context
	UriInfo uriInfo;*/

	@Inject
	private ProdutoService produtoService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		/*Link link = Link.fromUriBuilder(uriInfo.getBaseUriBuilder()
						.path(ProdutoController.class)
						.path(Long.toString(produto.getId())))
				.rel("self")
				.build();*/
		return Response.ok(produtoService.findAll()).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response save(@Valid ProdutoDTO produtoDto){
		Produto produto = produtoService.save(new Produto(produtoDto));

		return Response.created(
				URI.create(String.format("/products/%d", produto.getId()))
		).entity(produto).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProdutoById(@PathParam("id") Long id){
		return Response.ok(produtoService.findById(id)).build();
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteById(@PathParam("id") Long id){
		produtoService.deleteById(id);
		return Response.noContent().build();
	}
}
