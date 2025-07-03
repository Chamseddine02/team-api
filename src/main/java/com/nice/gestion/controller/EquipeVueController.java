package com.nice.gestion.controller;

import com.nice.gestion.entity.JoueurEntity;
import com.nice.gestion.model.Joueur;
import org.springframework.ui.Model;
import com.nice.gestion.model.Equipe;
import com.nice.gestion.repository.*;

import com.nice.gestion.repository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.nice.gestion.entity.EquipeEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@Controller
public class EquipeVueController {
    @Autowired
    private EquipeRepository equipeRepository;

    @GetMapping("/equipes")
    public String showEquipes(Model model) {
        List<EquipeEntity> equipeEntities = equipeRepository.findAll();

        List<Equipe> equipes = equipeEntities.stream()
                .map(this::convertToModel)
                .toList();

        model.addAttribute("equipes", equipes);
        return "equipes";
    }

    private Equipe convertToModel(EquipeEntity entity) {
        Equipe equipe = new Equipe();
        equipe.setId(Long.valueOf(entity.getId()));
        equipe.setName(entity.getName());
        equipe.setAcronym(entity.getAcronym());
        equipe.setBudget(entity.getBudget());
        return equipe;
    }
    // Afficher le formulaire d'ajout d'équipe
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("equipe", new Equipe());
        return "equipe_form";
    }

    // Traiter la soumission du formulaire
    @PostMapping("/add")
    public String addEquipe(@ModelAttribute Equipe equipe, Model model) {

        if (equipe.getName() == null || equipe.getName().isEmpty() || equipe.getBudget() == null) {
            model.addAttribute("error", "Le nom et le budget sont obligatoires");
            return "equipe_form";
        }

        EquipeEntity entity = new EquipeEntity();
        entity.setName(equipe.getName());
        entity.setAcronym(equipe.getAcronym());
        entity.setBudget(equipe.getBudget());

        equipeRepository.save(entity);

        return "redirect:/equipes";
    }
}
