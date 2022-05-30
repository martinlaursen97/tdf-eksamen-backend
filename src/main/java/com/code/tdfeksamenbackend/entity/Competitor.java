package com.code.tdfeksamenbackend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.yaml.snakeyaml.events.Event;

import javax.persistence.*;
import java.util.List;

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

    @JsonBackReference(value = "cStageLineItems")
    @OneToMany(mappedBy = "competitor", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<StageLineItem> stageLineItems;


    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "age", nullable = false)
    private Integer age;

}
