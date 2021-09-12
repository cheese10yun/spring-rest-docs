package com.rest.docs.order;

import static com.rest.docs.RestDocsConfiguration.field;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.rest.docs.TestSupport;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;


class OrderApiTest extends TestSupport {

    @Test
    public void order_create() throws Exception {
        mockMvc.perform(
                post("/api/orders")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(readJson("/json/order-api/order.json"))
            )
            .andExpect(status().isOk())
            .andDo(
                restDocs.document(
                    requestFields(
                        fieldWithPath("orderNumber").description("주문번호").attributes(field("length", "20")),
                        fieldWithPath("memberId").description("MemberId").optional().attributes(field("length", "30")),
                        fieldWithPath("amount").description("주문 금액"),
                        fieldWithPath("address").description("주문 주소").attributes(field("length", "30"))
                    )
                )
            )
        ;
    }
}