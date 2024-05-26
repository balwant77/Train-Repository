package com.irtc.train.reservation.repository;

import com.irtc.train.reservation.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepository extends JpaRepository<Train, Long> {
}