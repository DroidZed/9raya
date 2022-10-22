package utils;

import javax.ws.rs.core.GenericEntity;

import dto.ResponseDTO;

public class Consts {

	public static final GenericEntity<ResponseDTO> NOT_FOUND_ENTITY = new GenericEntity<ResponseDTO>(
			new ResponseDTO("NOT FOUND !")) {
	};
	
	public static final GenericEntity<ResponseDTO> FOUND_ENTITY = new GenericEntity<ResponseDTO>(
			new ResponseDTO("FOUND !")) {
	};

	public static final GenericEntity<ResponseDTO> OK_ENTITY = new GenericEntity<ResponseDTO>(
			new ResponseDTO("SUCCESS !")) {
	};

}
