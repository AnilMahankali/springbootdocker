package com.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pcdng-content-extract" )
public class ProceedingContentExtractController {
	
	
	@Autowired
	ProceedingContentExtractService proceedingContextExtractService;
	
//	public ProceedingContentExtractController(ProceedingContentExtractService proceedingContentExtractService) {
//		this.proceedingContextExtractService = proceedingContentExtractService;
//	}

	@GetMapping
	public List<ProceedingContentExtract> getProceedingContentExtract(@Valid final String proceedingCoreId,
			@Valid final String proceedingSupplementaryId){
		
		return proceedingContextExtractService.getProceedingContentExtract(proceedingCoreId, proceedingSupplementaryId);
		
	}
	
	@PostMapping
	public void createProceedingContentExtract(
			@Valid @RequestBody final ProceedingContentExtract proceedingContentExtract) {
		//proceedingContentExtractService.cre
		
	}
	
}
