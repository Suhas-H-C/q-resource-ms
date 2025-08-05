package org.rest.resource.ms.resource;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.rest.resource.ms.entity.Artist;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class ArtistResourceTest {

    @Test
    @TestTransaction
    void should_create_artist_and_return_when_Id_is_passed() {
        Artist john = new Artist("John", "John's bio", 25);
        Artist.persist(john);
        Artist artistById = Artist.findById(1);
        assertEquals(john.name, artistById.name);
        List<Artist> allArtist = Artist.listAll();
        assertEquals(1, allArtist.size());
    }
}