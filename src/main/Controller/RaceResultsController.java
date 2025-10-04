package main.Controller;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import main.Repository.RaceDetails.Race;
import main.Repository.RaceDetails.RaceRepository;
import main.Service.DriverPositionDTO;
import main.Repository.RaceResults.ResultRepository;
import main.Service.RaceResultsResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/results")
@Validated
public class RaceResultsController {

    private final ResultRepository resultRepository;
    private final RaceRepository raceRepository; // Still required by constructor

    public RaceResultsController(ResultRepository resultRepository, RaceRepository raceRepository) {
        this.resultRepository = resultRepository;
        this.raceRepository = raceRepository;
    }

    @GetMapping("/races/{year}/{round}")
    public RaceResultsResponse getMainRaceResults(
            @PathVariable @Min(value = 1950, message = "Year must be 1950 or later ") @Max(value = 2024, message = "Year 2024 is the latest season, we cannot provide future results") int year,

            @PathVariable @Positive(message = "round must be positive") int round) {

        Integer maxRound = raceRepository.findMaxRoundByYear(year);

        if (maxRound == null) {
            throw new IllegalArgumentException("No races found for year " + year);
        }

        if (round > maxRound) {
            throw new IllegalArgumentException(
                    "Invalid round " + round + " for year " + year +
                            ". Max available round is " + maxRound);
        }

        // fetch results
        List<DriverPositionDTO> results = resultRepository.findRacePositionsByRace(year, round);

        // fetch race details
        Race race = raceRepository.findRaceByYearAndRound(year, round);

        // Constructor now only passes name, date, and results
        return new RaceResultsResponse(
                race.getName(),
                race.getDate(),
                results
        );
    }
}