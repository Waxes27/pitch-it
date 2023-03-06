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

import com.example.demo.Enum.Location;
import com.example.demo.Models.LocationModel;

@RestController
public class LocationController {

    public LocationController() {
    }

    @GetMapping("/locations")
    CollectionModel<EntityModel<LocationModel>> all() {
        List<Location> locations = Arrays.asList(Location.values());

        List<EntityModel<LocationModel>> entities = locations.stream()
            .map((entity) -> EntityModel.of(new LocationModel(entity.toString())))
            .collect(Collectors.toList());

        return CollectionModel.of(entities, linkTo(methodOn(IndustryController.class).all()).withSelfRel());
    }
    
}
