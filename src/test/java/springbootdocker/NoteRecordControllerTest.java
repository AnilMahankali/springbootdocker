package springbootdocker;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.controller.Application;
import com.demo.controller.NoteRecordController;
import com.demo.controller.PTABBusinessUtils;
import com.demo.controller.PcdngContentExtractRepository;
import com.demo.controller.ProceedingContentExtract;
import com.demo.controller.ProceedingContentExtractService;
import com.demo.controller.StndDocumentExtrctPurpsRepository;

import junit.framework.Assert;


@RunWith(SpringRunner.class)
@SpringBootTest(classes= {
		Application.class,
		NoteRecordController.class,
		ProceedingContentExtractService.class,
		StndDocumentExtrctPurpsRepository.class,
		PcdngContentExtractRepository.class,
		PTABBusinessUtils.class
		
},
webEnvironment=WebEnvironment.RANDOM_PORT)
public class NoteRecordControllerTest {

	@LocalServerPort
    int randomServerPort = 8080;
	
	@Autowired
	private TestRestTemplate template;
     
	@Test
	public void testAddEmployeeWithoutHeader_success() throws URISyntaxException 
	{
	     
	    final String baseUrl = "http://localhost:"+randomServerPort+"/noteRecord/save";
	    URI uri = new URI(baseUrl);
	     
	    ProceedingContentExtract employee = new ProceedingContentExtract();
	 
	    ResponseEntity<Object> result = template.postForEntity(uri, employee, Object.class);
	     
	    //Verify request succeed
	    Assert.assertEquals(200, result.getStatusCodeValue());
	}
}
