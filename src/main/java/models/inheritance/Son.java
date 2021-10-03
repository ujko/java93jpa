package models.inheritance;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "son")
public class Son extends Dad{
    private String sonName;

    public String getSonName() {
        return sonName;
    }

    public void setSonName(String sonName) {
        this.sonName = sonName;
    }
}
