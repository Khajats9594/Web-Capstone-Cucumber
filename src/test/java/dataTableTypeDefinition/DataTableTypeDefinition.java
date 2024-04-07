package dataTableTypeDefinition;

import io.cucumber.java.DataTableType;
import models.Book;
import models.UserDetail;

import java.util.Map;

public class DataTableTypeDefinition {

    @DataTableType
    public UserDetail convert(Map<String, String> entry) {
        return new UserDetail(
                entry.get("First Name"),
                entry.get("Last Name"),
                entry.get("Username"),
                entry.get("Password"),
                entry.get("Confirm Password"),
                entry.get("Gender")
        );
    }
    @DataTableType
    public Book defineBook(Map<String, String> entry) {
        return new Book(entry.get("Book Title"),
                Double.parseDouble(entry.get("Price"))
        );
    }
}
