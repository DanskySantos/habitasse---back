package com.project.habitasse.domain.address.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_country")
@SequenceGenerator(name = "default_gen", sequenceName = "role_seq", allocationSize = 1)
public class Country implements Serializable {

    private static final long serialVersionUID = 3270601256011818010L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.PROPERTY)
    protected Integer id;

    @Column(name = "nome", length = 255)
    private String nome;

    @Column(name = "nome_pt", length = 255)
    private String nome_pt;

    @Column(name = "sigla", length = 255)
    private String sigla;

    @Column(name = "bacen", length = 255)
    private String bacen;
}
