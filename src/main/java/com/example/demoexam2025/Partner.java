package com.example.demoexam2025;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Partner {
    private int partnerId;
    private String name;
    private String legalAddress;
    private String inn;
    private String directorName;
    private String contactPhone;
    private String contactEmail;
    private String logo;
    private int rating;
    private String history;
}

