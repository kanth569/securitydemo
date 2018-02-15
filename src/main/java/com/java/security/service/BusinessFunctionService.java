package com.java.security.service;

import com.java.security.helper.Response;
import com.java.security.model.User;

public interface BusinessFunctionService {

	public String addUser(User user);

	public User findByUserId(Integer id);

	public User getUserByName(String name);

	public Response deleteById(Integer id);

}
