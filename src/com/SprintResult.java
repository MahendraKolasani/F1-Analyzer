package com;

import jakarta.persistence.*;
import main.Repository.Driver.Driver;
import main.Repository.Driver.Race;

@Entity
@Table(name = "sprint_results")
public class SprintResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resultId")
    private Long sprintResultId;

    private Integer position;
    private Integer points;
    private Integer grid;
    private Integer laps;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "raceId")
    private Race race;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driverId")
    private Driver driver;

    public SprintResult() {
    }

    public Long getSprintResultId() {
        return sprintResultId;
    }

    public void setSprintResultId(Long sprintResultId) {
        this.sprintResultId = sprintResultId;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getGrid() {
        return grid;
    }

    public void setGrid(Integer grid) {
        this.grid = grid;
    }

    public Integer getLaps() {
        return laps;
    }

    public void setLaps(Integer laps) {
        this.laps = laps;
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