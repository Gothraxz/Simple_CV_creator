package gothraxz.Simple.CV.creator.userManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class SimpleCvCreatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleCvCreatorApplication.class, args);
	}
	
	@Bean
	public javax.validation.Validator validator() {
	    final LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
	    factory.setValidationMessageSource(messageSource());
	    return factory;
	}

	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
	    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	    messageSource.setBasename("classpath:/messages");
	    return messageSource;
	}
}
