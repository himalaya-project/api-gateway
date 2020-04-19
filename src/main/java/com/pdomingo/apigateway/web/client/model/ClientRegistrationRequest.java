package com.pdomingo.apigateway.web.client.model;

import lombok.Data;

@Data
public class ClientRegistrationRequest {
	String alias;
	String name;
	String surname1;
	String surname2;
	String email;
	String phoneNumber;
	AddressDTO shippingAddress;
	String dateOfBirth;

	@Data
	public static class AddressDTO {
		String street;
		String streetNumber;
		String city;
		String postalCode;
		String country;
	}
}
