package project.Service;

import org.springframework.stereotype.Service;
import project.Model.ConstructorPositionDTO;
import project.Model.DriverPositionDTO;
import project.Repository.ConstructorStandings.ConstructorStandingRepository;
import project.Repository.DriverStandings.DriverStandingRepository;

import java.util.List;

@Service
public class StandingServiceImpl implements StandingService {

    private final ConstructorStandingRepository constructorRepository;
    private final DriverStandingRepository driverStandingRepository;

    public StandingServiceImpl(
            ConstructorStandingRepository constructorRepository,
            DriverStandingRepository driverStandingRepository) {

        this.constructorRepository = constructorRepository;
        this.driverStandingRepository = driverStandingRepository;
    }

    @Override
    public List<ConstructorPositionDTO> getConstructorStandings(int year,
                                                                int round) {

        Integer maxRound = constructorRepository.findMaxRoundByYear(year);

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

        return constructorRepository.findPositionsByYearAndRound(year, round);
    }

    @Override
    public List<ConstructorPositionDTO> getFinalConstructorStandings(int year) {

        Integer maxRound = constructorRepository.findMaxRoundByYear(year);

        if (maxRound == null) {
            throw new IllegalArgumentException(
                    "No constructor standings found for year " + year);
        }

        return constructorRepository.findPositionsByYearAndRound(
                year,
                maxRound
        );
    }

    @Override
    public List<DriverPositionDTO> getDriverStandings(int year,
                                                      int round) {

        Integer maxRound = driverStandingRepository.findMaxRoundByYear(year);

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

        return driverStandingRepository
                .findChampionshipStandingsByRace(year, round);
    }

    @Override
    public List<DriverPositionDTO> getFinalDriverStandings(int year) {

        Integer maxRound = driverStandingRepository.findMaxRoundByYear(year);

        if (maxRound == null) {
            throw new IllegalArgumentException(
                    "No driver standings found for year " + year);
        }

        return driverStandingRepository
                .findChampionshipStandingsByRace(year, maxRound);
    }
}