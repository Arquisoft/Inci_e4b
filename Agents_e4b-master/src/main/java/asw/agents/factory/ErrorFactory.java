package asw.agents.factory;

import asw.agents.webService.responses.errors.ErrorResponse;
import asw.agents.webService.responses.errors.IncorrectPasswordErrorResponse;
import asw.agents.webService.responses.errors.PasswordDoNotMatchErrorResponse;
import asw.agents.webService.responses.errors.RequiredEmailErrorResponse;
import asw.agents.webService.responses.errors.RequiredKindResponse;
import asw.agents.webService.responses.errors.RequiredPasswordErrorResponse;
import asw.agents.webService.responses.errors.RequiredUserIDResponse;
import asw.agents.webService.responses.errors.SameEmailErrorResponse;
import asw.agents.webService.responses.errors.UnknownErrorResponse;
import asw.agents.webService.responses.errors.UserNotFoundResponse;
import asw.agents.webService.responses.errors.WrongEmailStyleErrorResponse;

//Creacion de los distintos tipos de error.
public class ErrorFactory {

	public static enum Errors {
		INCORRECT_PASSWORD,
		REQUIRED_EMAIL,
		REQUIRED_PASSWORD,
		USER_NOT_FOUND,
		WRONG_EMAIL_STYLE,
		INCORRECT_PASSWORD_DO_NOT_MATCH,
		SAME_EMAIL,
		REQUIRED_USERID,
		REQUIRED_KIND
	}

	// Generar Constructor privado no queremos que se pueda tener varias
	// instancias de la clase.
	private ErrorFactory() { }

	public static ErrorResponse getError(Errors error) {
		
		switch (error) {
			
			case INCORRECT_PASSWORD:
				return new IncorrectPasswordErrorResponse();
				
			case REQUIRED_EMAIL:
				return new RequiredEmailErrorResponse();
				
			case REQUIRED_PASSWORD:
				return new RequiredPasswordErrorResponse();
				
			case USER_NOT_FOUND:
				return new UserNotFoundResponse();
				
			case WRONG_EMAIL_STYLE:
				return new WrongEmailStyleErrorResponse();
				
			case INCORRECT_PASSWORD_DO_NOT_MATCH:
				return new PasswordDoNotMatchErrorResponse();
				
			case SAME_EMAIL:
				return new SameEmailErrorResponse();
				
			case REQUIRED_USERID:
				return new RequiredUserIDResponse();
				
			case REQUIRED_KIND:
				return new RequiredKindResponse();
				
			default:// en caso de no conocer el error.
				return new UnknownErrorResponse();
		}
	}

}
