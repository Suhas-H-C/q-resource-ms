package org.rest.book.ms.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.rest.book.ms.service.BookService;

@Path("/v1")
@Tag(name = "Book Resource", description = "Book Resource API")
public class BookResource {

    @Inject
    private BookService service;

    @POST
    @Path("/save")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Operation(summary = "Create book", description = "Return created book")
    public Response createABook(@FormParam("title") String title,
                                @FormParam("author") String author,
                                @FormParam("yearOfPublication") int yearOfPublication,
                                @FormParam("genre") String genre) {
        return Response
                .status(201)
                .entity(service.createBook(title, author, yearOfPublication, genre))
                .build();
    }
}
