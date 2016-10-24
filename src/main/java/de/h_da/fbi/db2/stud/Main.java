package de.h_da.fbi.db2.stud;

import de.h_da.fbi.db2.tools.CsvDataReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.HashMap;
import javax.persistence.*;

/**
 * Created by a.hofmann on 03.10.2016.
 */
public class Main {

        private static EntityManagerFactory emf;
    private static EntityManager em;
    /**
     * @param args
     */
    public static void main(String[] args) {
        //PUT YOUR CODE HERE
        emf = Persistence.createEntityManagerFactory("defaultPU");
        em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        
        try {

            HashMap<String, Category> category = new HashMap();

            List<String[]> Strings = CsvDataReader.read();
            String tmp;
            for (int i = 1; i < Strings.size(); i++) {
                tmp = Strings.get(i)[7];
                
                Category c = new Category();
                c.setName(tmp);
                

                if (category.containsKey(tmp)) {
                } else {
                    category.put(tmp, c);
                    em.persist(c);
                }
            }
            
            
               for (int i = 1; i < Strings.size(); i++) {
                tmp = Strings.get(i)[7];
                
                Question q = new Question();
                q.setTitle(Strings.get(i)[1]);
                q.setId(Long.parseLong(Strings.get(i)[0]));
                q.setFId(category.get(Strings.get(i)[7]).getId());
                
                for(int l=2;l<6; l++){
                Answer a = new Answer();
                a.setAnswer(Strings.get(i)[l]);
                a.setFId(q.getId());
                if (Integer.parseInt(Strings.get(i)[6]) == l-1)
                    a.setCorrect(true);
                else
                    a.setCorrect(false);
               
                em.persist(a);
                
                
                
                }
                em.persist(q);
            }
            
            em.getTransaction().commit();
            em.close();
            category.forEach((k, v) -> v.browse());
            // System.out.println(Arrays.toString(Strings.get(i))); //alles ausgeheben
        } catch (URISyntaxException | IOException name) {
        }

    }

}
