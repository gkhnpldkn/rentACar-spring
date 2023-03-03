package com.rentacar.springcamp.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "cars")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Car {
    @Id //  bu anıtasyonu verevrek bunun PK olduğunu belirtiyotuz
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "id")
    private int id;
    @Column(name = "plate",unique = true)
    private  String plate;
    @Column(name = "dailyPrice")
    private double dailyPrice;
    @Column(name = "modelYear")
    private  int modelYear;
    @Column(name = "state")// 1-Available,2-Rented,3-Maintenance
    private int state;
    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

}
