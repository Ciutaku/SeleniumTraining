package dto;

import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;

@Data
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public User() {
        this.firstName = RandomStringUtils.randomAlphabetic(8);
        this.lastName = RandomStringUtils.randomAlphabetic(8);
        this.email = RandomStringUtils.randomAlphanumeric(14) + "@gmail.com";
        this.password = RandomStringUtils.randomAlphanumeric(16);
    }
}
