/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.util.List;

/**
 *
 * @author User
 */
public interface Model_DAO <A> {
    public int autonumber (A object);
    public void insert(A object);
    public void update(A object);
    public void delete(Integer kode);
    public List<A> getAll();
    public List<A> getCari(String key);
}
