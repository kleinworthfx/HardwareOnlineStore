package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Payment;
import za.ac.cput.service.PaymentService;

import java.util.List;

/* PaymentController.java
   REST Controller for Payment Entity
   Author: Khonzinkosi Khumalo (230231802)
   Date: 19 July 2026 */

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/create")
    public Payment create(@RequestBody Payment payment) {
        return paymentService.create(payment);
    }

    @GetMapping("/read/{id}")
    public Payment read(@PathVariable String id) {
        return paymentService.read(id);
    }

    @PostMapping("/update")
    public Payment update(@RequestBody Payment payment) {
        return paymentService.update(payment);
    }

    @GetMapping("/getall")
    public List<Payment> getAll() {
        return paymentService.getAll();
    }
}