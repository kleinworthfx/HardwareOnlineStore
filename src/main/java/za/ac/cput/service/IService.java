package za.ac.cput.service;

/* IService.java
   Generic Base Service Interface Contract
   Author: Khonzinkosi Khumalo (230231802)
   Date: 12 July 2026 */

public interface IService<T, ID>{
    T create(T t);

    T read(ID id);

    T update(T t);

    boolean delete(ID id);
}
