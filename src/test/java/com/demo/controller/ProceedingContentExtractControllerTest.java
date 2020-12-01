package com.demo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.demo.service.ProceedingContentExtractService;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProceedingContentExtractControllerTest {

	@Mock
	private ProceedingContentExtractService proceedingContentExtractService;
	
	@Test
	public void testGetProceedingContentExtract() {
		String proceedingCoreId = "test";
		String proceedingSupplementaryId = "test2";
		//new ProceedingContentExtractController(proceedingContentExtractService).getProceedingContentExtract(proceedingCoreId, proceedingSupplementaryId);
		verify(proceedingContentExtractService).getProceedingContentExtract(proceedingCoreId, proceedingSupplementaryId);
	}
}
