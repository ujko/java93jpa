package models.inheritance;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Dad {
    @Id
    private int dadId;

    private String dadName;

    public int getDadId() {
        return dadId;
    }

    public void setDadId(int dadId) {
        this.dadId = dadId;
    }

    public String getDadName() {
        return dadName;
    }

    public void setDadName(String dadName) {
        this.dadName = dadName;
    }
}
