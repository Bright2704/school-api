package com.school.school.api.Repository;

import com.school.school.api.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {
    @Query("SELECT s FROM School s where s.id= :id")
    Optional<School> findSchoolsById(@Param("id") Long id);
}
