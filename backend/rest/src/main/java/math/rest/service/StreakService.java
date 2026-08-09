package math.rest.service;

import math.rest.dto.StreakDTO;
import math.rest.entity.Streak;

import java.util.List;

public interface StreakService {

    List<Streak> findAll();

    StreakDTO findById(Long id);

    StreakDTO findByUserAndStreakDef(String username, Long streak_id);

    StreakDTO create(StreakDTO form);

    StreakDTO update(StreakDTO form);

    void delete(Long id);

}