package main.Repository.RaceResults;

import main.Service.DriverPositionDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {

    @Query("SELECT new main.Service.DriverPositionDTO(" +
            "CONCAT(d.forename, ' ', d.surname), r.position) " +
            "FROM Result r " +
            "JOIN r.driver d " +
            "JOIN r.race ra " +
            "WHERE ra.year = :year AND ra.round = :round " +
            "ORDER BY CAST(r.position AS Long) ASC")
    List<DriverPositionDTO> findRacePositionsByRace(@Param("year") int year,
                                                    @Param("round") int round);

}


