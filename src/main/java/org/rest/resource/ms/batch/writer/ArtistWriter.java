package org.rest.resource.ms.batch.writer;

import jakarta.batch.api.chunk.AbstractItemWriter;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
@Named(value = "artistWriter")
public class ArtistWriter extends AbstractItemWriter {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void writeItems(List<Object> list) {
        for (Object o : list) {
            em.persist(o);
        }
        em.flush();
        em.clear();
    }
}