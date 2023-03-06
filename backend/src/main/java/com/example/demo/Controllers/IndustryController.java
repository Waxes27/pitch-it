package com.example.demo.Controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo; 
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Enum.Industry;
import com.example.demo.Models.IndustryModel;
import com.example.demo.Repositories.IndustryRepository;

import jakarta.persistence.Entity;

@RestController
public class IndustryController {
    

    public IndustryController() {
    }

    @GetMapping("/industries")
    CollectionModel<EntityModel<IndustryModel>> all() {
        List<Industry> industries = Arrays.asList(Industry.values());

        List<EntityModel<IndustryModel>> entities = industries.stream()
            .map((entity) -> EntityModel.of(new IndustryModel(entity.toString())))
            .collect(Collectors.toList());

        return CollectionModel.of(entities, linkTo(methodOn(IndustryController.class).all()).withSelfRel());
    }

}
