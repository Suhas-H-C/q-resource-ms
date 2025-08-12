package org.rest.resource.ms.batch.processor;

import jakarta.batch.api.chunk.ItemProcessor;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import org.rest.resource.ms.entity.Artist;

@ApplicationScoped
@Named(value = "artistProcessor")
public class ArtistProcessor implements ItemProcessor {

    @Override
    public Object processItem(Object o) {
        String line = (String) o;
        String[] parts = line.split(",", 3); // name,bio,age

        Artist artist = new Artist();
        artist.name = parts[0];
        artist.bio = parts[1];
        artist.age = Integer.parseInt(parts[2]);
        return artist;
    }
}