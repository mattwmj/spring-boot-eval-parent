package com.smec.eis.example.springbooteval.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "JSWJ")
public class TechDoc implements Serializable {
    private static final long serialVersionUID = 1517620509400423751L;
    @Id
    private Long id;
    @Column(name = "MCH")
    private String name;
    @Column(name = "ZLDH")
    private String code;
    @Column(name = "BBH")
    private String version;
    @Enumerated
    @Column(name = "LANG")
    private Language language;
    @Column(name = "FNAME")
    private String fileName;
}
