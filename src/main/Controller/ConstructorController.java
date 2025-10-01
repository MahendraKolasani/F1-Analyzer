package main.Controller;

import main.Repository.ConstructorPositionDTO;
import main.Repository.ConstructorStandingRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/constructors")
public class ConstructorController {

    private final ConstructorStandingRepository repository;

    // Spring uses Constructor Injection to provide the repository instance
    public ConstructorController(ConstructorStandingRepository repository) {
        this.repository = repository;
    }

    /**
     * API Endpoint: GET /constructors/positions?year=2024&round=5
     * Returns the list of constructors and their positions for the specified race.
     */
    @GetMapping("/standings/{year}/{round}")
    public List<ConstructorPositionDTO> getPositions(@PathVariable int year, @PathVariable int round) {

        // Delegates the call directly to the repository's custom query
        return repository.findPositionsByYearAndRound(year, round);
    }
}