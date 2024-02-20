package com.enseignats.enseignement.entity;




import jakarta.persistence.*;
import lombok.*;



@Getter
@Setter
@Entity
@Table(name="Enseignant_command")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enseignant {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "prenom")  // Specify the custom column name for firstname
    private String firstname;

    @Column(name = "nom")     // Specify the custom column name for lastname
    private String lastname;

    @Column(name = "age_personnel")  // Specify the custom column name for age
    private Integer age;
}