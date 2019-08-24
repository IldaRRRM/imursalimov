package ru.job4j.tracker.config;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.core.Is.is;

public class TrackerConfigTest {
    private final String path = ClassLoader.getSystemResource("app.properties").getPath();


    @Test
    public void readProperties() throws IOException {
        TrackerConfig config = new TrackerConfig(path);
        Assert.assertThat(config.getUrl(), is("jdbc:postgresql://127.0.0.1:5432/tracker"));
    }

    @Test
    public void getAddressTest() throws IOException {
        TrackerConfig config = new TrackerConfig(path);
        Assert.assertThat(config.getPostgresAddres(), is("jdbc:postgresql://127.0.0.1:5432"));
    }

    @Test
    public void getDatabaseName() throws IOException {
        TrackerConfig config = new TrackerConfig(path);
        Assert.assertThat(config.getDatabaseName(), is("tracker"));

    }

}