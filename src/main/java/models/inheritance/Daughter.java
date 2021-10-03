package models.inheritance;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "daughter")
public class Daughter extends Dad {
    private String daughterName;

    public String getDaughterName() {
        return daughterName;
    }

    public void setDaughterName(String daughterName) {
        this.daughterName = daughterName;
    }
}
