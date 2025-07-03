package com.nice.gestion.controller;

import com.nice.gestion.dto.JoueurDto;
import com.nice.gestion.service.JoueurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/joueur")
public class JoueurController {

  @Autowired
  private JoueurService joueurService;

  @PostMapping
  public ResponseEntity<JoueurDto> ajouterJoueur(@RequestBody JoueurDto joueurDto) {
    return ResponseEntity.ok(joueurService.ajouterJoueur(joueurDto));
  }
}
