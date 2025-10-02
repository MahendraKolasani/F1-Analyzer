package main.Repository.RaceDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RaceRepository extends JpaRepository<Race, Long> {
    @Query("SELECT r FROM Race r WHERE r.year = :year AND r.round = :round")
    Race findRaceByYearAndRound(@Param("year") int year, @Param("round") int round);
}

