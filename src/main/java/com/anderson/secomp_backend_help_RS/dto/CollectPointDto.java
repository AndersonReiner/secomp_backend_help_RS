package com.anderson.secomp_backend_help_RS.dto;

public record CollectPointDto(String name,
                              String startTime,
                              String finishTime,
                              boolean openDonation,
                              Integer user_id) {
}
