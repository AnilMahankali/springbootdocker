package com.demo.data;

import com.fasterxml.jackson.core.JsonParser;

public final class PcdngContentExtractEntity {


	private String fkDocumentExtractPurposeId;
	
	private String proceedingContentExtractId;
	
	private String proceedingCoreId;
	
	private String proceedingSupplementaryId;
	
	private String proceedingType;
	
	private String proceedingNo;
	
	private String descriptionTx;

	public String getFkDocumentExtractPurposeId() {
		return fkDocumentExtractPurposeId;
	}

	public void setFkDocumentExtractPurposeId(String fkDocumentExtractPurposeId) {
		this.fkDocumentExtractPurposeId = fkDocumentExtractPurposeId;
	}

	public String getProceedingContentExtractId() {
		return proceedingContentExtractId;
	}

	public void setProceedingContentExtractId(String proceedingContentExtractId) {
		this.proceedingContentExtractId = proceedingContentExtractId;
	}

	public String getProceedingCoreId() {
		return proceedingCoreId;
	}

	public void setProceedingCoreId(String proceedingCoreId) {
		this.proceedingCoreId = proceedingCoreId;
	}

	public String getProceedingSupplementaryId() {
		return proceedingSupplementaryId;
	}

	public void setProceedingSupplementaryId(String proceedingSupplementaryId) {
		this.proceedingSupplementaryId = proceedingSupplementaryId;
	}

	public String getProceedingType() {
		return proceedingType;
	}

	public void setProceedingType(String proceedingType) {
		this.proceedingType = proceedingType;
	}

	public String getProceedingNo() {
		return proceedingNo;
	}

	public void setProceedingNo(String proceedingNo) {
		this.proceedingNo = proceedingNo;
	}

	public String getDescriptionTx() {
		return descriptionTx;
	}

	public void setDescriptionTx(String descriptionTx) {
		this.descriptionTx = descriptionTx;
	}

	public JsonParser getExtractedContent() {
		// TODO Auto-generated method stub
		return null;
	}
}
