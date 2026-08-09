package math.rest.service;

import lombok.AllArgsConstructor;
import math.rest.entity.StreakDef;
import math.rest.exception.ResourceNotFoundException;
import math.rest.repository.StreakDefRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StreakDefServiceImpl implements StreakDefService {

    private final StreakDefRepository streakDefRepository;

    @Override
    public List<StreakDef> findAll() {
        return streakDefRepository.findAll();
    }

    @Override
    public StreakDef findById(Long id) {
        return streakDefRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Streak Definition", id));
    }

    @Override
    public List<StreakDef> findByName(String name) {
        return streakDefRepository
            .findByName(name);
    }

    @Override
    public StreakDef create(StreakDef form) {
        return streakDefRepository.save(form);
    }

    @Override
    public StreakDef update(StreakDef form) {
        return streakDefRepository.save(form);
    }

    @Override
    public void delete(Long id) {
        StreakDef entity = streakDefRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Streak Definition", id));
        streakDefRepository.delete(entity);

    }
}
