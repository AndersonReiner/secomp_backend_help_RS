package com.anderson.secomp_backend_help_RS.model;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CollectPoint {
    private Integer id;
    private String name;
    private Date startTime;
    private Date finishTime;
    private boolean openDonataion;

}
