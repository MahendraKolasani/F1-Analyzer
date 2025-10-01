package main.Repository.Driver;

import jakarta.persistence.*;
import main.Repository.Constructor.ConstructorStanding;

import java.util.List;

@Entity
@Table(name = "races")
public class Race {
    @Id
    private Long raceId;
    private int year;
    private int round;

    public void setRaceId(Long raceId) {
        this.raceId = raceId;
    }

    public void setRound(int round) {
        this.round = round;
    }

    @OneToMany(mappedBy = "race")
    private List<ConstructorStanding> standings;

    public Race() {}

    public int getYear() { return year; }
    public int getRound() { return round; }
}