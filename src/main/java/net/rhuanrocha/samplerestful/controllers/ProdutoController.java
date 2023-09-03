package net.rhuanrocha.samplerestful.controllers;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
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
import java.time.LocalDateTime;
import java.time.ZoneId;

@Path("/produtos")
public class ProdutoController {

	@Inject
	private ProdutoService produtoService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
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

	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(@Valid ProdutoDTO produtoDto, @PathParam("id") Long id){
		Produto produtoAtualizar = produtoService.findById(id);

		produtoAtualizar = preencheProdutoAtulizar(produtoAtualizar, produtoDto);

		Produto produto = produtoService.save(produtoAtualizar);

		return Response.status(Response.Status.OK).entity(produto).build();
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

	private Produto preencheProdutoAtulizar(Produto produtoAtualizar, ProdutoDTO produtoDto){
		produtoAtualizar.setValor(produtoDto.getValor());
		produtoAtualizar.setDescricao(produtoDto.getDescricao());
		produtoAtualizar.setUltimaAtualizacao(LocalDateTime.now(ZoneId.of("UTC")));

		return produtoAtualizar;
	}
}
