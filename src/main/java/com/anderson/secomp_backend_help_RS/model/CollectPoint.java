package com.anderson.secomp_backend_help_RS.model;
import java.time.LocalTime;
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
@Table(name = "collect_point")
public class CollectPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(unique = true)
    private String name;

    @NotNull
    @Column(name = "start_time")
    private String startTime;

    @NotNull
    @Column(name = "finish_time")
    private String finishTime;

    @NotNull
    @Column(name = "open_donation")
    private boolean openDonation;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
