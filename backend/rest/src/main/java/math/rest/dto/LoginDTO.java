package math.rest.dto;

public record LoginDTO(String username, String password) {
    public LoginDTO {
        if (username == null || username.length() < 3) {
            throw new IllegalArgumentException("Username must be at least 3 characters long.");
        }
        if (password == null || password.length() < 5) {
            throw new IllegalArgumentException("Password must be at least 5 characters long.");
        }
    }
}