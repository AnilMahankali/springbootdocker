package com.demo.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PcdngContentExtractRepository {

	public List<PcdngContentExtractEntity> findAllByProceedingCoreIdAndProceedingSupplementaryId(String x, BigDecimal proceedingCoreId) {
		// TODO Auto-generated method stub
		return new ArrayList<PcdngContentExtractEntity>();
	}

}
