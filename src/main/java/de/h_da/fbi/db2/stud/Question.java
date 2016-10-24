/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.h_da.fbi.db2.stud;

import java.util.HashMap;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author kyodu
 */
@Entity
public class Question {
    private String title;
    private Long Id;
    private Long FId;
    private HashMap<String, Answer> answers = new HashMap();
    
    public Question(){
    }
    
    public void browse(){
        System.out.print(getTitle());
        answers.forEach((k,v) -> v.browse());
        System.out.println();
        
    }
    /**
     * @return the title
     */
    @Basic
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the Id
     */
    @Id
    public Long getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(Long Id) {
        this.Id = Id;
    }

    /**
     * @return the FId
     */
    public Long getFId() {
        return FId;
    }

    /**
     * @param FId the FId to set
     */
    public void setFId(Long FId) {
        this.FId = FId;
    }
}
