package org.rest.resource.ms.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.jboss.logging.Logger;
import org.rest.resource.ms.entity.Artist;
import org.rest.resource.ms.exception.ArtistNotFoundException;

import java.util.List;

import static java.util.Objects.isNull;

@ApplicationScoped
public class ArtistService {

    private final Logger log;

    @Inject
    public ArtistService(Logger log) {
        this.log = log;
    }

    public List<Artist> allArtist() {
        log.info("fetching all artists");
        return Artist.listAll();
    }

    public Artist getArtistById(Integer id) {
        log.info("fetching artist by id " + id);
        return Artist.findById(id);
    }

    @Transactional
    public boolean persist(Artist artist) {
        log.info("persisting artist...");
        Artist.persist(artist);
        return true;
    }

    @Transactional
    public boolean remove(Integer id) {
        if (isNull(Artist.findById(id))) {
            throw new ArtistNotFoundException("No data found for provided id " + id);
        } else {
            return Artist.deleteById(id);
        }
    }
}
