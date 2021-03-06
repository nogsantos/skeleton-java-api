/**
 * @todo Setup database for integration tests
 */
//package me.fabricionogueira.api.modules.main;
//
//import org.junit.Before;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.mock.http.MockHttpOutputMessage;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.web.context.WebApplicationContext;
//
//import java.io.IOException;
//import java.nio.charset.Charset;
//import java.util.Arrays;
//
//import static org.junit.Assert.assertNotNull;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
//
//@RunWith(SpringRunner.class)
//@AutoConfigureMockMvc
//@SpringBootTest
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class MainControllerTest {
//
//	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
//		MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
//
//	private MockMvc mockMvc;
//	private HttpMessageConverter mappingJackson2HttpMessageConverter;
//
//	@Autowired
//	private WebApplicationContext webApplicationContext;
//
//	@Autowired
//	void setConverters(HttpMessageConverter<?>[] converters) {
//		this.mappingJackson2HttpMessageConverter = Arrays.stream(converters).filter(
//			hmc -> hmc instanceof MappingJackson2HttpMessageConverter
//		).findAny().orElse(null);
//		assertNotNull("the JSON message converter must not be null", this.mappingJackson2HttpMessageConverter);
//	}
//
//	@Before
//	public void setup() throws Exception {
//		this.mockMvc = webAppContextSetup(webApplicationContext).build();
//	}
//
//	@Test
//	public void isUp() throws Exception {
//		mockMvc.perform(get("/").contentType(contentType)).andExpect(status().isOk());
//	}
//
//	/**
//	 *
//	 */
//	protected String json(Object o) throws IOException {
//		MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
//		this.mappingJackson2HttpMessageConverter.write(o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
//		return mockHttpOutputMessage.getBodyAsString();
//	}
//}
