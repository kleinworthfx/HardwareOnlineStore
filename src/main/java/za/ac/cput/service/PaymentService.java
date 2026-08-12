package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Payment;
import za.ac.cput.repository.IPaymentRepository;

import java.util.List;

/* PaymentService.java
   Payment Service Implementation
   Author: Khonzinkosi Khumalo (230231802)
   Date: 12 July 2026 */

@Service
public class PaymentService implements IPaymentService {

    private final IPaymentRepository repository;

    @Autowired
    public PaymentService(IPaymentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Payment create(Payment payment) {
        return this.repository.save(payment);
    }

    @Override
    public Payment read(String paymentId) {
        return this.repository.findById(paymentId).orElse(null);
    }

    @Override
    public Payment update(Payment payment) {
        return this.repository.save(payment);
    }

    @Override
    public List<Payment> getAll() {
        return this.repository.findAll();
    }
}