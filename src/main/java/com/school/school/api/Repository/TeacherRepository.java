package com.school.school.api.Repository;

import com.school.school.api.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    @Query("SELECT s FROM Teacher s where s.id= :id")
    Optional<Teacher> findTeachersById(@Param("id")Long id);
}
