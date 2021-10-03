package models.twoObjToOneTable.embedded;

import javax.persistence.*;

@Embeddable
public class Email {
    @Column(name = "email")
    private String email;
    @Column(name = "city")
    private String city;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Person{" +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
