package ru.job4j.config;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class ConfigTest {

    @Test
    public void testStringOutPut() throws InterruptedException {
        Config config = new Config(ClassLoader.getSystemResource("app.properties").getPath());
        config.load();
        Assert.assertThat(config.value("hibernate.connection.url"), is("jdbc:postgresql://127.0.0.1:5432/trackstudio"));
        Assert.assertThat(config.value("hibernate.dialect"), is("org.hibernate.dialect.PostgreSQLDialect"));
        Assert.assertThat(config.value("hibernate.connection.driver_class"), is("org.postgresql.Driver"));
        Assert.assertThat(config.value("hibernate.connection.username"), is("postgres"));
        Assert.assertThat(config.value("hibernate.connection.password"), is("password"));
    }


}

