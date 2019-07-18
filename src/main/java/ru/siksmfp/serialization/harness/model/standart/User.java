package ru.siksmfp.serialization.harness.model.standart;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class User implements Serializable {

    private static final long serialVersionUID = 7093573191624563747L;

    private Long id;
    private String name;
    private byte[] signature;
    private List<Address> addresses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getSignature() {
        return signature;
    }

    public void setSignature(byte[] signature) {
        this.signature = signature;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(name, user.name) &&
                Arrays.equals(signature, user.signature) &&
                Objects.equals(addresses, user.addresses);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, name, addresses);
        result = 31 * result + Arrays.hashCode(signature);
        return result;
    }
}
