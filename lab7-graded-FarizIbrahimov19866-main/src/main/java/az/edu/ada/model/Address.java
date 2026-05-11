package az.edu.ada.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "City can not be empty")
    private String city;
    @NotBlank(message = "Street can not be empty")
    private String street;
    @NotBlank(message = "postalCode can not be empty")
    @Pattern(regexp = "AZ\\d{4}", message = "postalCode must be in a right format")
    private String postalCode;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }

    public String getPostalCode() { return postalCode; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }
}