package org.rest.resource.ms.util;

import org.rest.resource.ms.model.Employee;
import org.rest.resource.ms.model.IsbnNumber;

public class BookTestUtil {

    public static String bookTitle = "Legend";
    public static String author = "John Hector";
    public static int yearOfPublication = 1998;
    public static String genre = "Fiction";

    public static IsbnNumber isbn(){
        IsbnNumber isbnNumber = new IsbnNumber();
        isbnNumber.setIsbn13("231-847837394755");
        return isbnNumber;
    }
}
