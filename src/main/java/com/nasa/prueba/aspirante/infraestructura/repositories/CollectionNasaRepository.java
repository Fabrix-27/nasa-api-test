package com.nasa.prueba.aspirante.infraestructura.repositories;

import com.nasa.prueba.aspirante.dominio.models.CollectionNasa;
import com.nasa.prueba.aspirante.infraestructura.entities.CollectionNasaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollectionNasaRepository extends JpaRepository<CollectionNasaEntity, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
    List<CollectionNasaEntity> findAllByOrderByIdDesc();

}
