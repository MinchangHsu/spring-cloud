package com.caster.movie.controller;

import com.caster.movie.config.MovieClient;
import com.caster.movie.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author caster
 */
@RequestMapping("/movies")
@RestController
public class MovieController {

	@Autowired
	private MovieClient movieClient;

	@GetMapping("/users/{id}")
	public Optional<User> findById(@PathVariable Long id) {
		return movieClient.getUserById(id);
	}
}
