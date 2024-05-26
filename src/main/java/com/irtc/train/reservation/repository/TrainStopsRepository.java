package com.irtc.train.reservation.repository;

import com.irtc.train.reservation.Payload.SearchResultDto;
import com.irtc.train.reservation.entity.Train;
import com.irtc.train.reservation.entity.TrainStops;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TrainStopsRepository extends JpaRepository<TrainStops, Long> {
    @Query("SELECT DISTINCT ts.train FROM TrainStops ts " +
            "JOIN ts.station startStation " +
            "JOIN ts.train t " +
            "WHERE startStation.stationName = :fromStation " +
            "AND ts.departureTime >= :departureTime " +
            "AND t.id IN " +
            "(SELECT ts2.train.id FROM TrainStops ts2 " +
            "JOIN ts2.station endStation " +
            "WHERE endStation.stationName = :toStation)")
    List<Train> findTrainsByStationsAndDepartureTime(
            @Param("fromStation") String fromStation,
            @Param("toStation") String toStation,
            @Param("departureTime") String departureTime
    );


}
