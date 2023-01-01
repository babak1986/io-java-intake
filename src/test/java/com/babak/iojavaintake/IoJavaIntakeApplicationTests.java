package com.babak.iojavaintake;

import org.json.JSONObject;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ActiveProfiles("io-java-intake-test")
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class IoJavaIntakeApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

    @Test
    void login() throws Exception {
        mockMvc.perform(post("/user/login")
                        .content(
                                new JSONObject()
                                        .put("username", "test")
                                        .put("password", "test")
                                        .toString()
                        )
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void create() throws Exception {
        mockMvc.perform(post("/tedtalk/v1/create")
                        .content(
                                new JSONObject()
                                        .put("title", "Test mock")
                                        .put("author", "mockito")
                                        .put("link", "http://ssssss")
                                        .toString()
                        )
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJ1c2VybmFtZSI6InRlc3QiLCJwYXNzd29yZCI6Iu-_ve-_vdCB77-9TH1l77-9L--_ve-_vVrvv71cdTAwMTXvv73vv71PXHUwMDFCK1x1MDAwQu-_vSzvv71dbFx1MDAxNe-_ve-_vVxuXGIiLCJzdWIiOiIxIiwiaWF0IjoxNjcyNTA4Nzk4LCJleHAiOjE2NzM3MTgzOTh9.t7H_3JkokfKoHxSvGj2NvgIIk66HiaCL6sCqoSOzVKM4wpxLIIuf458mljymsDCVrQh9PlfzuA10zspgKHWKIw"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Test mock"));
    }

    @Test
    void update() throws Exception {
        mockMvc.perform(post("/tedtalk/v1/update")
                        .content(
                                new JSONObject()
                                        .put("id", "3")
                                        .put("title", "Test mock")
                                        .put("author", "mockito")
                                        .put("link", "http://ssssss")
                                        .toString()
                        )
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJ1c2VybmFtZSI6InRlc3QiLCJwYXNzd29yZCI6Iu-_ve-_vdCB77-9TH1l77-9L--_ve-_vVrvv71cdTAwMTXvv73vv71PXHUwMDFCK1x1MDAwQu-_vSzvv71dbFx1MDAxNe-_ve-_vVxuXGIiLCJzdWIiOiIxIiwiaWF0IjoxNjcyNTA4Nzk4LCJleHAiOjE2NzM3MTgzOTh9.t7H_3JkokfKoHxSvGj2NvgIIk66HiaCL6sCqoSOzVKM4wpxLIIuf458mljymsDCVrQh9PlfzuA10zspgKHWKIw"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Test mock"));
    }

    @Test
    void delete() throws Exception {
        mockMvc.perform(post("/tedtalk/v1/delete/8")
                        .header("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJ1c2VybmFtZSI6InRlc3QiLCJwYXNzd29yZCI6Iu-_ve-_vdCB77-9TH1l77-9L--_ve-_vVrvv71cdTAwMTXvv73vv71PXHUwMDFCK1x1MDAwQu-_vSzvv71dbFx1MDAxNe-_ve-_vVxuXGIiLCJzdWIiOiIxIiwiaWF0IjoxNjcyNTA4Nzk4LCJleHAiOjE2NzM3MTgzOTh9.t7H_3JkokfKoHxSvGj2NvgIIk66HiaCL6sCqoSOzVKM4wpxLIIuf458mljymsDCVrQh9PlfzuA10zspgKHWKIw"))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    void search() throws Exception {
        mockMvc.perform(get("/tedtalk/v1/search?title=Tec")
                        .header("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJ1c2VybmFtZSI6InRlc3QiLCJwYXNzd29yZCI6Iu-_ve-_vdCB77-9TH1l77-9L--_ve-_vVrvv71cdTAwMTXvv73vv71PXHUwMDFCK1x1MDAwQu-_vSzvv71dbFx1MDAxNe-_ve-_vVxuXGIiLCJzdWIiOiIxIiwiaWF0IjoxNjcyNTA4Nzk4LCJleHAiOjE2NzM3MTgzOTh9.t7H_3JkokfKoHxSvGj2NvgIIk66HiaCL6sCqoSOzVKM4wpxLIIuf458mljymsDCVrQh9PlfzuA10zspgKHWKIw"))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
