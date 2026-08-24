package za.ac.cput.service;

import za.ac.cput.entity.Payment;
import java.util.List;

/* IPaymentService.java
   Payment Service Interface Contract
   Author: Khonzinkosi Khumalo (230231802)
   Date: 12 July 2026 */
public interface IPaymentService extends IService<Payment, String> {
    List<Payment> getAll();
}
