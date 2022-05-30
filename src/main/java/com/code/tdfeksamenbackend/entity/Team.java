package com.code.tdfeksamenbackend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
public class Team {

    @Id
    @Column(name = "team_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "team_name")
    private String name;

    @JsonBackReference(value = "tCompetitors")
    @OneToMany(mappedBy = "team", cascade = CascadeType.MERGE)
    @ToString.Exclude
    private List<Competitor> competitors;

}
