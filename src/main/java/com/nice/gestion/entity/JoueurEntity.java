package com.nice.gestion.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="joueur")
public class JoueurEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String position;

    @ManyToOne
    @JoinColumn(name = "fk_id_equipe", nullable = false)
    @JsonBackReference
    private EquipeEntity equipe;
}

