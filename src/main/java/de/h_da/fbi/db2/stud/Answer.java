/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.h_da.fbi.db2.stud;
import javax.persistence.*;

/**
 *
 * @author kyodu
 */
@Entity
public class Answer {
    
    private String answer;
    private boolean correct;
    private Long Id;
    private Long FId;
    public Answer(){

               
    }
    public void browse(){
        System.out.println();
        System.out.print("  " +getAnswer());
       
    }

    /**
     * @return the answere
     */
    @Basic
    public String getAnswer() {
        return answer;
    }

    /**
     * @param answere the answere to set
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * @return the correct
     */
    @Basic
    public boolean isCorrect() {
        return correct;
    }

    /**
     * @param correct the correct to set
     */
    
    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    /**
     * @return the Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
