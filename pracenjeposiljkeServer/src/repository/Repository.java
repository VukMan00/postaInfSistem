/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;

/**
 *
 * @author Vuk
 */
public interface Repository<T> {
    void add(T t) throws Exception;
    void addWithStructureType(T t) throws Exception;
    void update(T t) throws Exception;
    void updateWithStructureType(T t) throws Exception;
    void delete(T t) throws Exception;
    T get(T t) throws Exception;
    List<T> getAll(T t) throws Exception;
    List<T> getAllWithCondition(T t) throws Exception;
    List<T> getAlllWithPartition(T t) throws Exception;
    T authenticate(T t) throws Exception;
}
