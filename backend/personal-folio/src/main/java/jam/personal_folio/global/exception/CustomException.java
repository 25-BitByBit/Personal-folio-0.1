package jam.personal_folio.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomException extends RuntimeException {

    private final ExceptionStatus status;

    public CustomException(ExceptionStatus status) {
        super(status.getMessage());
        this.status = status;
    }

    public int getCode() {
        return status.getCode();
    }

    public HttpStatus getHttpStatus() {
        return status.getHttpStatus();
    }
}
