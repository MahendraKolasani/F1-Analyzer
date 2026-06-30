package project.Controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import project.Model.ConstructorPositionDTO;
import project.Model.DriverPositionDTO;
import project.Service.StandingService;

import java.util.List;

@RestController
@RequestMapping("/standings")
@Validated
public class StandingsController {

    private final StandingService standingService;

    public StandingsController(StandingService standingService) {
        this.standingService = standingService;
    }

    @Tag(
            name = "Interim constructor standings",
            description = "Constructors points table after a particular round")
    @GetMapping("/constructors/{year}/{round}")
    public List<ConstructorPositionDTO> getConstructorStandings(

            @PathVariable
            @Min(value = 1950, message = "Year must be 1950 or later")
            @Max(value = 2024, message = "Year 2024 is the latest season")
            int year,

            @PathVariable
            @Positive(message = "Round must be positive")
            int round) {

        return standingService.getConstructorStandings(year, round);
    }

    @Tag(
            name = "Final constructor standings",
            description = "Final constructor standings for a season")
    @GetMapping("/constructors/{year}")
    public List<ConstructorPositionDTO> getFinalConstructorStandings(

            @PathVariable
            @Min(value = 1950, message = "Year must be 1950 or later")
            @Max(value = 2024, message = "Year 2024 is the latest season")
            int year) {

        return standingService.getFinalConstructorStandings(year);
    }

    @Tag(
            name = "Interim driver standings",
            description = "Drivers points table after a particular round")
    @GetMapping("/drivers/{year}/{round}")
    public List<DriverPositionDTO> getDriverStandings(

            @PathVariable
            @Min(value = 1950, message = "Year must be 1950 or later")
            @Max(value = 2024, message = "Year 2024 is the latest season")
            int year,

            @PathVariable
            @Positive(message = "Round must be positive")
            int round) {

        return standingService.getDriverStandings(year, round);
    }

    @Tag(
            name = "Final driver standings",
            description = "Final driver standings for a season")
    @GetMapping("/drivers/{year}")
    public List<DriverPositionDTO> getFinalDriverStandings(

            @PathVariable
            @Min(value = 1950, message = "Year must be 1950 or later")
            @Max(value = 2024, message = "Year 2024 is the latest season")
            int year) {

        return standingService.getFinalDriverStandings(year);
    }
}