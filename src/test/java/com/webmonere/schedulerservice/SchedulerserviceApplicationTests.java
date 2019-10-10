package com.webmonere.schedulerservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SchedulerserviceApplicationTests {

	@Value("${http-stat-service-url}")
	private String HTTP_STAT_SERVICE_URL;
	@Test
	public void contextLoads() {
		System.out.println(HTTP_STAT_SERVICE_URL);
	}

}
