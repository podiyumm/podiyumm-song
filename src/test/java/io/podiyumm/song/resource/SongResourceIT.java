package io.podiyumm.song.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.apache.groovy.util.Maps;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;
import io.podiyumm.song.app.entity.Song;
import io.quarkus.mongodb.panache.PanacheQuery;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@Testcontainers
@QuarkusTestResource(SongResourceIT.Initializer.class)
public class SongResourceIT {

    public static class Initializer implements QuarkusTestResourceLifecycleManager {
        @Override
        public Map<String, String> start() {
            SongResourceIT.mongoDBContainer.start();
            // the way to dynamically expose allocated port
            return Maps.of("quarkus.mongodb.connection-string", "mongodb://" + mongoDBContainer.getContainerIpAddress() + ":" + mongoDBContainer.getFirstMappedPort() + "/podiyumm");
        }

        @Override
        public void stop() {
            SongResourceIT.mongoDBContainer.stop();
        }
    }

    private List<Song> songs;

    @Container
    public static final MongoDBContainer mongoDBContainer = new MongoDBContainer(DockerImageName.parse("mongo:latest"));

    @Test
    public void songGet() {
        given()
                .when().get("/song")
                .then()
                .statusCode(200)
                .body(containsString("[{\"id\":"));
    }

}