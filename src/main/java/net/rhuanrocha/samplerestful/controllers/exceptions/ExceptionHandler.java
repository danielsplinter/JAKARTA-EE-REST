package net.rhuanrocha.samplerestful.controllers.exceptions;

import jakarta.inject.Inject;
import jakarta.servlet.ServletRequest;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import net.rhuanrocha.samplerestful.services.exceptions.ProductNotFoundException;

import java.util.logging.Level;
import java.util.logging.Logger;


@Provider
public class ExceptionHandler implements ExceptionMapper<Throwable> {

    Logger logger = Logger.getLogger(ExceptionHandler.class.getName());

    @Context
    private UriInfo uriInfo;

    @Override
    public Response toResponse(Throwable exception) {

        if (exception.getCause() instanceof ProductNotFoundException) {
            ObjectError objectError = new ObjectError();
            objectError.setMensagem(exception.getMessage());
            objectError.setErro("Recurso não encontrado");
            objectError.setPathUri(uriInfo.getPath());
            objectError.setStatus(Response.Status.NOT_FOUND.getStatusCode());

            return Response.status(Response.Status.NOT_FOUND).entity(objectError).build();
        }

        logger.log(Level.SEVERE,"ERRO SERVIDOR: ",exception);

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro interno no servidor").build();
    }
}
