package project.Service;

import project.Model.ConstructorPositionDTO;
import project.Model.DriverPositionDTO;

import java.util.List;

public interface StandingService {

    List<ConstructorPositionDTO> getConstructorStandings(int year, int round);

    List<ConstructorPositionDTO> getFinalConstructorStandings(int year);

    List<DriverPositionDTO> getDriverStandings(int year, int round);

    List<DriverPositionDTO> getFinalDriverStandings(int year);

}