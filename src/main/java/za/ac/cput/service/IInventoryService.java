package za.ac.cput.service;

import za.ac.cput.domain.Inventory;
import java.util.List;

/* IInventoryService.java
   Inventory Service Interface Contract
   Author: Khonzinkosi Khumalo (230231802)
   Date: 12 July 2026 */

public interface IInventoryService extends IService<Inventory, String> {
    List<Inventory> getAll();
}
