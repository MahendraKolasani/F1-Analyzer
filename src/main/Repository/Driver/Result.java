package main.Repository.Driver;

import jakarta.persistence.*;

@Entity
@Table(name = "results")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resultId;

    private int position;  // finishing position (0 = DNF)

    @ManyToOne
    @JoinColumn(name = "raceId")
    private Race race;

    @ManyToOne
    @JoinColumn(name = "driverId")
    private Driver driver;

    public Result() {}

    // getters
    public Long getResultId() { return resultId; }
    public int getPosition() { return position; }
    public Race getRace() { return race; }
    public Driver getDriver() { return driver; }
}
