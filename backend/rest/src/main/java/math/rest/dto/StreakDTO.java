package math.rest.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StreakDTO {
    private Long id;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9]{1,25}$")
    private String username;

    @NotNull
    private Long streak_id;

    @NotNull
    private int count;

}