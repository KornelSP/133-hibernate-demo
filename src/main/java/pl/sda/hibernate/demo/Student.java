package pl.sda.hibernate.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

// Klasa POJO => Plain Old Java

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id // PRIMARY KEY
    @GeneratedValue (strategy = GenerationType.IDENTITY) //AUTO_INCERMENT
    private Long id;

    private String imie;
    private LocalDate dataUrodzenia;
    private String kierunekNauczania;
    private String indeks; //  "index" jest słowem zabronionym przez mysql
}
