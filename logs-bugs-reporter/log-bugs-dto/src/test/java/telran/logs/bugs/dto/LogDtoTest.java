package telran.logs.bugs.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import javax.validation.Valid;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@WebMvcTest(LogDtoTest.TestController.class)
@ContextConfiguration(classes = LogDtoTest.TestController.class)

public class LogDtoTest {

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    MockMvc mock;

    public static @RestController class TestController {
	static LogDto logDtoExp = new LogDto(new Date(), LogType.NO_EXCEPTION, "artifacat", 0, "");
	@PostMapping("/")
	public void testPost(@RequestBody @Valid LogDto logDto) {
	    assertEquals(logDtoExp, logDto);
	}

    }

    @Test
    void testPostRun() throws JsonProcessingException, Exception {
	assertEquals(HttpStatus.OK, HttpStatus.valueOf(mock.perform(MockMvcRequestBuilders.post("/")
		.contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(TestController.logDtoExp)))
		.andReturn().getResponse().getStatus()));
    }
}
