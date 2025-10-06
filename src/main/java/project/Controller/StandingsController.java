package project.Controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import project.Service.ConstructorPositionDTO;
import project.Repository.ConstructorStandings.ConstructorStandingRepository;
import project.Service.DriverPositionDTO;
import project.Repository.DriverStandings.DriverStandingRepository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Validated
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
    @Tag(name = "Interim constructor standings",description = "Constructors Points table at a particular season and  particular round")
    public List<ConstructorPositionDTO> getConstructorStandings(
            @PathVariable @Min(value = 1950, message = "Year must be 1950 or later ") @Max(value = 2024, message = "Year 2024 is the latest season, we cannot provide future results") int year,
            @PathVariable @Positive(message = "round must be positive") int round) {

        Integer maxRound = constructorRepository.findMaxRoundByYear(year);

        if (maxRound == null) {
            throw new IllegalArgumentException("No races found for year " + year);
        }

        if (round > maxRound) {
            throw new IllegalArgumentException(
                    "Invalid round " + round + " for year " + year +
                            ". Max available round is " + maxRound
            );
        }

        return constructorRepository.findPositionsByYearAndRound(year, round);
    }

    @GetMapping("/constructors/{year}")
    @Tag(name = "Final constructor standings",description = "Constructors Points table at end of the season")
    public List<ConstructorPositionDTO> getFinalConstructorStandings(
            @PathVariable @Min(value = 1950, message = "Year must be 1950 or later ") @Max(value = 2024, message = "Year 2024 is the latest season, we cannot provide future results") int year) {

        Integer maxRound = constructorRepository.findMaxRoundByYear(year);

        if (maxRound == null) {
            throw new IllegalArgumentException ("No constructor standings data found for the final round of the year: " + year);
        }

        return constructorRepository.findPositionsByYearAndRound(year, maxRound);
    }

    @GetMapping("/drivers/{year}/{round}")
    @Tag(name = "Interim driver standings",description = "Drivers Points table at a particular season and  particular round")
    public List<DriverPositionDTO> getDriverStandings(
            @PathVariable @Min(value = 1950, message = "Year must be 1950 or later ") @Max(value = 2024, message = "Year 2024 is the latest season, we cannot provide future results") int year,
            @PathVariable @Positive(message = "round must be positive") int round) {

        Integer maxRound = constructorRepository.findMaxRoundByYear(year);

        if (maxRound == null) {
            throw new IllegalArgumentException("No races found for year " + year);
        }

        if (round > maxRound) {
            throw new IllegalArgumentException(
                    "Invalid round " + round + " for year " + year +
                            ". Max available round is " + maxRound
            );
        }

        return driverStandingRepository.findChampionshipStandingsByRace(year, round);
    }

    @GetMapping("/drivers/{year}")
    @Tag(name = "Final driver standings",description = "Drivers Points table at end of the season")
    public List<DriverPositionDTO> getFinalDriverStandings(
            @PathVariable @Min(value = 1950, message = "Year must be 1950 or later ") @Max(value = 2024, message = "Year 2024 is the latest season, we cannot provide future results") int year) {

        Integer maxRound = driverStandingRepository.findMaxRoundByYear(year);

        if (maxRound == null) {
            throw new IllegalArgumentException ("No driver standings data found for the final round of the year: " + year);
        }

        return driverStandingRepository.findChampionshipStandingsByRace(year, maxRound);
    }

}