package org.rest.resource.ms.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.rest.resource.ms.entity.Artist;
import org.rest.resource.ms.service.ArtistService;

import java.util.List;

@Path("/artists")
public class ArtistResource {

    @Inject
    private ArtistService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Artist> getAllArtists() {
        return service.allArtist();
    }

    @GET
    @Path("/{id}")
    public Artist getArtistById(@PathParam("id") Integer id) {
        return service.getArtistById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(Artist artist) {
        return Response
                .status(201)
                .entity(service.persist(artist))
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response remove(@PathParam("id") Integer id){
        return Response
                .status(204)
                .entity(service.remove(id))
                .build();
    }
}