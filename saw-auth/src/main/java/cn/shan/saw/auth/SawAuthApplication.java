package cn.shan.saw.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@ComponentScan("cn.shan.saw.auth")
@EnableDiscoveryClient
public class SawAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(SawAuthApplication.class, args);
	}
}
