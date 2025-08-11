package com.spring.scheduledevelop.domain.schedule.repository;

import com.spring.scheduledevelop.application.schedule.dto.request.SchedulePageRequest;
import com.spring.scheduledevelop.domain.schedule.entity.Schedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    Optional<Schedule> findScheduleById(Long id);

    Optional<Schedule> findAccountScheduleByAccountIdAndId(Long accountId, Long scheduleId);

    @Query(value = "SELECT s.* FROM schedule s LEFT JOIN comment c ON s.id = c.schedule_id WHERE (:name IS NULL OR name LIKE %:name%) GROUP BY s.id;", nativeQuery = true)
    List<Schedule> findAllPageScheduleOrderByUpdatedDesc(String name);

    @Query(value = "SELECT COUNT(c.schedule_id) FROM schedule s LEFT JOIN comment c ON s.id = c.schedule_id WHERE s.id = :id;", nativeQuery = true)
    Long countCommentById(@Param("id") Long id);

    @Query("SELECT COUNT(s) FROM Schedule s")
    Long countAllSchedules();
}
