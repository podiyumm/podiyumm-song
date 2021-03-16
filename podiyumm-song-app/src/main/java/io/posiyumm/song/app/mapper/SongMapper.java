package io.posiyumm.song.app.mapper;

import java.util.List;
import io.posiyumm.song.app.entity.Song;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SongMapper {
    SongMapper INSTANCE = Mappers.getMapper( SongMapper.class );

//    io.posiyumm.song.api.Song toSong(Song songEntity);
//
//    Song toSongEntity(io.posiyumm.song.api.Song song);
//
//    List<io.posiyumm.song.api.Song> toSongs(List<Song> songEntity);
//
//    List<Song> toSongEntities(List<io.posiyumm.song.api.Song> song);
}
