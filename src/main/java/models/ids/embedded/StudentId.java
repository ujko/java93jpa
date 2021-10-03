package models.ids.embedded;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class StudentId implements Serializable {
    private int id1;
    private int id2;

    public void setId1(int id1) {
        this.id1 = id1;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }

    public int getId1() {
        return id1;
    }

    public int getId2() {
        return id2;
    }
}
