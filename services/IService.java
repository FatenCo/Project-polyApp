/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import java.util.List;
import javafx.collections.ObservableList;
/**
 *
 * @author Molka
 */
public interface IService<T> {
   

    public void ajouter(T t);
    public T getById(int id);
    public List<T> getAll();
    public boolean modifier(T t);
    public boolean supprimer(T t);
    List<T> getAllByUser(int t);
    public T findById(int t);

 
    
    
}