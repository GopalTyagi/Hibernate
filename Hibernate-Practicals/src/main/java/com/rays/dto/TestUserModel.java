package com.rays.dto;

import java.util.Date;

import com.rays.model.UserModel;

public class TestUserModel {
	public static void main(String[] args) {
		testAdd();
	}

	private static void testAdd() {
		UserDTO dto = new UserDTO();
		dto.setId(2);
		dto.setFirstName("Gopal");
		dto.setLastName("tyagi");
		dto.setLoginId("gopal/gmail.com");
		dto.setPassword("1234");
		dto.setAddress("Sehore");
		dto.setDob(new Date());

		UserModel model = new UserModel();
		model.add(dto);
		System.out.println("Added");
	}

}
