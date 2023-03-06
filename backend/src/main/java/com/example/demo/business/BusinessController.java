package com.example.demo.business;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo; 
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BusinessController {
    
    private final BusinessRepository repository;

    private final BusinessModelAssembler assembler;

    public BusinessController(BusinessRepository repository, BusinessModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }


    @GetMapping("/businesses")
    CollectionModel<EntityModel<Business>> all() {

        List<EntityModel<Business>> businesses = repository.findAll().stream()
            .map(assembler::toModel)
            .collect(Collectors.toList());

        return CollectionModel.of(businesses, linkTo(methodOn(BusinessController.class).all()).withSelfRel());
    }


    @PostMapping("/businesses")
    ResponseEntity<?> newBusiness(@RequestBody Business newBusiness) {

        EntityModel<Business> entityModel = assembler.toModel(repository.save(newBusiness));

        return ResponseEntity
            .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
            .body(entityModel);
    }


    @GetMapping("/businesses/{id}")
    EntityModel<Business> one(@PathVariable Long id) {
        Business business = repository.findById(id)
            .orElseThrow(() -> new BusinessNotFoundException(id));

        return assembler.toModel(business);
    }


    @PutMapping("/businesses/{id}")
    ResponseEntity<?> replaceBusiness(@RequestBody Business newBusiness, @PathVariable Long id) {

        Business updatedBusiness = repository.findById(id)
            .map(business -> {
                business.setName(newBusiness.getName());
                business.setRepresentativeFirstName(newBusiness.getRepresentativeFirstName());
                business.setRepresentativeLastName(newBusiness.getRepresentativeLastName());
                business.setRole(newBusiness.getRole());
                business.setEmail(newBusiness.getEmail());
                business.setPassword(newBusiness.getPassword());

                return repository.save(business);
            })
            .orElseGet(() -> {
                newBusiness.setId(id);

                return repository.save(newBusiness);
            });

        EntityModel<Business> entityModel = assembler.toModel(updatedBusiness);

        return ResponseEntity
            .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
            .body(entityModel);
    }
    
    
    @DeleteMapping("/businesses/{id}")
    ResponseEntity<?> deleteBusiness(@PathVariable Long id) {
        
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
