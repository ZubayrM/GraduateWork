package main.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Tags {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String name;

}
