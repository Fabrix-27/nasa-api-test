package com.nasa.prueba.aspirante.infraestructura.mappers;

import com.nasa.prueba.aspirante.dominio.models.CollectionNasa;
import com.nasa.prueba.aspirante.infraestructura.entities.CollectionNasaEntity;
import org.springframework.stereotype.Component;

@Component
public class CollectionNasaMapper {
    public CollectionNasaEntity toEntity(CollectionNasa domain) {
        CollectionNasaEntity entity = new CollectionNasaEntity();
        entity.setId(domain.getId());
        entity.setNasa_id(domain.getNasaId());
        entity.setHref(domain.getHref());
        entity.setTitle(domain.getTitle());
        entity.setCenter(domain.getCenter());
        entity.setDate_created(domain.getDateCreated());
        return entity;
    }

    public CollectionNasa toDomain(CollectionNasaEntity entity) {
        return new CollectionNasa(
                entity.getId(),
                entity.getNasa_id(),
                entity.getHref(),
                entity.getCenter(),
                entity.getTitle(),
                entity.getDate_created()
        );
    }
}
