package models.twoTablesToOneObj;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@SecondaryTable(name = "address")
public class Employee {

    @Id
    @GeneratedValue
    private int employeeId;
    private String firstName;
    private String lastName;

    @Column(table = "address")
    private String city;
    @Column(table = "address")
    private String street;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
