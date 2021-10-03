package models.manyToMany;

import javax.persistence.*;
import java.util.List;

@Entity
public class Developer {

    @Id
    @GeneratedValue
    private int devId;

    private String name;

    @ManyToMany
    private List<Project> projects;

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public int getDevId() {
        return devId;
    }

    public void setDevId(int devId) {
        this.devId = devId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
