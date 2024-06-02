package com.anderson.secomp_backend_help_RS.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String road;

    @NotNull
    private String number;

    @NotNull
    private String neighborhood;

    @ManyToOne
    @JoinColumn(name = "collect_point_id", referencedColumnName = "id")
    private CollectPoint collectPoint;
    
}
