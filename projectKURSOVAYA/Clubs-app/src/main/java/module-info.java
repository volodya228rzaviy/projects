module ru.zelmex.Clubs {
   requires javafx.controls;
   requires javafx.fxml;
   requires jakarta.persistence;
   requires org.hibernate.orm.core;
   requires java.naming;
   requires java.desktop;
   requires org.hibernate.validator;
   requires org.postgresql.jdbc;
   requires jakarta.validation;
   
   opens ru.zelmex.Clubs to javafx.graphics;   opens ru.zelmex.Clubs.controller to javafx.fxml;   opens ru.zelmex.Clubs.model to org.hibernate.orm.core;   
   exports ru.zelmex.Clubs;}