package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetail {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String confirmPassword;
    private String gender;
}
