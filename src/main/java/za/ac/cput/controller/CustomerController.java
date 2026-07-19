package za.ac.cput.controller;

import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Customer;
import za.ac.cput.service.CustomerService;

import java.util.List;

/* CustomerController.java
   Customer REST Controller
   Author: Paul Khumalo (230108547)
   Date: 19/07/2026
*/

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService service = CustomerService.getService();

    @PostMapping("/create")
    public Customer create(@RequestBody Customer customer) {
        return service.create(customer);
    }

    @GetMapping("/read/{customerId}")
    public Customer read(@PathVariable String customerId) {
        return service.read(customerId);
    }

    @PostMapping("/update")
    public Customer update(@RequestBody Customer customer) {
        return service.update(customer);
    }

    @DeleteMapping("/delete/{customerId}")
    public boolean delete(@PathVariable String customerId) {
        return service.delete(customerId);
    }

    @GetMapping("/getAll")
    public List<Customer> getAll() {
        return service.getAll();
    }
}