package com.nice.gestion.service;

import com.nice.gestion.dto.JoueurDto;
import com.nice.gestion.entity.EquipeEntity;
import com.nice.gestion.entity.JoueurEntity;
import com.nice.gestion.repository.EquipeRepository;
import com.nice.gestion.repository.JoueurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JoueurService {

  @Autowired
  private JoueurRepository joueurRepository;
  @Autowired
  private EquipeRepository equipeRepository;

  public JoueurDto ajouterJoueur(JoueurDto joueurDto) {
    joueurRepository.save(buildJoueurEntity(joueurDto));
    return joueurDto;
  }

  private JoueurEntity buildJoueurEntity(JoueurDto joueurDto) {
    JoueurEntity joueurEntity = new JoueurEntity();
    joueurEntity.setName(joueurDto.getName());
    joueurEntity.setPosition(joueurDto.getPosition());

    Optional<EquipeEntity> equipeEntity = equipeRepository.findById(joueurDto.getId());
    joueurEntity.setEquipe(equipeEntity.orElse(null));

    return joueurEntity;
  }
}
