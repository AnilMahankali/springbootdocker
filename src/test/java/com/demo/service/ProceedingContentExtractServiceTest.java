package com.demo.service;

import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.demo.data.PcdngContentExtractEntity;
import com.demo.repo.PcdngContentExtractRepository;
import com.demo.repo.StndDocumentExtrctPurpsRepository;
import com.demo.service.ProceedingContentExtractService;

@RunWith(MockitoJUnitRunner.class)
public class ProceedingContentExtractServiceTest {

	@Mock
	private StndDocumentExtrctPurpsRepository stndDocumentExtrctPurpsRepository;
	
	@Mock
	private PcdngContentExtractRepository pcdngContentExtractRepository;
	
	@InjectMocks
	private ProceedingContentExtractService proceedingContentExtractService;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void test() {
		String proceedingCoreId = "test";
		String proceedingSupplementaryId = "100000";
		List<PcdngContentExtractEntity> list = new ArrayList<PcdngContentExtractEntity>();
		PcdngContentExtractEntity pcdngContentExtractEntity = new PcdngContentExtractEntity();
		pcdngContentExtractEntity.setFkDocumentExtractPurposeId("test");
		pcdngContentExtractEntity.setProceedingContentExtractId("test");
		pcdngContentExtractEntity.setProceedingCoreId("test");
		pcdngContentExtractEntity.setProceedingSupplementaryId("test");
		pcdngContentExtractEntity.setProceedingType("test");
		pcdngContentExtractEntity.setProceedingNo("test");
		pcdngContentExtractEntity.setDescriptionTx("test");
		list.add(pcdngContentExtractEntity);
	
		when(pcdngContentExtractRepository
				.findAllByProceedingCoreIdAndProceedingSupplementaryId(proceedingCoreId,
						new BigDecimal(proceedingSupplementaryId)))
		.thenReturn(list);
		proceedingContentExtractService.getProceedingContentExtract(proceedingCoreId, proceedingSupplementaryId);
	}
}
