package com.nice.gestion.dto;


import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class EquipeDto {
    private int id;
    private String name;
    private String acronym;
    private Double budget;
    private List<JoueurDto> joueurs;
}
