package ru.zelmex.Clubs.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "amplua")
public class Amplua {

   @Id
   @Column(name = "id")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   
   @Column(name = "name")
   private String name;
   
   @Column(name = "requirements")
   private String requirements;
   
   @Column(name = "average_salary")
   private String average_salary;
   
   public Long getId() {
      return id;
   }
   
   public void setId(Long id) {
      this.id = id;
   }
   
   public void setName(String name) {

      if (!name.isEmpty()) this.name = name;
      else throw new IllegalArgumentException("Поля не должны быть пустыми!");
   }

   
   public String getName() {
      return name;
   }
   
   public void setRequirements(String requirements) {

      if (!requirements.isEmpty()) this.requirements = requirements;
      else throw new IllegalArgumentException("Поля не должны быть пустыми!");
   }
   public String getRequirements() {
      return requirements;
   }
   
   public void setAverage_salary(String average_salary) {

      if (!average_salary.isEmpty()) this.average_salary = average_salary;
      else throw new IllegalArgumentException("Поля не должны быть пустыми!");
   }
   
   public String getAverage_salary() {
      return average_salary;
   }
   

   @Override
   public String toString() {
       return "Amplua{ " +
           "id='" + id + "'" + 
           ", Name = '" + name + "'" + 
           ", Requirements = '" + requirements + "'" + 
           ", Average_salary = '" + average_salary + "'" + 
      "}";
   }}