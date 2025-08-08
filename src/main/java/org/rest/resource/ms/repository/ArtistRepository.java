package org.rest.resource.ms.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.rest.resource.ms.entity.Artist;

import java.util.List;

@ApplicationScoped
public class ArtistRepository {

    @PersistenceContext
    EntityManager em;

    public void save(Artist artist) {
        em.persist(artist);
    }

    public Artist getById(Integer id) {
        return em.find(Artist.class, id);
    }

    public List<Artist> getArtists() {
        return em.createQuery("SELECT a FROM Artist a", Artist.class)
                .getResultList();
    }

    public boolean deleteArtist(Artist artist) {
        em.remove(artist);
        return true;
    }
}