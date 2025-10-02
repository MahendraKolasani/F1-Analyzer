package main.Controller;

import main.Repository.Driver.DriverPositionDTO;
import main.Repository.Result.ResultRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/results")
public class RaceResultsController {

    private final ResultRepository resultRepository;

    public RaceResultsController(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @GetMapping("/races/{year}/{round}")
    public List<DriverPositionDTO> getMainRaceResults(
            @PathVariable int year,
            @PathVariable int round) {

        return resultRepository.findRacePositionsByRace(year, round);
    }
}