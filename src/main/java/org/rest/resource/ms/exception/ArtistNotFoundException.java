package org.rest.resource.ms.exception;

public class ArtistNotFoundException extends RuntimeException {
    String message;

    public ArtistNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
