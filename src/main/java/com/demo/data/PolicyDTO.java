package com.demo.data;

import org.springframework.stereotype.Service;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Service
@Data
@Getter
@Setter
public class PolicyDTO {

	private PolicyData RequestData;
	
}
