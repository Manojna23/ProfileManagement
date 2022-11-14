package org.profile.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Profile {
    private int profileId;
    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private Integer age;
    private String designation;
}
