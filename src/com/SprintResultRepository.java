package com;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SprintResultRepository extends JpaRepository<SprintResult, Long> {

    @Query("SELECT new com.SprintResultDTO(" +
            "r.round, " +
            "CONCAT(d.forename, ' ', d.surname), " +
            "sr.position, " +
            "sr.grid, " + // <-- New field
            "sr.points) " + // <-- New field
            "FROM SprintResult sr " +
            "JOIN sr.driver d " +
            "JOIN sr.race r " +
            "WHERE r.year = :year " +
            "ORDER BY r.round ASC, " +
            "    CASE sr.position WHEN 0 THEN 999 ELSE CAST(sr.position AS INTEGER) END ASC")
    List<SprintResultDTO> findSprintPositionsByYear(@Param("year") int year);
}