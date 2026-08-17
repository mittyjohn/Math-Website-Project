package math.rest.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resource) {
        super(resource + "` not found.");
    }
    public ResourceNotFoundException(String resource, String id) {
        super(resource + " with id `" + id + "` not found.");
    }
    public ResourceNotFoundException(String resource, Long id) {
        super(resource + " `" + id + "` not found.");
    }
}
