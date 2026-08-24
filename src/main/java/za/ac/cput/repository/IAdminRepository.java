package za.ac.cput.repository;

import za.ac.cput.entity.Admin;

import java.util.List;

/* IAdminRepository.java
   Admin Repository Interface
   Author: Paul Khumalo (230108547)
   Date: 5 June 2026 */

public interface IAdminRepository extends IRepository<Admin, String> {
   List<Admin> getAll();
}