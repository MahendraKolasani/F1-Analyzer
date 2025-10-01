package main.Repository.Constructor;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "constructors")
public class Constructor {
    @Id
    private Long constructorId;

    public Long getConstructorId() {
        return constructorId;
    }

    public void setConstructorId(Long constructorId) {
        this.constructorId = constructorId;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    @OneToMany(mappedBy = "constructor")
    private List<ConstructorStanding> standings;



}