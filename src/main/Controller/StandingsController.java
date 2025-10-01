package main.Controller;


import main.Repository.Constructor.ConstructorPositionDTO;
import main.Repository.Constructor.ConstructorStandingRepository;
import main.Repository.Driver.DriverPositionDTO;
import main.Repository.Driver.ResultRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/standings")
public class StandingsController {

    private final ConstructorStandingRepository constructorRepository;
    private final ResultRepository resultRepository; // <-- use ResultRepository here

    public StandingsController(ConstructorStandingRepository constructorRepository,
                               ResultRepository resultRepository) {
        this.constructorRepository = constructorRepository;
        this.resultRepository = resultRepository;
    }

    @GetMapping("/constructors/{year}/{round}")
    public List<ConstructorPositionDTO> getConstructorStandings(
            @PathVariable int year,
            @PathVariable int round) {

        return constructorRepository.findPositionsByYearAndRound(year, round);
    }

    @GetMapping("/drivers/{year}/{round}")
    public List<DriverPositionDTO> getDriverResults(
            @PathVariable int year,
            @PathVariable int round) {

        return resultRepository.findDriverPositionsByRace(year, round); // <-- correct repository
    }
}
