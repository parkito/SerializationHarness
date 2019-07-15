package ru.siksmfp.serialization.harness.model;

import java.util.Arrays;

public class UserFactory {

    private static final User USER;

    static {
        Address address1 = new Address(1L, "Moscow", 15_000_000);
        Address address2 = new Address(3L, "SPB", 5_000_000);
        Address address3 = new Address(4L, "Dzerzhinsk", 250_000);
        Address address4 = new Address(5L, "Vladivastok", 1_000_000);
        Address address5 = new Address(6L, "Tokio", 30_000_000);

        USER = new User();
        USER.setId(100L);
        USER.setName("name");
        USER.setAddresses(Arrays.asList(address1, address2, address3, address4, address4, address5));
        USER.setSignature("longUniqGoodUserSignatureForSecurity".getBytes());
    }

    public static User getFirstUser() {
        return USER;
    }
}
