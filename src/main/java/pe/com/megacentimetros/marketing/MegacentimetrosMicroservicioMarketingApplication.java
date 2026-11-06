package pe.com.megacentimetros.marketing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MegacentimetrosMicroservicioMarketingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MegacentimetrosMicroservicioMarketingApplication.class, args);
	}

}
