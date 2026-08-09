package math.rest.service;

import lombok.AllArgsConstructor;
import math.rest.dto.StreakDTO;
import math.rest.entity.Streak;
import math.rest.entity.StreakDef;
import math.rest.entity.User;
import math.rest.exception.ResourceNotFoundException;
import math.rest.mapper.StreakMapper;
import math.rest.repository.StreakRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StreakServiceImpl implements StreakService {

    private final StreakRepository streakRepository;
    private final UserService userService;
    private final StreakDefService streakDefService;
    @Autowired
    private final StreakMapper mapper;

    @Override
    public List<Streak> findAll() {
        return streakRepository.findAll();
    }

    @Override
    public StreakDTO findById(Long id) {
        Streak streak = streakRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Streak", id));
        return mapper.toDTO(streak);
    }

    @Override
    public StreakDTO findByUserAndStreakDef(String username, Long streak_id) {
        User user = userService.findByUsername(username);
        StreakDef streakDef = streakDefService.findById(streak_id);
        Streak streak = streakRepository
            .findByUserAndStreakDef(user, streakDef)
            .orElseThrow(() -> new ResourceNotFoundException("Streak", ""));
        return mapper.toDTO(streak);
    }

    @Override
    public StreakDTO create(StreakDTO form) {
        User user = userService.findByUsername(form.getUsername());
        StreakDef streakDef = streakDefService.findById(form.getStreak_id());
        Streak streak = new Streak();
        streak.setUser(user);
        streak.setStreakDef(streakDef);
        streak.setCount(form.getCount());
//        Streak streak = mapper.toEntity(form);
        Streak saved = streakRepository.save(streak);
        return mapper.toDTO(saved);
    }

    @Override
    public StreakDTO update(StreakDTO form) {
        Streak streak = streakRepository
            .findById(form.getId())
            .orElseThrow(() -> new ResourceNotFoundException("Streak", form.getId()));
        streak.setCount(form.getCount());
        streakRepository.save(streak);
        return form;
    }

    @Override
    public void delete(Long id) {
        Streak entity = streakRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Streak", id));
        streakRepository.delete(entity);

    }
}
