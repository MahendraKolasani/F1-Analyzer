package project.Service;

import org.springframework.stereotype.Service;
import project.Model.DriverPositionDTO;
import project.Model.RaceResultsResponse;
import project.Repository.RaceDetails.Race;
import project.Repository.RaceDetails.RaceRepository;
import project.Repository.RaceResults.ResultRepository;

import java.util.List;

@Service
public class RaceServiceImpl implements RaceService {

    private final ResultRepository resultRepository;
    private final RaceRepository raceRepository;

    public RaceServiceImpl(ResultRepository resultRepository,
                           RaceRepository raceRepository) {

        this.resultRepository = resultRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public RaceResultsResponse getRaceResults(int year, int round) {

        Integer maxRound = raceRepository.findMaxRoundByYear(year);

        if (maxRound == null) {
            throw new IllegalArgumentException(
                    "No races found for year " + year);
        }

        if (round > maxRound) {
            throw new IllegalArgumentException(
                    "Invalid round " + round +
                            " for year " + year +
                            ". Max available round is " + maxRound);
        }

        Race race = raceRepository.findRaceByYearAndRound(year, round);

        List<DriverPositionDTO> results =
                resultRepository.findRacePositionsByRace(year, round);

        return new RaceResultsResponse(
                race.getName(),
                race.getDate(),
                results
        );
    }
}