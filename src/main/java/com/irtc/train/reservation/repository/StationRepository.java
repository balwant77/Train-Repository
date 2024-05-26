package com.irtc.train.reservation.repository;

import com.irtc.train.reservation.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station, Long> {
}