package com.example.metricparser.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@AllArgsConstructor
@Getter
@Setter
@Table(name = "addition")
public class Addition {
    @Id
    private long id;
    @Column(name = "manufacturer")
    private String manufacturer;
    @Column(name = "cost")
    private  double cost;
    @Column(name = "yearOfRelease")
    private Date yearOfRelease;
    @Column(name = "voltageInAmperes")
    private int voltageInAmperes;
    public Addition() {

    }
}
