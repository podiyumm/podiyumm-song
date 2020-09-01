package io.posiyumm.song.app.controller;

import io.posiyumm.song.api.Song;
import io.posiyumm.song.app.entity.SongEntity;
import io.posiyumm.song.app.mapper.SongMapper;
import io.posiyumm.song.app.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class SongController {

    private final SongRepository songRepository;
    private final SongMapper songMapper;

    @GetMapping("/song/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Song getSong(@PathVariable("id") Long id) {
        Optional<SongEntity> songEntity = songRepository.findById(id);
        return songMapper.songEntityToSong(songEntity.get());
    }
}
