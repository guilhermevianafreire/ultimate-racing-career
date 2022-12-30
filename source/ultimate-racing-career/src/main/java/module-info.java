module br.tec.gvfsolucoes.ultimateracingcareer {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;

    requires org.controlsfx.controls;

    requires java.sql;

    requires org.xerial.sqlitejdbc;
    requires liquibase.core;

    requires ch.qos.logback.classic;
    requires ch.qos.logback.core;
    requires org.slf4j;

    requires org.apache.commons.lang3;
    requires org.apache.commons.io;
    requires org.apache.commons.collections4;
    requires org.apache.commons.text;
    requires org.apache.commons.rng.api;
    requires org.apache.commons.rng.core;
    requires org.apache.commons.rng.simple;
    requires commons.dbutils;
    requires com.jfoenix;

    exports br.tec.gvfsolucoes.ultimateracingcareer;
    exports br.tec.gvfsolucoes.ultimateracingcareer.conttroller;

    opens br.tec.gvfsolucoes.ultimateracingcareer;
    opens br.tec.gvfsolucoes.ultimateracingcareer.conttroller;
}
