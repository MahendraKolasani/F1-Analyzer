package project.Repository.DriverStandings;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "drivers")
public class Driver {

    @Id
    private int driverId;

    private String driverRef;
    private Integer number; // Use Integer to allow null values
    private String code;
    private String forename;
    private String surname;
    private String dob;
    private String nationality;
    private String url;

    public String getFullName() {
        return forename + " " + surname;
    }

    // Getters and setters
    public int getDriverId() { return driverId; }
    public void setDriverId(int driverId) { this.driverId = driverId; }

    public String getDriverRef() { return driverRef; }
    public void setDriverRef(String driverRef) { this.driverRef = driverRef; }

    public Integer getNumber() { return number; }
    public void setNumber(Integer number) { this.number = number; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getForename() { return forename; }
    public void setForename(String forename) { this.forename = forename; }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }

    public String getNationality() { return nationality; }
    public void setNationality(String nationality) { this.nationality = nationality; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
}
