package java16.arbnbonmyself.exception;

import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
public record ExceptionResponse(
      String message,
      HttpStatus httpStatus
) {
}
