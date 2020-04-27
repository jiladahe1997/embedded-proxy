package com.jiladahe1997.embeddedproxy;

import com.jiladahe1997.embeddedproxy.scheduling.JobKeil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.io.IOException;

@SpringBootApplication
public class EmbeddedproxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmbeddedproxyApplication.class, args);
	}

}
