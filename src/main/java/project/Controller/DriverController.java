package project.Controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import project.Repository.DriverStandings.Driver;
import project.Repository.DriverStandings.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/nationality/{nation}")
    public List<Driver> getDriversByNationality(@PathVariable @NotBlank @Pattern(regexp = "^[A-Za-z]+$", message = "Name must contain only letters")  String nation) {
        return driverRepository.findByNationality(nation);
    }
}


