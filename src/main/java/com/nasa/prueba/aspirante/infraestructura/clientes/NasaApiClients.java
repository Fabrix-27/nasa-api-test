package com.nasa.prueba.aspirante.infraestructura.clientes;

import com.nasa.prueba.aspirante.dominio.dto.CollectionNasaDto;
import com.nasa.prueba.aspirante.dominio.dto.DataDto;
import com.nasa.prueba.aspirante.dominio.dto.ItemDto;
import com.nasa.prueba.aspirante.dominio.models.CollectionNasa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
@Slf4j
public class NasaApiClients {
    @Value("${nasa.api.url}")
    private String nasaApiUrl;

    private final RestTemplate restTemplate;

    public NasaApiClients(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<CollectionNasa> fetchCollectionNasa() {
        CollectionNasaDto response = restTemplate.getForObject(nasaApiUrl, CollectionNasaDto.class);
        log.info("[API] Response NASA..." + response.getCollection().getItems());
        // Suponiendo que la API devuelve un array de items
        if (response != null && response.getCollection() != null) {
            List<CollectionNasa> collectionNasaList = new ArrayList<>();

            for (ItemDto item : response.getCollection().getItems()) {
                if (item.getData() != null && !item.getData().isEmpty()) {
                    DataDto data = item.getData().get(0);

                    CollectionNasa nasa = new CollectionNasa();
                    nasa.setHref(item.getHref());
                    nasa.setNasaId(data.getNasa_id());
                    nasa.setTitle(data.getTitle());
                    nasa.setCenter(data.getCenter());
                    nasa.setDateCreated(LocalDateTime.now());

                    collectionNasaList.add(nasa);
                }
            }

            return collectionNasaList;
        } else {
            return Collections.emptyList();
        }
    }
}
