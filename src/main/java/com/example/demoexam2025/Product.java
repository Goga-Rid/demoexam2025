package com.example.demoexam2025;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private int productId;
    private String article;
    private String name;
    private String description;
    private Double minPrice;
    private Double sizeLength;
    private Double sizeWidth;
    private Double sizeHeight;
    private Double weightNoPackage;
    private Double weightWithPackage;
    private String qualityCertificate;
    private String standardNumber;
    private int manufacturingTime;
    private Double cost;
    private int workshopNumber;
    private int workersCount;
}
