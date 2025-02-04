package com.example.demoexam2025;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {
    private int supplierId;
    private String name;
    private String inn;
    private String supplyHistory;
}
