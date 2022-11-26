package pl.sda.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;

public class MainUpdate_Update {
    public static void main(String[] args) {
        // wywołaj try-with-resources który zamknie sesję automatycznie po opuszczeniu try
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {

            Transaction transaction = session.beginTransaction();

            Student student = Student.builder()
                    .dataUrodzenia(LocalDate.of(1995,6,15))
                    .kierunekNauczania("Filozofia")
                    .indeks("321321")
                    .imie("Gaweł")
                    .id(2L)
                    .build();

            session.merge(student);

            transaction.commit();

        } catch (Exception ioe) {
            // jeśli złapiemy błąd, to wywoła się catch
            System.err.println("Błąd bazy: " + ioe);
        }
    }
}