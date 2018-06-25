package tmelo.recipeproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidParametersException extends RuntimeException {

	public InvalidParametersException() {
		super();
	}

	public InvalidParametersException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public InvalidParametersException(final String message) {
		super(message);
	}

	
	
}
