package inventory;

public class Address {
    String city;
    String postalCode;
    String state;
    public Address(String city, String postalCode, String state) {
        this.city = city;
        this.postalCode = postalCode;
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
