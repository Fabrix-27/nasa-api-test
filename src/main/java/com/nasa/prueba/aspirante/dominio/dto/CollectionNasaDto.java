package com.nasa.prueba.aspirante.dominio.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nasa.prueba.aspirante.dominio.models.CollectionNasa;
import org.hibernate.mapping.Collection;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CollectionNasaDto {
    private Collection collection;

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Collection {
        private List<ItemDto> items;

        public List<ItemDto> getItems() {
            return items;
        }

        public void setItems(List<ItemDto> items) {
            this.items = items;
        }
    }
}
