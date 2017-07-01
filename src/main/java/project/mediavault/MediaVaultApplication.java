package project.mediavault;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
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
//	public static final String BASE_DIR = "C:\\media" + "\\data";

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
				registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "HEAD", "OPTION");
			}
		};
	}

	@Bean
	public WebMvcConfigurer staticResourceConfigurer() {
    	return new WebMvcConfigurerAdapter() {
			@Override
			public void addResourceHandlers(ResourceHandlerRegistry registry) {
				registry.addResourceHandler("/**")
						.addResourceLocations("classpath:/META-INF/resources/")
						.addResourceLocations("classpath:/resources/")
						.addResourceLocations("classpath:/static/")
						.addResourceLocations("classpath:/public/");
				registry.addResourceHandler("/user-data/**")
						.addResourceLocations("file:" + MediaVaultApplication.BASE_DIR + "/data/");
			}
		};
	}

	@Bean
	public ObjectMapper objectMapper() {
    	return new ObjectMapper();
	}

}
