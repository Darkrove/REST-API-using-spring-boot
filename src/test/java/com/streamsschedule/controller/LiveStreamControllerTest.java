package com.streamsschedule.controller;

import com.streamsschedule.model.LiveStream;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(OrderAnnotation.class)
class LiveStreamControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    @Order(1)
    void findAll() {
        ResponseEntity<List<LiveStream>> entity = findAllStreams();
        assertEquals(HttpStatus.OK,entity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON,entity.getHeaders().getContentType());
        assertEquals(2, entity.getBody().size());
    }

    @Test
    @Order(2)
    void findById() {
        LiveStream existing = findAllStreams().getBody().get(0);
        String id = existing.id();
        String desc = """
            A closer look at different token standards for NFTs namely ERC721, ERC721A and ERC1155
            and understanding differences, optimizations and opportunities.
         """;

        LiveStream stream = restTemplate.getForObject("/api/v.0.1/streams/" + id, LiveStream.class);
        assertEquals(id,stream.id());
        assertEquals("Creating NFTs using different token standards",stream.title());
        assertEquals(desc,stream.description());
    }

    @Test
    @Order(3)
    void create() {
        String id = UUID.randomUUID().toString();
        LiveStream stream = new LiveStream(
                id,
                "TEST_TITLE",
                "TEST_DESC",
                "https://www.twtich.tv/sajjadshaikh",
                LocalDateTime.of(2022,3,01,11,0),
                LocalDateTime.of(2022,3,01,12,0)
        );

        ResponseEntity<LiveStream> entity = restTemplate.postForEntity("/api/v.0.1/streams/", stream, LiveStream.class);
        assertEquals(HttpStatus.CREATED,entity.getStatusCode());
        assertEquals(3,findAllStreams().getBody().size());

        LiveStream newStream = entity.getBody();
        assertEquals(id,newStream.id());
        assertEquals("TEST_TITLE",newStream.title());
        assertEquals("TEST_DESC",newStream.description());
        assertEquals("https://www.twtich.tv/sajjadshaikh",newStream.streamUrl());
        assertEquals(LocalDateTime.of(2022,3,01,11,0),newStream.startDate());
        assertEquals(LocalDateTime.of(2022,3,01,12,0),newStream.endDate());
    }

    @Test
    @Order(4)
    void update() {
        LiveStream existing = findAllStreams().getBody().get(0);
        LiveStream stream = new LiveStream(
                existing.id(),
                "BRAND_NEW_TITLE",
                existing.description(),
                existing.streamUrl(),
                existing.startDate(),
                existing.endDate()
        );

        ResponseEntity<LiveStream> entity = restTemplate.exchange("/api/v.0.1/streams/" + existing.id(), HttpMethod.PUT, new HttpEntity<>(stream), LiveStream.class);
        assertEquals(HttpStatus.NOT_FOUND,entity.getStatusCode());
    }

    @Test
    @Order(5)
    void delete() {
        LiveStream existing = findAllStreams().getBody().get(0);
        ResponseEntity<LiveStream> entity = restTemplate.exchange("/api/v.0.1/streams/" + existing.id(), HttpMethod.DELETE, null, LiveStream.class);
        assertEquals(HttpStatus.NOT_FOUND,entity.getStatusCode());
        assertEquals(1,findAllStreams().getBody().size());
    }

    private ResponseEntity<List<LiveStream>> findAllStreams() {
        return restTemplate.exchange("/api/v.0.1/streams",
                HttpMethod.GET,
                new HttpEntity<>(null),
                new ParameterizedTypeReference<List<LiveStream>>() {});
    }
}