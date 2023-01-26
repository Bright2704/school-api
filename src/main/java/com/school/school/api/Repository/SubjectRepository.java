package com.school.school.api.Repository;

import com.school.school.api.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

    @Query("SELECT e FROM Subject e where e.id= :id")
    Optional<Subject> findSubjectById(@Param("id") Long id);

}
