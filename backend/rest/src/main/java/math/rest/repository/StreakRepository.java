package math.rest.repository;

import math.rest.entity.Streak;
import math.rest.entity.StreakDef;
import math.rest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StreakRepository extends JpaRepository<Streak, Long> {
    Optional<Streak> findByUserAndStreakDef(User user, StreakDef streakDef);
}
