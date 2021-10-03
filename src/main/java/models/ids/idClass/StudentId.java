package models.ids.idClass;

import java.io.Serializable;

public class StudentId implements Serializable {
    private int id1;
    private int id2;

    public StudentId(int id1, int id2) {
        this.id1 = id1;
        this.id2 = id2;
    }

    public int getId1() {
        return id1;
    }

    public int getId2() {
        return id2;
    }
}
