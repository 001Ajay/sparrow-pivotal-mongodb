package org.dev;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SparrowRestMongoDbApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(SparrowRestMongoDbApplication.class)
        	.initializers(new SpringApplicationContextInitializer())
        	.application()
        	.run(args);
	}
}