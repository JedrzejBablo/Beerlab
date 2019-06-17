package com.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Currency {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Double purchasePrice;
    private Double sellingPrice;
}
