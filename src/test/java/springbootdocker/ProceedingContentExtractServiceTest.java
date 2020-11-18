package springbootdocker;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.demo.controller.PcdngContentExtractEntity;
import com.demo.controller.PcdngContentExtractRepository;
import com.demo.controller.ProceedingContentExtract;
import com.demo.controller.ProceedingContentExtractService;
import com.demo.controller.StndDocumentExtrctPurpsRepository;

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
