package demo.restclients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		ApplicationContext context = SpringApplication.run(Application.class, args);
		
		MyRestClient obj = context.getBean("MyRestClient", MyRestClient.class);
		obj.doRestCalls();
	}
}
