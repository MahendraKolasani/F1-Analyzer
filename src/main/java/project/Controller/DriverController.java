package project.Controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import project.Repository.DriverStandings.Driver;
import project.Service.DriverService;

import java.util.List;

@RestController
@RequestMapping("/drivers")
@Validated
public class DriverController {

    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @Tag(name = "Driver data", description = "Detailed information about drivers")
    @GetMapping
    public List<Driver> getAll() {
        return driverService.getAllDrivers();
    }

    @Tag(name = "Find driver", description = "Finding driver by his id")
    @GetMapping("/{id}")
    public Driver getById(
            @PathVariable
            @Positive(message = "Id must be positive")
            Long id) {

        return driverService.getDriverById(id);
    }

    @Tag(name = "Filtering drivers", description = "Filtering drivers by nationality")
    @GetMapping("/nationality/{nation}")
    public List<Driver> getDriversByNationality(
            @PathVariable
            @NotBlank
            @Pattern(
                    regexp = "^[A-Za-z]+$",
                    message = "Name must contain only letters")
            String nation) {

        return driverService.getDriversByNationality(nation);
    }
}