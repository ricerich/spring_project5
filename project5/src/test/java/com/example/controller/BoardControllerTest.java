package com.example.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration // ���� ���ؽ�Ʈ�� ����ϰڴٴ� �ǹ�
//@ContextConfiguration({ "file:src/main/webapp/WEB-INF/root-context.xml",
//						  "file:src/main/webapp/WEB-INF/appServlet/servlet-context.xml" })
@ContextConfiguration(classes = { com.example.config.RootConfig.class, com.example.config.ServletConfig.class })
@Log4j
public class BoardControllerTest {
	@Setter(onMethod_ = { @Autowired })
	private WebApplicationContext ctx;

	private MockMvc mockMvc;// ��¥ mvc- url�� �Ķ���͸� ������ ���ó�� ����� ��Ʈ�ѷ� ����

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

//	@Test//1.�Է� �׽�Ʈ
	public void testRegister() throws Exception {

		String resultPage = mockMvc.perform(MockMvcRequestBuilders
											.post("/board/register")
								   			.param("title", "�׽�Ʈ ���� ����")
							   				.param("content", "�׽�Ʈ ���� ����")
						   					.param("writer", "user00")
						   					)
								   .andReturn()
								   .getModelAndView()
								   .getViewName();
		log.info(resultPage);
	}

//	@Test//2.��ȸ �׽�Ʈ
	public void tetGet() throws Exception {

		log.info(mockMvc.perform(MockMvcRequestBuilders
								 .get("/board/get")
								 .param("bno", "5"))
						.andReturn()
						.getModelAndView()
						.getModelMap()
				);
	}

//	@Test//3.���� �׽�Ʈ
	public void testModify() throws Exception {

		String resultPage = mockMvc.perform(MockMvcRequestBuilders
											.post("/board/modify")
											.param("bno", "1")
											.param("title", "������ �׽�Ʈ ���� ����")
											.param("content", "������ �׽�Ʈ ���� ����")
											.param("writer", "user00"))
									.andReturn()
									.getModelAndView()
									.getViewName();
		log.info(resultPage);
	}

	@Test//4.���� �׽�Ʈ
	public void testRemove() throws Exception {
		// ������ �����ͺ��̽��� �Խù� ��ȣ Ȯ���� ��
		String resultPage = mockMvc.perform(MockMvcRequestBuilders
											.post("/board/remove")
											.param("bno", "4"))
									.andReturn()
									.getModelAndView()
									.getViewName();
		log.info(resultPage);
	}
}
