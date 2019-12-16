package com.college.student;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.college.student.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class StudentProducerApplicationTest {

	@Value("${endpoint.prefix}")
	private String endPointPrefix;

	@Value("${endpoint.suffix}")
	private String endPointSuffix;

	@LocalServerPort
	int randomServerPort;

	RestTemplate restTemplate;
	
	@Before
	public void init() {
		restTemplate = new RestTemplate();
	}

	@Test
	public void testGetStudents() {
		final String url = endPointPrefix + randomServerPort + endPointSuffix + "/students";
		@SuppressWarnings("rawtypes")
		ResponseEntity<List> employeesEntity = restTemplate.getForEntity(url, List.class);
		Assert.assertEquals(200, employeesEntity.getStatusCodeValue());
	}

	@Test
	public void testGetStudent() {
		final String url = endPointPrefix + randomServerPort + endPointSuffix + "/students/1";
		ResponseEntity<Student> employeesEntity = restTemplate.getForEntity(url, Student.class);
		String expected = "Rajesh";
		Assert.assertEquals(expected, employeesEntity.getBody().getName());
	}
	
}
