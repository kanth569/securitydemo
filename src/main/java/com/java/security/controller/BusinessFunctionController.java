package com.java.security.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.security.dao.repository.UserRepository;
import com.java.security.helper.Response;
import com.java.security.model.User;
import com.java.security.model.UserDetails;
import com.java.security.service.BusinessFunctionService;

import ma.glasnost.orika.MapperFacade;

@Controller
@RequestMapping("/businessfunctions")
public class BusinessFunctionController {

	@Autowired
	private MapperFacade restServiceModelDomainMapperFacade;

	@Resource(name = "businessFunctionService")
	private BusinessFunctionService businessFunctionService;

	@RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public User getUser(@PathVariable Integer id) {
		return businessFunctionService.findByUserId(id);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Response deleteById(@PathVariable Integer id) {
		return businessFunctionService.deleteById(id);
	}

	@RequestMapping(method = RequestMethod.OPTIONS)
	@ResponseBody
	public String ping() {
		return "Hello, I'm up and running";

	}

	@RequestMapping(method = RequestMethod.GET, value = "", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public User getUserByName(@RequestParam("name") String name) {
		return businessFunctionService.getUserByName(name);
	}

	@RequestMapping(method = RequestMethod.POST, value = "", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public String addNewUser(@RequestBody User user) {
		com.java.security.domain.User domain = restServiceModelDomainMapperFacade.map(user,
				com.java.security.domain.User.class);
		businessFunctionService.addUser(user);

		return "Saved";
	}

	// @GetMapping(path="/all")
	// public @ResponseBody Iterable<com.java.security.domain.User> getAllUsers() {
	// // This returns a JSON or XML with the users
	// return userRepository.findAll();
	// }

}
