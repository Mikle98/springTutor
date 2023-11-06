package com.github.mikle98.jpa.repository;

import com.github.mikle98.jpa.model.SimpleEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SimpleRepository extends JpaRepository<SimpleEntity, Long> {

  @Query("select s.text from SimpleEntity s where s.id = 1")
  Optional<String> findByTextById(Long id);

  Optional<SimpleEntity> findByText(String text);
}
