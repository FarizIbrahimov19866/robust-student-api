package az.edu.ada.model.error;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorResponse {

    private LocalDateTime timestamp;
    private int status;
    private String message;
    private String path;

    private List<String> details;

    public ErrorResponse(LocalDateTime timestamp, int status, String message, String path, List<String> details) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.path = path;
        this.details = details;
    }

    public LocalDateTime getTimestamp() { return timestamp; }
    public int getStatus() { return status; }
    public String getMessage() { return message; }
    public String getPath() { return path; }
    public List<String> getDetails() { return details; }
}
