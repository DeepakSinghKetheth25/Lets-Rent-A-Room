package com.roomrental.customers.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.roomrental.customers.model.ValidateResponse;


@FeignClient(name = "Auth-Client", url = "${auth-client}")
public interface AuthorizationClient {

	@PostMapping("/validate")
	public ValidateResponse validate(@RequestHeader("Authorization") String header);
}
