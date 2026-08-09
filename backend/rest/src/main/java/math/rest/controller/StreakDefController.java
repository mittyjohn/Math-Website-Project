package math.rest.controller;

import lombok.AllArgsConstructor;
import math.rest.entity.StreakDef;
import math.rest.service.StreakDefService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/streakDefs")
@CrossOrigin(origins = "http://localhost:3000")
public class StreakDefController {

    private final StreakDefService streakDefService;

    @GetMapping("/all")
    public List<StreakDef> allStreakDefs() {
        return streakDefService.findAll();
    }

    @GetMapping("/id/{id}")
    public StreakDef findStreakDefById(
        @PathVariable Long id
    ) {
        return streakDefService.findById(id);
    }

    @PostMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    StreakDef create(StreakDef streakDef) {
        return streakDefService.create(streakDef);
    }

    @PutMapping(value = "/update", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    StreakDef update(StreakDef streakDef) {
        return streakDefService.update(streakDef);
    }

    @DeleteMapping("/del/{id}")
    void delete(@PathVariable Long id) {
        streakDefService.delete(id);
    }

}