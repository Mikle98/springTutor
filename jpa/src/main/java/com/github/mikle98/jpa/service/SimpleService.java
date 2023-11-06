package com.github.mikle98.jpa.service;

import com.github.mikle98.jpa.model.SimpleEntity;
import com.github.mikle98.jpa.repository.SimpleRepository;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SimpleService implements ApplicationRunner {

  private final SimpleRepository simpleRepository;
  private final JdbcOperations jdbcOperations;

  @Autowired
  public SimpleService(
      SimpleRepository simpleRepository,
      JdbcOperations jdbcOperations
  ) {
    this.simpleRepository = simpleRepository;
    this.jdbcOperations = jdbcOperations;
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    SimpleEntity simpleEntity = new SimpleEntity();
    long id = 1L;
    simpleEntity.setId(id);
    simpleEntity.setText("Hi Misha2");
    simpleRepository.save(simpleEntity);

//    Optional<SimpleEntity> byId = simpleRepository.findById(id);
    Optional<String> entity = simpleRepository.findByTextById(id);
    simpleRepository.findByText("Hi Misha2");
    if (entity.isPresent()) {
      log.info("Entity found with id {}, {}", id, entity.get());
    } else {
      log.info("Entity not found with id {}", id);
    }
  }
}
