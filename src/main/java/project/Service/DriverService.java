package project.Service;

import project.Repository.DriverStandings.Driver;

import java.util.List;

public interface DriverService {

    List<Driver> getAllDrivers();

    Driver getDriverById(Long id);

    List<Driver> getDriversByNationality(String nationality);

}