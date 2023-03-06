package com.example.demo.Controllers;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo; 
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ErrorHandling.PreferencesNotFoundException;
import com.example.demo.Models.Preferences;
import com.example.demo.Repositories.PreferencesRepository;


@RestController
public class PreferencesController {
 
    private final PreferencesRepository repository;

    public PreferencesController(PreferencesRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/preferences/{id}")
    EntityModel<Preferences> one(@PathVariable Long id) {
        Preferences preferences = repository.findById(id)
            .orElseThrow(() -> new PreferencesNotFoundException(id));

        return EntityModel.of(preferences,
            linkTo(methodOn(PreferencesController.class).one(preferences.getId())).withSelfRel());
    }


    @PostMapping("/preferences")
    Preferences newPreferences(@RequestBody Preferences p) {
        Preferences preferences = repository.save(p);
        EntityModel<Preferences> entity = EntityModel.of(preferences,
            linkTo(methodOn(PreferencesController.class).one(preferences.getId())).withSelfRel());
    
        return ResponseEntity
            .created(entity.getRequiredLink(IanaLinkRelations.SELF).toUri())
            .body(entity);
        }
}
