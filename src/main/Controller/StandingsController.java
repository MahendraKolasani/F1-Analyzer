package main.Controller;


import main.Service.ConstructorPositionDTO;
import main.Repository.ConstructorStandings.ConstructorStandingRepository;
import main.Service.DriverPositionDTO;
import main.Repository.DriverStandings.DriverStandingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/standings")
public class StandingsController {

    private final ConstructorStandingRepository constructorRepository;
    private final DriverStandingRepository driverStandingRepository;


    public StandingsController(ConstructorStandingRepository constructorRepository,
                               DriverStandingRepository driverStandingRepository) {
        this.constructorRepository = constructorRepository;
        this.driverStandingRepository = driverStandingRepository;
    }

    @GetMapping("/constructors/{year}/{round}")
    public List<ConstructorPositionDTO> getConstructorStandings(
            @PathVariable int year,
            @PathVariable int round) {

        return constructorRepository.findPositionsByYearAndRound(year, round);
    }

    @GetMapping("/constructors/{year}")
    public List<ConstructorPositionDTO> getFinalConstructorStandings(
            @PathVariable int year) {

        Integer maxRound = constructorRepository.findMaxRoundByYear(year);

        if (maxRound == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "No constructor standings data found for the final round of the year: " + year
            );
        }

        return constructorRepository.findPositionsByYearAndRound(year, maxRound);
    }

    @GetMapping("/drivers/{year}/{round}")
    public List<DriverPositionDTO> getDriverStandings(
            @PathVariable int year,
            @PathVariable int round) {

        return driverStandingRepository.findChampionshipStandingsByRace(year, round);
    }

    @GetMapping("/drivers/{year}")
    public List<DriverPositionDTO> getFinalDriverStandings(
            @PathVariable int year) {

        Integer maxRound = driverStandingRepository.findMaxRoundByYear(year);

        if (maxRound == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "No driver standings data found for the final round of the year: " + year
            );
        }
        return driverStandingRepository.findChampionshipStandingsByRace(year, maxRound);
    }

}