package models.twoObjToOneTable.direct;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person1 {

    @Id
    @Column(name = "person_id")
    private int personId;
    @Column(name = "email")
    private String email;
    @Column(name = "city")
    private String city;



    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

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
                "personId=" + personId +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
