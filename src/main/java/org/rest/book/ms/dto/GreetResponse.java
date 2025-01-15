package org.rest.book.ms.dto;

public record GreetResponse(Greet data) {
    public record Greet(String greet) {
    }
}