package com.spring.scheduledevelop.domain.schedule.repository;

import com.spring.scheduledevelop.domain.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    Optional<Schedule> findScheduleById(Long id);

    @Query(value = "SELECT * FROM schedule WHERE (:name IS NULL OR name LIKE %:name%);", nativeQuery = true)
    List<Schedule> findAllScheduleOrderByUpdatedAtDesc(String name);
}
