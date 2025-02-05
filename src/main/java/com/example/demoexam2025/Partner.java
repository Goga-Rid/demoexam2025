package com.example.demoexam2025;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Partner {
    private int partnerId;
    private String partner_type;
    private String partner_name;
    private String director;
    private String email;
    private String phone;
    private String legal_address;
    private String inn;
    private int rating;
    private int totalSales; ;
}

