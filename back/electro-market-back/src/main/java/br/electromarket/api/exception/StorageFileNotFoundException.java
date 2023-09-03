package br.electromarket.api.exception;

/**
 * Copied from: <a href="https://spring.io/guides/gs/uploading-files">spring.io</a>
 */
public class StorageFileNotFoundException extends StorageException {

	public StorageFileNotFoundException(String message) {
		super(message);
	}

	public StorageFileNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
