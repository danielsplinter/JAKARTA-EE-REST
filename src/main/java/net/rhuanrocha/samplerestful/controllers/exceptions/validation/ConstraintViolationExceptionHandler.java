package net.rhuanrocha.samplerestful.controllers.exceptions.validation;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import net.rhuanrocha.samplerestful.controllers.exceptions.ObjectError;
import net.rhuanrocha.samplerestful.services.exceptions.ProductNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Provider
public class ConstraintViolationExceptionHandler implements ExceptionMapper<ConstraintViolationException> {

    @Context
    UriInfo uriInfo;

    @Override
    public Response toResponse(ConstraintViolationException exception) {

        ValidationErro objectError = new ValidationErro();
        objectError.setMensagem(exception.getMessage());
        objectError.setErro("Validation Exception");
        objectError.setPathUri(uriInfo.getPath());
        objectError.setStatus(Response.Status.NOT_FOUND.getStatusCode());

        exception.getConstraintViolations()
            .forEach(constraint -> {
                objectError.getCampoMensagemErroList().add(
                        new CampoMensagemErro(obterNomeCampo(constraint.getPropertyPath()), constraint.getMessage())
                );
            });

        return Response.status(Response.Status.BAD_REQUEST).entity(objectError).build();
    }

    private String obterNomeCampo(Path propertyPath){
        String nomeCampo = null;

        for(Path.Node node: propertyPath){
            nomeCampo = node.getName();
        }

        return nomeCampo;
    }
}
