package io.swagger.model;

import io.swagger.model.Soolution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoolutionRepository extends JpaRepository<Soolution, String> {

}
