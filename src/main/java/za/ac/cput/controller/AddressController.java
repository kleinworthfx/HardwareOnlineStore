package za.ac.cput.controller;

import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Address;
import za.ac.cput.service.AddressService;

import java.util.List;

/* AddressController.java
   Address REST Controller
   Author: Paul Khumalo (230108547)
   Date: 19/07/2026
*/

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService service = AddressService.getService();

    @PostMapping("/create")
    public Address create(@RequestBody Address address) {
        return service.create(address);
    }

    @GetMapping("/read/{streetAddress}")
    public Address read(@PathVariable String streetAddress) {
        return service.read(streetAddress);
    }

    @PostMapping("/update")
    public Address update(@RequestBody Address address) {
        return service.update(address);
    }

    @DeleteMapping("/delete/{streetAddress}")
    public boolean delete(@PathVariable String streetAddress) {
        return service.delete(streetAddress);
    }

    @GetMapping("/getAll")
    public List<Address> getAll() {
        return service.getAll();
    }
}