package org.example.minievaluation.controller;

import org.example.minievaluation.dto.CoursDto;
import org.example.minievaluation.service.CoursService;
import org.example.minievaluation.service.ICoursService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class CoursController {

    private static final Logger logger = LoggerFactory.getLogger(CoursController.class);

    private ICoursService coursService = new CoursService();;
    private static final String REDIRECT_TO_COURS_LIST = "cours";

    @GetMapping("/cours")
    public String showCours(Model model) {
        logger.info("CoursController - liste des cours");
        logger.debug("Initialisation de l'objet coursService : " + coursService);
        //try {
            Optional<List<CoursDto>> cours = coursService.findAll();
            model.addAttribute("coursList", cours.orElse(new ArrayList<>()));
//        } catch (Exception e) {
//            logger.error("Erreur lors de la récupération des données", e);
//        }

        return REDIRECT_TO_COURS_LIST;
    }

    @GetMapping("/cours/new")
    public String newCours(Model model) {
        return "new-cours";
    }

    @PostMapping("/cours/create")
    public String saveCours(
            @RequestParam("matiere") String matiere,
            @RequestParam("professeur") String professeur,
            @RequestParam("classe") String classe) {

        logger.info("CoursController - Méthode POST appelée pour enregistrer un cours");
        logger.debug("CoursController - Paramètres reçus : ref={}, name={}, stock={}", matiere, professeur, classe);

        CoursDto coursDto = new CoursDto();
        coursDto.setMatiere(matiere);
        coursDto.setProfesseur(professeur);
        coursDto.setClasse(classe);

        try {
            boolean createdCours = coursService.save(coursDto);

            if (createdCours) {
                logger.info("CoursController - Cours enregistré avec succès");
            } else {
                logger.warn("CoursController - Échec de l'enregistrement du cours");
            }
        } catch (Exception e) {
            logger.error("CoursController - Erreur lors de l'enregistrement du cours", e);
        }

        return "redirect:/cours";
    }
}
