package com.nice.gestion.service;

import com.nice.gestion.dto.EquipeDto;
import com.nice.gestion.dto.JoueurDto;
import com.nice.gestion.entity.EquipeEntity;
import com.nice.gestion.entity.JoueurEntity;
import com.nice.gestion.repository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EquipeService {

  @Autowired
  private EquipeRepository equipeRepository;

  public Page<EquipeDto> recupererEquipes(int page, int size, String sortBy) {
    return equipeRepository.findAll(PageRequest.of(page, size, Sort.by(sortBy)))
      .map(this::buildEquipeDto);
  }

  public EquipeDto ajouterEquipe(EquipeDto dto) {
    EquipeEntity equipe = new EquipeEntity();
    equipe.setName(dto.getName());
    equipe.setAcronym(dto.getAcronym());
    equipe.setBudget(dto.getBudget());

    if (!dto.getJoueurs().isEmpty()) {
      List<JoueurEntity> joueurs = dto.getJoueurs().stream()
        .map(joueur -> {
          JoueurEntity joueurEntity = new JoueurEntity();
          joueurEntity.setName(joueur.getName());
          joueurEntity.setPosition(joueur.getPosition());
          joueurEntity.setEquipe(equipe);
          return joueurEntity;
        }).collect(Collectors.toList());

      equipe.setJoueurs(joueurs);
    }

    return buildEquipeDto(equipeRepository.save(equipe));
  }

  private EquipeDto buildEquipeDto(EquipeEntity equipeEntity) {
    List<JoueurDto> joueurDtos = (equipeEntity.getJoueurs() == null || equipeEntity.getJoueurs().isEmpty())
      ? Collections.emptyList()
      : equipeEntity.getJoueurs().stream()
      .map(this::buildJoueurDto)
      .toList();

    return EquipeDto.builder()
      .id(equipeEntity.getId())
      .name(equipeEntity.getName())
      .acronym(equipeEntity.getAcronym())
      .joueurs(joueurDtos)
      .build();
  }

  private JoueurDto buildJoueurDto(JoueurEntity joueurEntity) {
    return JoueurDto.builder()
      .id(joueurEntity.getId())
      .name(joueurEntity.getName())
      .position(joueurEntity.getPosition())
      .build();
  }
}