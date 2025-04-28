package com.nasa.prueba.aspirante.dominio.models;



import javax.persistence.*;
import java.time.LocalDateTime;



public class CollectionNasa {
    private Long id;
    private String nasaId;
    private String href;
    private String center;
    private String title;
    private LocalDateTime dateCreated;

    public CollectionNasa() {
    }

    public CollectionNasa(Long id, String nasaId, String href, String center, String title, LocalDateTime dateCreated) {
        this.id = id;
        this.nasaId = nasaId;
        this.href = href;
        this.center = center;
        this.title = title;
        this.dateCreated = dateCreated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNasaId() {
        return nasaId;
    }

    public void setNasaId(String nasaId) {
        this.nasaId = nasaId;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }
}
