package com.code.tdfeksamenbackend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
public class StageLineItem {

    @Id
    @Column(name = "stage_line_item_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "stage_id")
    private Stage stage;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "competitor_id")
    private Competitor competitor;

    @Column(name = "time")
    private Double time;

    @Column(name = "mountain_points")
    private Double mountainPoints;

    @Column(name = "sprint_points")
    private Double sprintPoints;
}
