package br.electromarket.api.exception;

/**
 * Copied from: <a href="https://spring.io/guides/gs/uploading-files">spring.io</a>
 */
public class StorageException extends RuntimeException {

	public StorageException(String message) {
		super(message);
	}

	public StorageException(String message, Throwable cause) {
		super(message, cause);
	}
}
