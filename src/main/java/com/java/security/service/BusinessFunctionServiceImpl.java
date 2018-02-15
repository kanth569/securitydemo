package com.java.security.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.security.dao.repository.UserRepository;
import com.java.security.helper.Response;
import com.java.security.model.User;

import ma.glasnost.orika.MapperFacade;

@Service(value = "businessFunctionService")
public class BusinessFunctionServiceImpl implements BusinessFunctionService {

	@Autowired
	private UserRepository userRepository;

	@Resource(name = "restServiceModelDomainMapperFacade")
	private MapperFacade restServiceModelDomainMapperFacade;

	@Override
	public String addUser(User user) {
		com.java.security.domain.User domain = restServiceModelDomainMapperFacade.map(user,
				com.java.security.domain.User.class);
		userRepository.saveAndFlush(domain);
		return "saved";
	}

	@Override
	public User findByUserId(Integer id) {
		
		com.java.security.domain.User domain = userRepository.findOne(id);
		if(domain==null) {
			throw new SecurityException("Entity Not Found");
		}
		User model = restServiceModelDomainMapperFacade.map(domain, User.class);
		return model;
	}

	@Override
	public User getUserByName(String name) {
		com.java.security.domain.User domain = userRepository.findByLastname(name);
		User model = restServiceModelDomainMapperFacade.map(domain, User.class);
		return model;
	}

	@Override
	public Response deleteById(Integer id) {
		com.java.security.domain.User domain = userRepository.findOne(id);
		userRepository.delete(domain);
		Response response = new Response();
		response.setMessageCode("4000");
		response.setMessage("Deleted " + id + " Successful");
		return response;
	}

}
