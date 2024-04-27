package tasks.springCoreHW;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SpringCoreHwApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCoreHwApplication.class, args);

		log.info("Example log");

	}

}
