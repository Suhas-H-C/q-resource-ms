package org.rest.resource.ms.exception;

public class StudentNotFoundException extends RuntimeException {
    String message;

    public StudentNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
