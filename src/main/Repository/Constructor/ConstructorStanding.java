package main.Repository.Constructor;


import jakarta.persistence.*;
import main.Repository.Driver.Race;

@Entity
@Table(name = "constructor_standings")
public class ConstructorStanding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long standingId;
    private int position;

    @ManyToOne
    @JoinColumn(name = "raceId")
    private Race race;

    public void setPosition(int position) {
        this.position = position;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public void setStandingId(Long standingId) {
        this.standingId = standingId;
    }

    @ManyToOne
    @JoinColumn(name = "constructorId")
    private Constructor constructor;

    public ConstructorStanding() {}

    // Minimal getters needed for the query
    public int getPosition() { return position; }
    public Race getRace() { return race; }
    public Constructor getConstructor() { return constructor; }
}

