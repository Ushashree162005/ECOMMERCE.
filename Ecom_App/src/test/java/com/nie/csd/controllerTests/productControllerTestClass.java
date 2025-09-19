package com.nie.csd.controllerTests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.nie.csd.controllers.ProductController;

//@SpringBootTest
@WebMvcTest(ProductController.class)


public class productControllerTestClass {
    @Autowired
    ProductController controller;

    @Autowired
    MockMvc mockMvc;

    
    
    @Test
    void contextLoads() {
         assert(controller!=null);
    }
    public void testSayHello() throws Exception {

        // String result=controller.sayHello();
        // String expected ="HELLO";
        // assert(result.equals(expected));
        mockMvc.perform(get("/hello1"))
        .andExpect(status().isOk())
        .andExpect(content().string("HELLO"));

}
}