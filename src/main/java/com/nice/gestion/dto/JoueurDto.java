package com.nice.gestion.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JoueurDto {
    private int id;
    private String name;
    private String position;
    private int equipeId;
}
