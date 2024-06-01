package com.anderson.secomp_backend_help_RS.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Address {
    private Integer id;
    private String road;
    private String number;
    private String neighborhood;
    private Integer collectPointId;
    
}
