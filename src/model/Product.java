package model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
    private Integer code;
    private String name;
    private Double price;
    private Boolean inStock;
}
