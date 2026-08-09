package math.rest.service;

import math.rest.entity.StreakDef;

import java.util.List;

public interface StreakDefService {

    List<StreakDef> findAll();

    StreakDef findById(Long id);

    List<StreakDef> findByName(String name);

    StreakDef create(StreakDef form);

    StreakDef update(StreakDef form);

    void delete(Long id);

}