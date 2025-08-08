package org.rest.resource.ms.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.jboss.logging.Logger;
import org.rest.resource.ms.entity.Artist;
import org.rest.resource.ms.exception.ArtistNotFoundException;
import org.rest.resource.ms.repository.ArtistRepository;

import java.util.List;

import static java.util.Objects.isNull;

@ApplicationScoped
public class ArtistService {

    private final Logger log;
    private final ArtistRepository repository;

    @Inject
    public ArtistService(Logger log, ArtistRepository artistRepository) {
        this.log = log;
        this.repository = artistRepository;
    }

    public List<Artist> allArtist() {
        log.info("fetching all artists");
        return repository.getArtists();
    }

    public Artist getArtistById(Integer id) {
        log.info("fetching artist by id " + id);
        return repository.getById(id);
    }

    @Transactional
    public boolean persist(Artist artist) {
        log.info("persisting artist...");
        repository.save(artist);
        return true;
    }

    @Transactional
    public boolean remove(Integer id) {
        Artist artist = repository.getById(id);
        if (isNull(artist)) {
            throw new ArtistNotFoundException("No data found for provided id " + id);
        } else {
            return repository.deleteArtist(artist);
        }
    }
}