package com.caster.movie.config;

import com.caster.movie.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Author: Minchang Hsu (Caster)
 * Date: 2022/4/24
 * Comment:
 */
@Configuration
@EnableFeignClients
@EnableDiscoveryClient
public class MovieClient {
	@Autowired
	private TheClient theClient;

	@FeignClient(name = "provider-user")
	interface TheClient {

		@GetMapping(path = "/users/{id}")
		@ResponseBody
		Optional<User> getUserById(@PathVariable Long id);
	}
	public Optional<User> getUserById(Long id) {
		return theClient.getUserById(id);
	}
}
