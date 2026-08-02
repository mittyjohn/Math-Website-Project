package math.rest.dto;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9]{1,25}$")
    private String username;

    @Pattern(regexp = "^[a-zA-Z0-9@$#!&]{1,250}$")
    private String password;

    @NotNull
    @Email
    private String email;

    @NotNull
    private int level = 0;

    @NotNull
    private int streak = 0;

}