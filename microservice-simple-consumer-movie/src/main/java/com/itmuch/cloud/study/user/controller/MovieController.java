package com.itmuch.cloud.study.user.controller;

import com.itmuch.cloud.study.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author caster
 */
@RequestMapping("/movies")
@RestController
public class MovieController {
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/users/{id}")
	public User findById(@PathVariable Long id) {
		// 這里用到了RestTemplate的占位符能力
		User user = this.restTemplate.getForObject("http://localhost:8000/users/{id}", User.class, id);
		// ...電影微服務的業務...
		return user;
	}
}
