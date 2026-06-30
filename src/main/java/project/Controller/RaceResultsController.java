package project.Controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import project.Model.RaceResultsResponse;
import project.Service.RaceService;

@RestController
@RequestMapping("/results")
@Validated
public class RaceResultsController {

    private final RaceService raceService;

    public RaceResultsController(RaceService raceService) {
        this.raceService = raceService;
    }

    @Tag(
            name = "Race results",
            description = "Race results of a particular race in a particular season")
    @GetMapping("/races/{year}/{round}")
    public RaceResultsResponse getMainRaceResults(

            @PathVariable
            @Min(value = 1950, message = "Year must be 1950 or later")
            @Max(value = 2024, message = "Year 2024 is the latest season")
            int year,

            @PathVariable
            @Positive(message = "Round must be positive")
            int round) {

        return raceService.getRaceResults(year, round);
    }
}