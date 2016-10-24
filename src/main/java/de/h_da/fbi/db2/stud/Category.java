/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.h_da.fbi.db2.stud;

import de.h_da.fbi.db2.tools.CsvDataReader;
import java.util.HashMap;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author kyodu
 */
@Entity
public class Category {
    private String name;
    //private HashMap<String, Question> questions = new HashMap();
    

    
    Long id;
    
    public Category(){
       
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }         
    
    public void browse(){
        
        System.out.println("Category: " + getName());
        System.out.println("-----------------");
        System.out.println();
        System.out.println("-----------------");
    }

    /**
     * @return the name
     */
    @Basic
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
