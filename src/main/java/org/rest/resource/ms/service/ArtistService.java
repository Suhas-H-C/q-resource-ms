package org.rest.resource.ms.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.jboss.logging.Logger;
import org.rest.resource.ms.entity.Artist;

import java.util.List;

@ApplicationScoped
public class ArtistService {

    @Inject
    private Logger log;

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
}
