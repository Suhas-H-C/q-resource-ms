package org.rest.resource.ms.util;

import org.rest.resource.ms.entity.Artist;

public class ArtistTestUtil {

    public static Artist artistJohn() {
        return new Artist("John", "John's bio", 25);
    }
}
