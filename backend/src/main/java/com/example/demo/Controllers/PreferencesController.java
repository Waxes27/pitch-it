package com.example.demo.Controllers;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo; 
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Enum.CustomerGroup;
import com.example.demo.Enum.InvestmentStage;
import com.example.demo.Enum.SEISPreference;
import com.example.demo.ErrorHandling.PreferencesNotFoundException;
import com.example.demo.Models.CustomerGroupModel;
import com.example.demo.Models.InvestmentStageModel;
import com.example.demo.Models.Preferences;
import com.example.demo.Models.SEISPreferenceModel;
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
    ResponseEntity<?> newPreferences(@RequestBody Preferences p) {
        Preferences preferences = repository.save(p);
        EntityModel<Preferences> entity = EntityModel.of(preferences,
            linkTo(methodOn(PreferencesController.class).one(preferences.getId())).withSelfRel());
    
        return ResponseEntity
            .created(entity.getRequiredLink(IanaLinkRelations.SELF).toUri())
            .body(entity);
    }

    @GetMapping("/investmentstages")
    CollectionModel<EntityModel<InvestmentStageModel>> investmentStages() {
        List<InvestmentStage> investmentStages = Arrays.asList(InvestmentStage.values());

        List<EntityModel<InvestmentStageModel>> entities = investmentStages.stream()
            .map((entity) -> EntityModel.of(new InvestmentStageModel(entity.toString())))
            .collect(Collectors.toList());

        return CollectionModel.of(entities, linkTo(methodOn(PreferencesController.class).investmentStages()).withSelfRel());
    }

    @GetMapping("/customergroups")
    CollectionModel<EntityModel<CustomerGroupModel>> customerGroups() {
        List<CustomerGroup> customerGroups = Arrays.asList(CustomerGroup.values());

        List<EntityModel<CustomerGroupModel>> entities = customerGroups.stream()
            .map((entity) -> EntityModel.of(new CustomerGroupModel(entity.toString())))
            .collect(Collectors.toList());

        return CollectionModel.of(entities, linkTo(methodOn(PreferencesController.class).customerGroups()).withSelfRel());
    }

    @GetMapping("/seisPreferences")
    CollectionModel<EntityModel<SEISPreferenceModel>> seisPreferences() {
        List<SEISPreference> seisPreferences = Arrays.asList(SEISPreference.values());

        List<EntityModel<SEISPreferenceModel>> entities = seisPreferences.stream()
            .map((entity) -> EntityModel.of(new SEISPreferenceModel(entity.toString())))
            .collect(Collectors.toList());

        return CollectionModel.of(entities, linkTo(methodOn(PreferencesController.class).seisPreferences()).withSelfRel());
    }
}
