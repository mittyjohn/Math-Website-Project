package math.rest.exception;

public class UsernameNotFound extends ResourceNotFoundException {
    public UsernameNotFound(String username) {
        super("Username", username);
    }
}
