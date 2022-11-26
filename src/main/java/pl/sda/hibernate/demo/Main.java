package pl.sda.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // wywołaj try-with-resources który zamknie sesję automatycznie po opuszczeniu try
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Student student = new Student();
            student.setImie("Paweł");
            student.setDataUrodzenia(LocalDate.of(1990, 1, 3));
            student.setKierunekNauczania("Informatyka");
            student.setIndeks("123123");

            session.persist(student);

            transaction.commit();

        } catch (Exception ioe) {
            // jeśli złapiemy błąd, to wywoła się catch

        }
    }
}
