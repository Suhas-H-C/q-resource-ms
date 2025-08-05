package org.rest.resource.ms.model;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbTransient;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.Instant;

@Schema(name = "IsbnNumber", description = "ISBN Number formats")
public class IsbnNumber {

    @Schema(description = "ISBN 10 format", required = true)
    @JsonbProperty(value = "isbn_10")
    private String isbn10;

    @Schema(description = "ISBN 13 format", required = true)
    @JsonbProperty(value = "isbn_13")
    private String isbn13;

    @JsonbTransient
    private Instant generationDate;

    public String getIsbn10() {
        return isbn10;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public Instant getGenerationDate() {
        return generationDate;
    }

    public void setGenerationDate(Instant generationDate) {
        this.generationDate = generationDate;
    }

    @Override
    public String toString() {
        return "IsbnNumber{" +
                "isbn_10='" + isbn10 + '\'' +
                ", isbn_13='" + isbn13 + '\'' +
                '}';
    }
}