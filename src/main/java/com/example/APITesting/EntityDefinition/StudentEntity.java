package com.example.APITesting.EntityDefinition;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Objects;

@Entity
public class StudentEntity {

    public StudentEntity()
    {

    }
    public StudentEntity( String name, String branch) {
        //this.id = id;
        Name = name;
        Branch = branch;

    }

    public Long getId() {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public String getBranch() {
        return Branch;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setBranch(String branch) {
        Branch = branch;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String Name;
    private String Branch;
   // private ArrayList<String> clubs;

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof StudentEntity))
            return false;
        StudentEntity studentEntity = (StudentEntity) o;
        return Objects.equals(this.id, studentEntity.id) && Objects.equals(this.Name, studentEntity.Name)
                && Objects.equals(this.Branch, studentEntity.Branch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.Name, this.Branch);
    }

}
