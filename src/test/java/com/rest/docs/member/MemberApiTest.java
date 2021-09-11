package com.rest.docs.member;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class MemberApiTest {

    /**
     * 1. Member 단일 조회 -> 완료
     * 2. Member 생성 ->
     * 3. Member 수정 ->
     * 4. Member 페이징 조회 -> 완료
     */

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void member_page_test() throws Exception {
        mockMvc.perform(
                get("/api/members")
                    .param("size", "10")
                    .param("page", "0")
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andDo(print())
            .andExpect(status().isOk())
        ;
    }

    @Test
    public void member_get() throws Exception {
        // 조회 API -> 대상의 데이터가 있어야 합니다.
        mockMvc.perform(
                get("/api/members/{id}", 1L)
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andDo(print())
            .andExpect(status().isOk())
        ;
    }

    @Test
    public void member_create() throws Exception {
        mockMvc.perform(
            post("/api/members")
                .contentType(MediaType.APPLICATION_JSON)
                .content(""
                    + "{\n"
                    + "  \"email\": \"bbb@bbb.com\",\n"
                    + "  \"name\": \"bbb\"\n"
                    + "}")
        )
            .andDo(print())
            .andExpect(status().isOk())
            ;
    }

    @Test
    public void member_modify() throws Exception {
        mockMvc.perform(
                put("/api/members/{id}", 1)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(""
                        + "{\n"
                        + "  \"name\": \"new-yun\"\n"
                        + "}")

            )
            .andDo(print())
            .andExpect(status().isOk())
        ;
    }
}