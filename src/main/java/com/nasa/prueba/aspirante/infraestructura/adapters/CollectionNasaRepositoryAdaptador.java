package com.nasa.prueba.aspirante.infraestructura.adapters;

import com.nasa.prueba.aspirante.dominio.models.CollectionNasa;
import com.nasa.prueba.aspirante.dominio.ports.CollectionNasaRepositoryPort;
import com.nasa.prueba.aspirante.infraestructura.entities.CollectionNasaEntity;
import com.nasa.prueba.aspirante.infraestructura.mappers.CollectionNasaMapper;
import com.nasa.prueba.aspirante.infraestructura.repositories.CollectionNasaRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class CollectionNasaRepositoryAdaptador implements CollectionNasaRepositoryPort {
    private final CollectionNasaRepository jpaRepository;
    private final CollectionNasaMapper collectionNasaMapper;

    public CollectionNasaRepositoryAdaptador(CollectionNasaRepository jpaRepository, CollectionNasaMapper collectionNasaMapper) {
        this.jpaRepository = jpaRepository;
        this.collectionNasaMapper = collectionNasaMapper;
    }


    @Override
    public CollectionNasa guardarItem(CollectionNasa collectionNasa) {
        CollectionNasaEntity entity = collectionNasaMapper.toEntity(collectionNasa);
        CollectionNasaEntity savedEntity = jpaRepository.save(entity);
        return collectionNasaMapper.toDomain(savedEntity);
    }

    @Override
    public List<CollectionNasa> getAllCollectionNasaOrderedByIdDesc() {
        List<CollectionNasaEntity> entities = jpaRepository.findAllByOrderByIdDesc();

        // Convertir las entidades a modelos de dominio
        return entities.stream()
                .map(collectionNasaMapper::toDomain)
                .collect(Collectors.toList());
    }

    //Para GitHub

}
