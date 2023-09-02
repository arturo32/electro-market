package br.electromarket.base.exception;

public class PrerequisitesNotMetException extends BusinessException {

	private static final long serialVersionUID = 4986033354705167054L;

	public PrerequisitesNotMetException() {
	}

	public PrerequisitesNotMetException(String message) {
		super(message);
	}
}
