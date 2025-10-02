package main.Controller;

import main.Repository.RaceDetails.Race;
import main.Repository.RaceDetails.RaceRepository;
import main.Service.DriverPositionDTO;
import main.Repository.RaceResults.ResultRepository;
import main.Service.RaceResultsResponse;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/results")
public class RaceResultsController {

    private final ResultRepository resultRepository;
    private final RaceRepository raceRepository; // Still required by constructor

    public RaceResultsController(ResultRepository resultRepository, RaceRepository raceRepository) {
        this.resultRepository = resultRepository;
        this.raceRepository = raceRepository;
    }

    @GetMapping("/races/{year}/{round}")
    public RaceResultsResponse getMainRaceResults(
            @PathVariable int year,
            @PathVariable int round) {

        // fetch results
        List<DriverPositionDTO> results = resultRepository.findRacePositionsByRace(year, round);

        // fetch race details
        Race race = raceRepository.findRaceByYearAndRound(year, round);

        // Constructor now only passes name, date, and results
        return new RaceResultsResponse(
                race.getName(),
                race.getDate().toString(),
                results
        );
    }
}