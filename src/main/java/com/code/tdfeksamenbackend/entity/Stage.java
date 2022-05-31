package com.code.tdfeksamenbackend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
public class Stage {
    @Id
    @Column(name = "stage_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference(value = "sStageLineItems")
    @OneToMany(mappedBy = "stage", cascade = CascadeType.MERGE)
    @ToString.Exclude
    private List<StageLineItem> stageLineItems;

    @Column(name = "date")
    private LocalDateTime date;
}
