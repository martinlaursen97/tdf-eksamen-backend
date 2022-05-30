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
public class StageLineItem {

    @Id
    @Column(name = "stage_line_item_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "stage_id", nullable = false)
    private Stage stage;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "competitor_id", nullable = false)
    private Competitor competitor;

    @Column(name = "time")
    private Double time;

    @Column(name = "mountain_points")
    private Integer mountainPoints;

    @Column(name = "sprint_points")
    private Integer springPoints;



}
