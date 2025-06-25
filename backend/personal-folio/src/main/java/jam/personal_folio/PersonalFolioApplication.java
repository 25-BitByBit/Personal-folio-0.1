package jam.personal_folio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PersonalFolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalFolioApplication.class, args);
	}

}
