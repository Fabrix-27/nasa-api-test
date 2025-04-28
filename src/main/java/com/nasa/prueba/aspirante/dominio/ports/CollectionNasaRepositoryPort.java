package com.nasa.prueba.aspirante.dominio.ports;

import com.nasa.prueba.aspirante.dominio.models.CollectionNasa;

import java.util.List;

public interface CollectionNasaRepositoryPort {
    CollectionNasa guardarItem(CollectionNasa collectionNasa);
    List<CollectionNasa> getAllCollectionNasaOrderedByIdDesc();
}
