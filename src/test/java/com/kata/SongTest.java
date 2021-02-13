package com.kata;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import org.approvaltests.Approvals;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;


@DisplayNameGeneration(ReplaceUnderscores.class)
class SongTest {

    @Test
    void sing_a_song() throws Exception {

        String song = tapSystemOut(() -> {
            Song.main(new String[]{"fly", "spider", "bird", "cat", "dog", "cow", "horse"});
        });

        Approvals.verify(song);
    }

    @Test
    void sing_a_song_with_minus_animals() throws Exception {

        String song = tapSystemOut(() -> {
            Song.main(new String[]{"cow", "cat", "spider", "fly", "horse"});
        });

        Approvals.verify(song);
    }

}
