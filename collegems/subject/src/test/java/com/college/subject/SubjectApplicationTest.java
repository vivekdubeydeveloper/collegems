package com.college.subject;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SubjectApplicationTest {

	@LocalServerPort
	int randomServerPort;
	
	@Test
	public void testgetSubjectsSuccess() {
		 RestTemplate restTemplate = new RestTemplate();
	     final String url = "http://localhost:"+randomServerPort+"/subject/api/v1/subjects";
	     ResponseEntity<List> employeesEntity= restTemplate.getForEntity(url, List.class);
	     
	     Assert.assertEquals(200, employeesEntity.getStatusCodeValue());
	}

}
