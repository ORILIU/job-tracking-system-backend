package com.jobtracking.job_tracking_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.jobtracking.job_tracking_system.model")
@EnableJpaRepositories("com.jobtracking.job_tracking_system.repository")
public class JobTrackingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobTrackingSystemApplication.class, args);
	}

}
