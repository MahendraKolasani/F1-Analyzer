package main.Repository.DriverStandings;

import main.Service.DriverPositionDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverStandingRepository extends JpaRepository<DriverStanding, Long> {

    @Query("SELECT new main.Service.DriverPositionDTO(CONCAT(d.forename, ' ', d.surname), ds.position) " +
            "FROM DriverStanding ds " +
            "JOIN ds.driver d " +
            "JOIN ds.race r " +
            "WHERE r.year = :year AND r.round = :round " +
            "ORDER BY ds.position ASC")
    List<DriverPositionDTO> findChampionshipStandingsByRace(@Param("year") int year,
                                                            @Param("round") int round);

    @Query("SELECT MAX(r.round) FROM Race r WHERE r.year = :year")
    Integer findMaxRoundByYear(@Param("year") int year);


}
