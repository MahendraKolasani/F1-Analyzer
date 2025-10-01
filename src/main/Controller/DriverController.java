package main.Controller;

import main.Repository.Driver;
import main.Repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
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
    DriverRepository dr;

    @GetMapping
    public List <Driver> getAll(){
        return dr.findAll();
    }

    @GetMapping("/{Id}")
    public Optional<Driver> getById(@PathVariable Long Id)  {
        return dr.findById(Id);
    }

    @GetMapping("/nationality/{nation}")
    public List<Driver> getDriversByNationality(@PathVariable String nation) {
        return dr.findByNationality(nation);
    }
}


