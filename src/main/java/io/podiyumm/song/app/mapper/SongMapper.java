package io.podiyumm.song.app.mapper;

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
