package org.rest.book.ms.util;

public class GraphQlUtils {

    public static String buildGreetingQuery() {
        return """
                query($name: String!) {
                    greet(name: $name)
                }
                """;
    }
}