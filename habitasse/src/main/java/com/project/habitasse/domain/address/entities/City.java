package com.project.habitasse.domain.address.entities;

import com.project.habitasse.domain.common.SuperclassEntity;
import com.project.habitasse.domain.propertyDemand.entities.request.PropertyDemandRequest;
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
@Table(name = "tb_city")
@SequenceGenerator(name = "default_gen", sequenceName = "role_seq", allocationSize = 1)
public class City implements Serializable {

    private static final long serialVersionUID = 3270601256011818010L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.PROPERTY)
    protected Integer id;

    @Column(name = "nome", length = 255)
    private String nome;

    @Column(name = "uf", length = 255)
    private Integer uf;

    @Column(name = "ibge", length = 255)
    private String ibge;

    @Column(name = "lat_lon", length = 255)
    private String lat_lon;

    @Column(name = "latitude", length = 255)
    private String latitude;

    @Column(name = "longitude", length = 255)
    private String longitude;

    @Column(name = "cod_tom", length = 255)
    private String cod_tom;
}
