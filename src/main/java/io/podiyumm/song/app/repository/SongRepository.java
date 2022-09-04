package io.podiyumm.song.app.repository;

import javax.enterprise.context.ApplicationScoped;
import io.podiyumm.song.app.entity.Song;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

@ApplicationScoped
public class SongRepository implements PanacheMongoRepository<Song> {
}
