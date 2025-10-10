package project.Controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import org.springframework.web.bind.annotation.*;
import project.Repository.DriverStandings.Driver;
import project.Repository.DriverStandings.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/drivers")
@Validated
public class DriverController {

    @Autowired
    DriverRepository driverRepository;

    @Tag(name = "Driver data" , description = "Detailed information about drivers")
    @GetMapping
    public List <Driver> getAll(){
        return driverRepository.findAll();
    }

    @Tag(name = "Find driver" , description ="Finding driver by his id")
    @GetMapping("/{Id}")
    public Optional<Driver> getById(@PathVariable @Positive(message = "round must be positive") Long Id)  {
        return driverRepository.findById(Id);
    }

    @Tag(name = "Filtering drivers",description = "Filtering drivers by nationality")
    @GetMapping("/nationality")
    public List<Driver> getDriversByNationality(
            @RequestParam("nation") String nation
    ) {
        return driverRepository.findByNationality(nation);
    }

}


