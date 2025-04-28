package com.nasa.prueba.aspirante.infraestructura.controllers;

import com.nasa.prueba.aspirante.aplicacion.services.CollectionNasaService;
import com.nasa.prueba.aspirante.dominio.models.CollectionNasa;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/collection-nasa")
public class CollectionNasaController {

    private final CollectionNasaService collectionNasaService;

    public CollectionNasaController(CollectionNasaService collectionNasaService) {
        this.collectionNasaService = collectionNasaService;
    }

    @GetMapping
    public List<CollectionNasa> getAllCollectionNasa() {
        // Llama al servicio que ya tienes para obtener los datos ordenados
        return collectionNasaService.getAllCollectionNasa();
    }


}
