//package ie.project.configuration.controllers;
//
//import ie.project.PublishStystemOfArticlesScienceApplication;
//import ie.project.controllers.HomeController;
//import ie.project.repositories.UserRepository;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mock.web.MockHttpServletRequest;
//import org.springframework.mock.web.MockHttpSession;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
//
///**
// * Created by pawel on 11.04.16.
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@ContextConfiguration(classes = PublishStystemOfArticlesScienceApplication.class)
//public class HomeControllerTest {
//
//    @Autowired
//    WebApplicationContext wac;
//    @Autowired
//    MockHttpSession session;
//    @Autowired
//    MockHttpServletRequest request;
//
//
//    private MockMvc mockMvc;
//
//    @Before
//    public void setup() {
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
//    }
//
//
//    @Test
//    public void testIndexMvc() throws Exception {
//        this.mockMvc = MockMvcBuilders.standaloneSetup(new HomeController()).build();
//
//        mockMvc.perform(get("/"))
//                .andDo(print())
//                .andExpect(view().name("index"))
//                .andExpect(status().isOk());
//
//
//    }
//}