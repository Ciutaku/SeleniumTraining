package dto;

import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;

@Data
public class AddressBook {
    private String firsStreet;
    private String city;
    private String telephoneNumber;
    private String zipCode;

    public AddressBook() {
        this.firsStreet = RandomStringUtils.randomAlphanumeric(8);
        this.city = RandomStringUtils.randomAlphabetic(8);
        this.telephoneNumber = RandomStringUtils.randomNumeric(10);
        this.zipCode = RandomStringUtils.randomNumeric(6);
    }
}
