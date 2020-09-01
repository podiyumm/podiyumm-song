package io.posiyumm.song.app.repository;

import io.posiyumm.song.app.entity.SongEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<SongEntity, Long> {
}
