package main.Repository.RaceDetails;

import jakarta.persistence.*;
import main.Repository.ConstructorStandings.ConstructorStanding;

import java.util.List;

@Entity
@Table(name = "races")
public class Race {

    @Id
    @Column(name = "raceId")
    private Long raceId;

    private int year;
    private int round;
    private String name;
    private String date;


    @OneToMany(mappedBy = "race")
    private List<ConstructorStanding> standings;

    public Race() {}

    // getters
    public Long getRaceId() { return raceId; }
    public int getYear() { return year; }
    public int getRound() { return round; }
    public String getName() { return name; }
    public String getDate() { return date; }

    // setters
    public void setRaceId(Long raceId) { this.raceId = raceId; }
    public void setYear(int year) { this.year = year; }
    public void setRound(int round) { this.round = round; }
    public void setName(String name) { this.name = name; }
    public void setDate(String date) { this.date = date; }


}