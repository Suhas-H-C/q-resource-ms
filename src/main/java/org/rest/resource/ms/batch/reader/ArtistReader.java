package org.rest.resource.ms.batch.reader;

import jakarta.batch.api.chunk.AbstractItemReader;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toList;

@ApplicationScoped
@Named(value = "artistReader")
public class ArtistReader extends AbstractItemReader {

    private Iterator<String> iterator;

    @Override
    public void open(Serializable checkpoint) {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/job/artist.csv"))));
        List<String> lines = reader
                .lines()
                .skip(1)
                .collect(toList());
        iterator = lines.iterator();
    }

    @Override
    public Object readItem() {
        if (nonNull(iterator) && iterator.hasNext()) {
            return iterator.next();
        }
        return null;
    }
}