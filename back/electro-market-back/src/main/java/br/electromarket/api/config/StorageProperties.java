package br.electromarket.api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Copied from: <a href="https://spring.io/guides/gs/uploading-files">spring.io</a>
 */
@ConfigurationProperties("storage")
public class StorageProperties {

	/**
	 * Folder location for storing files
	 */
	private String location = "upload-dir";

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
