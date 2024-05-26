package com.irtc.train.reservation.Payload;

import lombok.Data;

@Data
public class SearchResultDto {
    private String trainName;
    private String fromStation;
    private String toStation;
}
