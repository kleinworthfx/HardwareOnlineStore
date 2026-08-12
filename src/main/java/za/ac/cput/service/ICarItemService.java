package za.ac.cput.service;

import za.ac.cput.domain.CartItem;
import java.util.List;

/* ICartItemService.java
   CartItem Service Interface Contract
   Author: Mfanafuthi Khumalo 230018270
   Date: 12 July 2026 */
public interface ICarItemService extends IService<CartItem, String> {
    List<CartItem> getAll();
}