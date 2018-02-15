package com.java.security.mapper;

import com.java.security.domain.User;

import ma.glasnost.orika.MapperFactory;
/**
 * 
 * @author Anil
 *
 */
public class SecurityMapper {

	private MapperFactory restServiceModelDomainFactory = null;
	 
	public SecurityMapper(MapperFactory restServiceModelDomainFactory) {

		this.restServiceModelDomainFactory = restServiceModelDomainFactory;
		mapUserModelDomainMapper();
	}

	private void mapUserModelDomainMapper() {

		restServiceModelDomainFactory.classMap(User.class, com.java.security.domain.User.class).byDefault();
	}

}
