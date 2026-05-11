package az.edu.ada.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "name can not be empty")
    @Size(min = 2, max = 50, message = "Can not be less than 2 and more than 50")
    private String fullName;

    @NotBlank(message = "email can not be empty")
    @Email(message = "Email must be valid")
    private String email;


    @NotNull(message = "age can not be empty")
    @Min(value = 16, message = "bla bla min")
    @Max(value = 150, message = "alb alb max")
    private Integer age;

    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }
}