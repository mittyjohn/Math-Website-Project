package math.rest.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resource, String id) {
        String message = resource + " with id `" + id + "` not found.";
        if (id.isBlank()) {
            message = resource + "` not found.";
        }
        super(message);
    }
    public ResourceNotFoundException(String resource, Long id) {
        super(resource + " `" + id + "` not found.");
    }
}
