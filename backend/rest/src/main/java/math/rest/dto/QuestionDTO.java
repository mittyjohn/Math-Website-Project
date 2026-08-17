package math.rest.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import math.rest.entity.QuestionDifficulty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTO {

    private Long id;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9]{1,50}$")
    private String topic;

    @NotNull
    private QuestionDifficulty difficulty;

    @NotNull
    private String description;

    private String answer;

}