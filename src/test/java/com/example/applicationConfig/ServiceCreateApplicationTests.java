package com.example.applicationConfig;

import Model.Cliente;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import repository.ClientRepository;
import repository.PhotoRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("test")
class ServiceCreateApplicationTests {
    ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private MockMvc restMock;
    @MockBean
    private ClientRepository clientRepository;
    @MockBean
    PhotoRepository photoRepository;

    @Test
    @WithMockUser(username = "admin", password = "admin" ,authorities = { "ADMIN", "USER" })
    void createClientTest() throws Exception {
        var cliente = TestUtils.createClient();
        restMock.perform(put("/clientes/actualizar/").contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(this.objectMapper.writeValueAsBytes(cliente)))
                .andDo(print()).andExpect(status().isOk()).andExpect(jsonPath(TestUtils.RESPONSE_STATE).value(HttpStatus.OK.value()));
    }

    @Test
    @WithMockUser(username = "admin", password = "admin" ,authorities = { "ADMIN", "USER" })
    void createClientTestServiceException() throws Exception {
        var cliente = new Cliente();
        restMock.perform(put("/clientes/actualizar/").contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(this.objectMapper.writeValueAsBytes(cliente)))
                .andDo(print()).andExpect(status().isOk()).andExpect(jsonPath(TestUtils.RESPONSE_STATE).value(HttpStatus.BAD_REQUEST.value()));
    }

    @Test
    @WithMockUser(username = "admin", password = "admin" ,authorities = { "ADMIN", "USER" })
    void createClientTestGeneralException() throws Exception {
        Mockito.when(this.clientRepository.save(Mockito.any())).thenThrow(NullPointerException.class);
        var cliente = TestUtils.createClient();
        restMock.perform(put("/clientes/actualizar/").contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(this.objectMapper.writeValueAsBytes(cliente)))
                .andDo(print()).andExpect(status().isOk()).andExpect(jsonPath(TestUtils.RESPONSE_STATE).value(HttpStatus.INTERNAL_SERVER_ERROR.value()));
    }

    @Test
    @WithMockUser(username = "admin", password = "admin" ,authorities = { "ADMIN", "USER" })
    void updatePhotoTest() throws Exception {
        MockMultipartHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/photos/update");
        builder.with(request -> {
            request.setMethod("PUT");
            return request;
        });
        restMock.perform(builder
                .file("image", TestUtils.createFile().getBytes())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .param("clientId", "12"))
                .andDo(print()).andExpect(status().isOk()).andExpect(jsonPath(TestUtils.RESPONSE_STATE).value(HttpStatus.OK.value()));
    }


    @Test
    @WithMockUser(username = "admin", password = "admin" ,authorities = { "ADMIN", "USER" })
    void updatePhotoTestGeneralException() throws Exception {
        Mockito.when(this.photoRepository.save(Mockito.any())).thenThrow(NullPointerException.class);
        MockMultipartHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.multipart("/photos/update");
        builder.with(request -> {
            request.setMethod("PUT");
            return request;
        });
        restMock.perform(builder
                        .file("image", TestUtils.createFile().getBytes())
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .param("clientId", "12"))
                .andDo(print()).andExpect(status().isOk()).andExpect(jsonPath(TestUtils.RESPONSE_STATE).value(HttpStatus.INTERNAL_SERVER_ERROR.value()));
    }

}
