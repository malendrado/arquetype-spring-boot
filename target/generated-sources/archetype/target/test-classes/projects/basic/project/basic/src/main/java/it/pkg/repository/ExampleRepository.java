package it.pkg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.pkg.entity.ExampleEntity;

@Repository
public interface ExampleRepository extends JpaRepository<ExampleEntity, Integer>{

}
