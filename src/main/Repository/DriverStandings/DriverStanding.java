package main.Repository.DriverStandings;

import jakarta.persistence.*;
import main.Repository.RaceDetails.Race;

@Entity
@Table(name = "driver_standings")
public class DriverStanding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long standingId;

    private int position;
    private Integer points;
    private Integer wins;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "raceId")
    private Race race;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driverId")
    private Driver driver;

    public DriverStanding() {
    }

    public Long getStandingId() {
        return standingId;
    }

    public void setStandingId(Long standingId) {
        this.standingId = standingId;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}