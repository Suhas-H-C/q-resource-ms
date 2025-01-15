package org.rest.book.ms.dto;

public record GreetRequest(String query, Variables variables) {
    public record Variables(String name) {
    }
}