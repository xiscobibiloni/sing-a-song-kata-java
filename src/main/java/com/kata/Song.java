package com.kata;

import java.util.Map;

class Song {


    private static final String INITIAL_PHRASE = "There was an old lady who swallowed a ";
    private static final Map<String, String> ANIMAL_PHRASES = Map.of(
        "fly", "I don't know why she swallowed a fly - perhaps she'll die!",
        "spider", "That wriggled and wiggled and tickled inside her.",
        "bird", "How absurd to swallow a bird.",
        "cat", "Fancy that to swallow a cat!",
        "dog", "What a hog, to swallow a dog!",
        "cow", "I don't know how she swallowed a cow!"
    );

    public static void main(String[] args) {

        String song = firstParagraph(args) +
            "\n" +
            middleParagraphFull(args, 2) +
            "\n" +
            middleParagraphFull(args, 3) +
            "\n" +
            middleParagraphFull(args, 4) +
            "\n" +
            middleParagraphFull(args, 5) +
            "\n" +
            middleParagraphFull(args, 6) +
            "\n" +
            lastParagraph(args);

        System.out.println(song);
    }

    private static String firstParagraph(String[] args) {

        return INITIAL_PHRASE + args[0] + ".\n" +
            ANIMAL_PHRASES.get(args[0]) + "\n";
    }

    private static String middleParagraphFull(String[] args, int animals) {

        return INITIAL_PHRASE + args[animals-1] + ";\n" +
            ANIMAL_PHRASES.get(args[animals-1]) + "\n" +
            shallowedPhrases(args, animals) +
            ANIMAL_PHRASES.get(args[0]) + "\n";
    }

    private static String shallowedPhrases(String[] args, int animals) {
        String shallowedPhrases = "";
        for (int i = animals-1; i > 0; i--) {
            String lastSymbol = i == 1 ? ";" : ",";
            shallowedPhrases += "She swallowed the " + args[i] + " to catch the " + args[i-1] + lastSymbol + "\n";
        }
        return shallowedPhrases;
    }

    private static String lastParagraph(String[] args) {

        return INITIAL_PHRASE + args[args.length - 1] + "...\n" +
            "...She's dead, of course!";
    }
}
