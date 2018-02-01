package com.gastos.Gastos.controllers;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gastos.Gastos.model.User;
import com.gastos.Gastos.service.UserService;
import com.gastos.Gastos.util.RestResponse;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	protected UserService userService;	
	protected ObjectMapper mapper;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public RestResponse saveOrUpdate(@RequestBody String userJson) throws JsonParseException, JsonMappingException, IOException{
		
		this.mapper = new ObjectMapper();
		User user = this.mapper.readValue(userJson, User.class);
		
		if(!this.validate(user)){
			return new RestResponse(HttpStatus.BAD_REQUEST.value(),"Los campos obligatorios no se han informado");
		}
		
		this.userService.save(user);
		
		return new RestResponse(HttpStatus.OK.value(),"Operación realizada con éxito");
	}
	
	private boolean validate(User user){
		boolean isValid = true;
		
		if(StringUtils.trimToNull(user.getNombre()) == null){
			isValid = false;
		}
		
		return isValid;
	}
}
