package com.nasa.prueba.aspirante.infraestructura.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name= "tb_collection_nasa")
@Data
public class CollectionNasaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id" )
    private Long id;
    @Column(name = "nasa_id")
    private String nasa_id;
    @Column(name = "href")
    private String href;
    @Column(name = "title")
    private String title;
    @Column(name = "center")
    private String center;
    @Column(name = "date_created")
    private LocalDateTime date_created;
}
