package io.posiyumm.song.app.resource;

import org.bson.types.ObjectId;
import io.posiyumm.song.app.entity.Song;
import io.posiyumm.song.app.repository.SongRepository;
import io.quarkus.mongodb.rest.data.panache.PanacheMongoRepositoryResource;
import io.quarkus.rest.data.panache.ResourceProperties;

@ResourceProperties(hal = true)
public interface SongResource extends PanacheMongoRepositoryResource<SongRepository, Song, ObjectId> {
}

//
//public interface SongResource extends PanacheMongoEntityResource<Song, Long> {
//
//    @MethodProperties(exposed = false)
//    Author add(Author entity);
//
//    @MethodProperties(exposed = false)
//    Author update(ObjectId id, Author entity);
//
//    @MethodProperties(exposed = false)
//    boolean delete(ObjectId id);
//}
//}
