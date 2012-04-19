package sv.com.cormaria.servicios.facades.security;

public class ExceptionHelper {
	public static Throwable getRootCause(Throwable t){
	    Throwable localt = t;
		while (localt.getCause()!=null){
			localt = localt.getCause();
		}
		return localt;
	}
}