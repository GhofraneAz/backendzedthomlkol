package com.example.demo.entities;




import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "type_titres")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TypeTitre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String CodeTypeTitre;
    private String LibelleTypeTitre;
}
