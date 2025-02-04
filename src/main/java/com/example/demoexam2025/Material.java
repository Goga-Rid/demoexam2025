package com.example.demoexam2025;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Material {
    private int materialId;
    private String name;
    private int supplierId;
    private String unit;
    private String description;
    private String image;
    private Double price;
    private int quantityInStock;
    private int minQuantity;
}
