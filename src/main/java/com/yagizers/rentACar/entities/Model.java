package com.yagizers.rentACar.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "models")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="modelId")
    private int modelId;

    @Column(name="modelName")
    private String modelName;

    @ManyToOne
    @JoinColumn(name="brandId")
    private Brand brand;

    @OneToMany(mappedBy = "model")
    private List<Car> cars;
}
