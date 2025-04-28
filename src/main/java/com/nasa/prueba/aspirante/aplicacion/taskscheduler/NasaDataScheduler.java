package com.nasa.prueba.aspirante.aplicacion.taskscheduler;

import com.nasa.prueba.aspirante.aplicacion.services.CollectionNasaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NasaDataScheduler {
    private final CollectionNasaService servicio;

    public NasaDataScheduler(CollectionNasaService servicio) {
        this.servicio = servicio;
    }

    // Implement the scheduled task to fetch and save data from NASA API
    // @Scheduled(fixedRate = 60000) // Example: run every minute
    @Scheduled(fixedRate = 60000) // Example: run every day at midnight
    public void fetchNasaDataAndSave() {

        try {
            log.info("[Scheduler] Iniciando tarea automática de guardado de datos NASA...");
            int savedCount = servicio.fetchAndSaveCollectionNasa();
        } catch (Exception e) {
            System.out.println("Error ejecutando tarea programada: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
