package main.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository; // Best practice to explicitly add this

import java.util.List;

@Repository
public interface ConstructorStandingRepository extends JpaRepository<ConstructorStanding, Long> {

    /**
     * Retrieves a list of constructor names and their positions for a specific race.
     * Uses a JPQL Constructor Expression to project the joined result directly into the DTO.
     */
    @Query("SELECT new main.Repository.ConstructorPositionDTO(c.name, cs.position) " +
            "FROM ConstructorStanding cs " +
            "JOIN cs.constructor c " + // Join to Constructor entity (alias 'c')
            "JOIN cs.race r " +       // Join to Race entity (alias 'r')
            "WHERE r.year = :year AND r.round = :round " +
            "ORDER BY cs.position ASC")
    List<ConstructorPositionDTO> findPositionsByYearAndRound(@Param("year") int year,
                                                             @Param("round") int round);
}
