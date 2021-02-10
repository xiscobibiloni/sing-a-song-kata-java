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
}
