package io.podiyumm.song.resource;

import io.podiyumm.song.app.entity.Song;
//import io.quarkus.panache.mock.PanacheMock;
import io.podiyumm.song.app.repository.SongRepository;
import io.podiyumm.song.app.resource.SongResource;
import io.quarkus.mongodb.panache.PanacheQuery;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

@QuarkusTest
@Disabled
public class SongResourceTest {
//
//    @Inject
//    SongResource songResource;
//
    @InjectMock
    SongRepository songRepository;
//
    private Song song;
    private List<Song> songs ;

//    @BeforeEach
//    public void beforeEach() {
//        PanacheMock.mock(Song.class);
//    }

    @Test
    public void songGet() {
        songs=  new ArrayList<>();
        song = Song.builder().build();
        PanacheQuery query = Mockito.mock(PanacheQuery.class);
        Mockito.when(query.page(Mockito.any())).thenReturn(query);
        Mockito.when(query.firstResultOptional()).thenReturn(Optional.of(song));

//        Page page = new Page(1,10);
//        when(query.page()).thenReturn(page);
        when(songRepository.findAll()).thenReturn(query);
//        when(songRepository.list(any(String.class), any())).thenReturn(query);
////        songs = new ArrayList<>();
//        PanacheQuery query = Mockito.mock(PanacheQuery.class);
////
////        Page page = new Page(1,10);
////        when(query.page()).thenReturn(page);
////
////        when(query.page(Mockito.any())).thenReturn(query);
//        when(query.list()).thenReturn(songs);
//        when(songRepository.findAll()).thenReturn(query);

//        assertEquals(Collections.emptyList(), songResource.list(new Page(1,10), Sort.by(Song.Fields.id)));
        given()
          .when().get("/song")
          .then()
             .statusCode(200)
             .body(is("{}"));
    }

}