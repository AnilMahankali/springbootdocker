package com.demo.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

@Service
public class ProceedingContentExtractService {

	private static final String NO_DATA_FOUND = "no.data.found";
	
	@Autowired
	private PcdngContentExtractRepository pcdngContentExtractRepository;
	
	@Autowired
	private StndDocumentExtrctPurpsRepository stnDcumentExtrctPurpsRepository;
	
	@Autowired
	private PTABBusinessUtils ptabBusinessUtils;
	
	//@Transactional
	public List<ProceedingContentExtract> getProceedingContentExtract(String proceedingCoreId, String proceedingSupplementaryId){
		notFoundIfNull(proceedingCoreId, NO_DATA_FOUND);
		List<ProceedingContentExtract> proceedingContentExtractEntities = new ArrayList<ProceedingContentExtract>();
		List<PcdngContentExtractEntity>  pcdngContentExtractEntities = pcdngContentExtractRepository
				.findAllByProceedingCoreIdAndProceedingSupplementaryId(proceedingCoreId,
				new BigDecimal(proceedingSupplementaryId));
		for(PcdngContentExtractEntity pcdngContentExtractEntity : pcdngContentExtractEntities) {
			ProceedingContentExtract proceedingContentExtract = new ProceedingContentExtract();
			proceedingContentExtract.setFkDocumentExtractPurposeId(pcdngContentExtractEntity.getFkDocumentExtractPurposeId());
			proceedingContentExtract.setProceedingContentExtractId(pcdngContentExtractEntity.getProceedingContentExtractId());
			proceedingContentExtract.setProceedingCoreId(pcdngContentExtractEntity.getProceedingCoreId());
			proceedingContentExtract.setProceedingSupplementaryId(pcdngContentExtractEntity.getProceedingSupplementaryId());
			proceedingContentExtract.setProceedingType(pcdngContentExtractEntity.getProceedingType());
			proceedingContentExtract.setProceedingNo(pcdngContentExtractEntity.getProceedingNo());
			proceedingContentExtract.setDescriptionTx(pcdngContentExtractEntity.getDescriptionTx());
		
			ObjectMapper mapper = new ObjectMapper();
			ObjectReader reader = mapper.reader();
			try {
				JsonNode node = reader.readTree(pcdngContentExtractEntity.getExtractedContent());
				proceedingContentExtract.setExtractedContent(node);
			} catch(JsonProcessingException e) {
					
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Audit audit = new Audit();
		}
		
		return new ArrayList<ProceedingContentExtract>();
		
	}

	private void notFoundIfNull(String proceedingCoreId, String noDataFound) {
		// TODO Auto-generated method stub
		
	}
}
