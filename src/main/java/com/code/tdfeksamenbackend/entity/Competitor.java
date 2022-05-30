package com.code.tdfeksamenbackend.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.yaml.snakeyaml.events.Event;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
public class Competitor {

    @Id
    @Column(name = "competitor_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "age", nullable = false)
    private Integer age;

}
