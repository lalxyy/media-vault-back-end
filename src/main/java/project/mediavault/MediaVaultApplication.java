package project.mediavault;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

@SpringBootApplication
public class MediaVaultApplication {

    public static void main(String[] args) {
		SpringApplication.run(MediaVaultApplication.class, args);
	}

	@Bean
	public DocumentBuilderFactory documentBuilderFactory() {
    	return DocumentBuilderFactory.newInstance();
	}

	@Bean
	public DocumentBuilder documentBuilder() throws ParserConfigurationException {
    	return documentBuilderFactory().newDocumentBuilder();
	}

}
