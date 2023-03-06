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

import com.example.demo.Enum.ProductStage;
import com.example.demo.Models.IndustryModel;
import com.example.demo.Models.ProductStageModel;

@RestController
public class ProductStageController {

    public ProductStageController() {
    }

    @GetMapping("/productstages")
    CollectionModel<EntityModel<ProductStageModel>> all() {
        List<ProductStage> productStages = Arrays.asList(ProductStage.values());

        List<EntityModel<ProductStageModel>> entities = productStages.stream()
            .map((entity) -> EntityModel.of(new ProductStageModel(entity.toString())))
            .collect(Collectors.toList());

        return CollectionModel.of(entities, linkTo(methodOn(ProductStageController.class).all()).withSelfRel());
    }    
}
