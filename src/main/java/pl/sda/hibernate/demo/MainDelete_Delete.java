
package pl.sda.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class MainDelete_Delete {
    public static void main(String[] args) {
        // wywołaj try-with-resources który zamknie sesję automatycznie po opuszczeniu try
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();

            // Najpierw SELECT * FROM Student WHERE id = 2L
            Student student = session.get(Student.class, 2L);

            // jeśli udało się znaleźć
            if (student != null) {
                // DELETE FROM Student WHERE id = 2L
                session.remove(student);
            }

            // zatwierdzamy transakcję
            transaction.commit();
        } catch (Exception ioe) {
            // jeśli złapiemy błąd, to wywoła się catch

        }
    }
}