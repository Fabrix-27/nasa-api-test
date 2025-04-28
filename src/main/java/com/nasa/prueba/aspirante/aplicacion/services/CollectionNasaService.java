package com.nasa.prueba.aspirante.aplicacion.services;

import com.nasa.prueba.aspirante.dominio.dto.DataDto;
import com.nasa.prueba.aspirante.dominio.dto.ItemDto;
import com.nasa.prueba.aspirante.dominio.models.CollectionNasa;
import com.nasa.prueba.aspirante.dominio.ports.CollectionNasaRepositoryPort;
import com.nasa.prueba.aspirante.infraestructura.adapters.CollectionNasaRepositoryAdaptador;
import com.nasa.prueba.aspirante.infraestructura.clientes.NasaApiClients;
import com.nasa.prueba.aspirante.infraestructura.repositories.CollectionNasaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CollectionNasaService {
    private final NasaApiClients nasaApiClient;
    private final CollectionNasaRepositoryPort puerto;


    public CollectionNasaService(NasaApiClients nasaApiClient, CollectionNasaRepositoryPort puerto) {
        this.nasaApiClient = nasaApiClient;
        this.puerto = puerto;
    }
    // Implement methods to fetch data from the API and save it to the repository
    @Transactional
    public int fetchAndSaveCollectionNasa() {
        log.info("[Service] Llamando a API de NASA para obtener datos...");

        List<CollectionNasa> nasaItems = nasaApiClient.fetchCollectionNasa();

        log.info("[Service] Respuesta de NASA API (antes de validar): {}", nasaItems);

        if (nasaItems == null || nasaItems.isEmpty()) {
            log.warn("[Service] No se encontraron datos para guardar.");
            return 0;
        }

        log.info("[Service] Datos recibidos de la NASA: {} registros", nasaItems.size());

        for (CollectionNasa item : nasaItems) { // Itera directamente sobre los elementos de la lista
            // Guarda en la base de datos o realiza cualquier otra operación aquí
            puerto.guardarItem(item);
        }

        log.info("[Service] Datos guardados exitosamente en la base de datos.");
        return nasaItems.size();
    }


    // Método para obtener todos los elementos ordenados por ID descendente
    public List<CollectionNasa> getAllCollectionNasa() {
        // Usamos el puerto para acceder a la base de datos y obtener los datos ordenados
        return puerto.getAllCollectionNasaOrderedByIdDesc();
    }

}
