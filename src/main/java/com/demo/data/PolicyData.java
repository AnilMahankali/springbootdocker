package com.demo.data;

import org.springframework.stereotype.Service;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Service
@Getter
@Setter
@Data
public class PolicyData {
	
	private String fkDocumentExtractPurposeId;
	
	private String proceedingContentExtractId;
	
	private String proceedingCoreId;
	
	private String proceedingSupplementaryId;
	
	private String proceedingType;
	
	private String proceedingNo;
	
	private String descriptionTx;

	
}
