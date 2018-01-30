package com.hospdemo.test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HospDemoControllerTest {
	@Autowired
	private MockMvc mvc;
	@Test
	public void testSave() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/setup").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().string(equalTo("Done")));
	}

	@Test
	public void testFindAllHosp() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/findallhosp").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().string(containsString("Manipal")));
	}
	@Test
	public void testfindpatofhosp() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/findpatofhosp?hospName=Manipal").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().string(containsString("John")));
	}
	@Test
	public void testfindexamofpat() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/findexamofpat?patName=John").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().string(containsString("EX14")));
	}
}
