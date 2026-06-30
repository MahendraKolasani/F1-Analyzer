package project.Service;

import org.springframework.stereotype.Service;
import project.Repository.DriverStandings.Driver;
import project.Repository.DriverStandings.DriverRepository;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {

    private final DriverRepository driverRepository;

    public DriverServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    @Override
    public Driver getDriverById(Long id) {

        return driverRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Driver not found with id : " + id));

    }

    @Override
    public List<Driver> getDriversByNationality(String nationality) {

        return driverRepository.findByNationality(nationality);

    }
}