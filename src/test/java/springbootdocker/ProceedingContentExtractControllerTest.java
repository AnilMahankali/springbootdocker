package springbootdocker;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;

import com.demo.controller.ProceedingContentExtractController;
import com.demo.controller.ProceedingContentExtractService;

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
