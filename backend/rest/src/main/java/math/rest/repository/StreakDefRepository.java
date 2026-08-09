package math.rest.repository;

import math.rest.entity.StreakDef;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StreakDefRepository extends JpaRepository<StreakDef, Long> {

    List<StreakDef> findByName(String name);

}
