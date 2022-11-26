package pl.sda.hibernate.demo;

import org.hibernate.Session;

public class MainRead_SelectById {
    public static void main(String[] args) {
        // wywołaj try-with-resources który zamknie sesję automatycznie po opuszczeniu try
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Student student = session.get(Student.class, 2L);

            System.out.println("Znaleźliśmy studenta: " + student);

        } catch (Exception ioe) {
            // jeśli złapiemy błąd, to wywoła się catch
            System.err.println("Błąd bazy: " + ioe);
        }
    }
}