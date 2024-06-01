package com.anderson.secomp_backend_help_RS.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ReceivingDonation {
    private Integer id;
    private String description;
    private String itemsType;
    private Integer collectPoint;

}
