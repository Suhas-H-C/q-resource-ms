package org.rest.resource.ms.service;

import org.jboss.logging.Logger;
import org.junit.jupiter.api.Test;
import org.rest.resource.ms.entity.Artist;
import org.rest.resource.ms.exception.ArtistNotFoundException;
import org.rest.resource.ms.repository.ArtistRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.*;
import static org.rest.resource.ms.util.ArtistTestUtil.artistJohn;

class ArtistServiceTest {

    private final Logger log = Logger.getLogger(ArtistServiceTest.class);
    private final ArtistRepository repository = mock(ArtistRepository.class);
    private final ArtistService service = new ArtistService(log, repository);

    @Test
    void should_return_all_artists() {
        when(repository.getArtists()).thenReturn(List.of(artistJohn()));
        List<Artist> artists = service.allArtist();
        assertFalse(artists.isEmpty());
        assertEquals("John", artists.getFirst().getName());
        verify(repository).getArtists();
    }

    @Test
    void should_return_artist_when_Id_is_passed() {
        Integer artistId = 1;
        when(repository.getById(artistId)).thenReturn(artistJohn());
        Artist artist = service.getArtistById(artistId);
        assertNotNull(artist);
        assertEquals("John", artist.getName());
        verify(repository).getById(artistId);
    }

    @Test
    void should_throw_ArtistNotFoundException_when_artist_is_null() {
        Integer artistId = 1;
        when(repository.getById(artistId)).thenReturn(null);
        assertThrows(ArtistNotFoundException.class,
                () -> service.remove(artistId));
        verify(repository).getById(artistId);
    }

    @Test
    void should_persist_artist() {
        doNothing().when(repository).save(artistJohn());
        boolean response = service.persist(artistJohn());
        assertTrue(response);
        verify(repository).save(refEq(artistJohn()));
    }

    @Test
    void should_remove_artist() {
        Integer artistId = 1;
        when(repository.getById(artistId)).thenReturn(artistJohn());
        when(repository.deleteArtist(refEq(artistJohn()))).thenReturn(true);
        boolean response = service.remove(artistId);
        assertTrue(response);
        verify(repository).getById(artistId);
        verify(repository).deleteArtist(refEq(artistJohn()));
    }
}