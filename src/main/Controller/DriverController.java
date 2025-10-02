package main.Controller;

import main.Repository.DriverStandings.Driver;
import main.Repository.DriverStandings.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    @Autowired
    DriverRepository driverRepository;

    @GetMapping
    public List <Driver> getAll(){
        return driverRepository.findAll();
    }

    @GetMapping("/{Id}")
    public Optional<Driver> getById(@PathVariable Long Id)  {
        return driverRepository.findById(Id);
    }

    @GetMapping("/nationality/{nation}")
    public List<Driver> getDriversByNationality(@PathVariable String nation) {
        return driverRepository.findByNationality(nation);
    }
}


