package projPOO01.Exceptions;

public class ExceptionDate extends Exception {

	/**
	 * Cet classe est utilisée par la classe Controles.java elle permet de controler
	 * les dates. Cependant rien n'est explicite pour les différent type d'exception
	 * catché aucun traitement n'est fait dans cette classe elle ne fait que se
	 * referer au constructeur de son parent 
	 */
	private static final long serialVersionUID = 1L;

	public ExceptionDate() {
		// TODO Auto-generated constructor stub
	}

	public ExceptionDate(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public ExceptionDate(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public ExceptionDate(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public ExceptionDate(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

}
