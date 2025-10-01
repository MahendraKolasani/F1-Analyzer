package main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface DriverRepository extends JpaRepository< Driver, Long > {

    List<Driver> findByNationality(String nation);
}
