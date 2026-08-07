package math.rest.exception;

public class UsernameNotFoundException extends ResourceNotFoundException {
    public UsernameNotFoundException(String username) {
        super("Username", username);
    }
}
