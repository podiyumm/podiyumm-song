package io.posiyumm.song.app.mapper;

import io.posiyumm.song.api.Song;
import io.posiyumm.song.app.entity.SongEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SongMapper {
    SongMapper INSTANCE = Mappers.getMapper( SongMapper.class );

    Song songEntityToSong(SongEntity songEntity);

    SongEntity songToSongEntity(Song song);
}
