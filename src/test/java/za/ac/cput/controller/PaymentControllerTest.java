package za.ac.cput.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Payment;
import za.ac.cput.factory.PaymentFactory;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/* PaymentControllerTest.java
   Controller Integration Tests for Payment Endpoints
   Author: Khonzinkosi Khumalo (230231802)
   Date: 19 July 2026 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PaymentControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseUrl = "/payment";
    private static final Payment payment = PaymentFactory.createPayment(
            "PAY-100", "ORD-500", "Credit Card", "TXN-9991", LocalDateTime.now(), new BigDecimal("450.00"), "PENDING"
    );

    @Test
    @Order(1)
    void testCreate() {
        String url = baseUrl + "/create";
        ResponseEntity<Payment> postResponse = restTemplate.postForEntity(url, payment, Payment.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(payment.getPaymentId(), postResponse.getBody().getPaymentId());
    }

    @Test
    @Order(2)
    void testRead() {
        String url = baseUrl + "/read/" + payment.getPaymentId();
        ResponseEntity<Payment> response = restTemplate.getForEntity(url, Payment.class);
        assertNotNull(response.getBody());
        assertEquals(payment.getPaymentId(), response.getBody().getPaymentId());
    }

    @Test
    @Order(3)
    void testUpdate() {
        String url = baseUrl + "/update";
        Payment updated = new Payment.Builder().copy(payment).setPaymentStatus("COMPLETED").build();
        ResponseEntity<Payment> postResponse = restTemplate.postForEntity(url, updated, Payment.class);
        assertNotNull(postResponse.getBody());
        assertEquals("COMPLETED", postResponse.getBody().getPaymentStatus());
    }

    @Test
    @Order(4)
    void testGetAll() {
        String url = baseUrl + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }
}