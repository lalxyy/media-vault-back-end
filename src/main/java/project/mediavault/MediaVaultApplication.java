package project.mediavault;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.xpath.XPathFactory;

@SpringBootApplication
public class MediaVaultApplication {

	public static final String BASE_DIR = System.getProperty("user.dir") + "/data";

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

	@Bean
	public TransformerFactory transformerFactory() {
    	return TransformerFactory.newInstance();
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
    	return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**");
			}
		};
	}

}
