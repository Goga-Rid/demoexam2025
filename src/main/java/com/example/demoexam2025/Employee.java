package com.example.demoexam2025;

import lombok.*;
import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private int employeeId;
    private String fullName;
    private Date birthDate;
    private String passportData;
    private String bankDetails;
    private Boolean familyStatus;
    private Boolean healthStatus;
}

