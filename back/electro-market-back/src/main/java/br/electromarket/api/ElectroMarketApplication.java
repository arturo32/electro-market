package br.electromarket.api;

import br.electromarket.api.config.StorageProperties;
import br.electromarket.api.service.FileSystemStorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@EnableConfigurationProperties(StorageProperties.class)
@SpringBootApplication
public class ElectroMarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElectroMarketApplication.class, args);
	}

	@Bean
	CommandLineRunner init(FileSystemStorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}

}
