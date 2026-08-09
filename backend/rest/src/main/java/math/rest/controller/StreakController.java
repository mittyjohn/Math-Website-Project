package math.rest.controller;

import lombok.AllArgsConstructor;
import math.rest.dto.StreakDTO;
import math.rest.entity.Streak;
import math.rest.service.StreakService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/streaks")
@CrossOrigin(origins = "http://localhost:3000")
public class StreakController {

    private final StreakService streakService;

    @GetMapping("/all")
    public List<Streak> allStreaks() {
        return streakService.findAll();
    }

    @GetMapping("/id/{id}")
    public StreakDTO findStreakById(
        @PathVariable Long id
    ) {
        return streakService.findById(id);
    }

    @GetMapping("/usr/{username}/streakDef/{streak_id}")
    public StreakDTO findStreakByUserAndStreakDef(
        @PathVariable String username,
        @PathVariable Long streak_id
    ) {
        return streakService.findByUserAndStreakDef(username, streak_id);
    }

    @PostMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    StreakDTO create(StreakDTO streak) {
        return streakService.create(streak);
    }

    @PutMapping(value = "/update", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    StreakDTO update(StreakDTO streak) {
        return streakService.update(streak);
    }

    @DeleteMapping("/del/{id}")
    void delete(@PathVariable Long id) {
        streakService.delete(id);
    }

}