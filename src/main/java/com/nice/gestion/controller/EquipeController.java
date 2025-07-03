package com.nice.gestion.controller;

import com.nice.gestion.dto.EquipeDto;
import com.nice.gestion.service.EquipeService;
import com.nice.gestion.service.JoueurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/equipes")
public class EquipeController {

  @Autowired
  private EquipeService equipeService;
    @Autowired
    private JoueurService joueurService;

  @GetMapping
  public ResponseEntity<Page<EquipeDto>> recupererEquipes(
    @RequestParam(defaultValue = "0") int page,
    @RequestParam(defaultValue = "10") int size,
    @RequestParam(defaultValue = "id") String sortBy) {
    return ResponseEntity.ok(equipeService.recupererEquipes(page, size, sortBy));
  }

  @PostMapping
  public ResponseEntity<EquipeDto> ajouterEquipe(@RequestBody EquipeDto equipe) {
    return ResponseEntity.ok(equipeService.ajouterEquipe(equipe));
  }
}

