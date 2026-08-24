package za.ac.cput.service;

import za.ac.cput.entity.Cart;
import java.util.List;

/* ICartService.java
   Cart Service Interface Contract
   Author: Mfanafuthi Khumalo 230018270
   Date: 12 July 2026 */
public interface ICartService extends IService<Cart, String> {
    List<Cart> getAll();
}