package io.posiyumm.song.app.entity;

import io.quarkus.mongodb.panache.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import org.bson.types.ObjectId;

@MongoEntity(collection="song")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Song {

    private ObjectId id;
    private String title;
    private String subtitle;
    private String artist;
    private String composer;
    private String lyricist;
    private String copyright;
    private String album;
    private Short year;
    private String key;
    private LocalDateTime time;
    private Integer tempo;
    private Long duration;
    private Integer capo;
    private String meta;
    private List<String> text;
}
