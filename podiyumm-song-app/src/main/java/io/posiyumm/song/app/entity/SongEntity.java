package io.posiyumm.song.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "SONG")
public class SongEntity {

    @Id
    @SequenceGenerator(name = "SongSequence", sequenceName = "SONG_SEQ",
            allocationSize = 50)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SongSequence")
    private Long id;

    private String text;
}
