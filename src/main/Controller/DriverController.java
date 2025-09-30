package main.Controller;

import main.Repository.Driver;
import main.Repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DriverController {

    @Autowired
    DriverRepository dr;

    @GetMapping("/drivers")
    public List <Driver> GetAll(){
        return dr.findAll();
    }
}

