package com.kata;

import java.util.List;
import java.util.Map;

class Song {

    private static final int INITIAL_POSITION_LIST = 0;

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

        System.out.println(buildSong(args, List.of(args)));

    }

    private static String buildSong(String[] args, List<String> animals) {
        StringBuilder builder = new StringBuilder();
        builder.append(firstParagraph(animals)).append("\n");
        for (int i = 1; i < args.length-1; i ++) {
            builder.append(middleParagraphFull(animals, i)).append("\n");
        }
        builder.append(lastParagraph(args));
        return builder.toString();
    }

    private static String firstParagraph(List<String> animals) {

        return INITIAL_PHRASE + animals.get(INITIAL_POSITION_LIST) + ".\n" +
            ANIMAL_PHRASES.get(animals.get(INITIAL_POSITION_LIST)) + "\n";
    }

    private static String middleParagraphFull(List<String> animals, int animalPosition) {

        return INITIAL_PHRASE + animals.get(animalPosition) + ";\n" +
            ANIMAL_PHRASES.get(animals.get(animalPosition)) + "\n" +
            shallowedPhrases(animals, animalPosition) +
            ANIMAL_PHRASES.get(animals.get(INITIAL_POSITION_LIST)) + "\n";
    }

    private static String shallowedPhrases(List<String> animals, int animalPosition) {
        StringBuilder shallowedPhrasesBuilder = new StringBuilder("");
        for (int i = animalPosition; i > INITIAL_POSITION_LIST; i--) {
            String lastSymbol = i == 1 ? ";" : ",";
            shallowedPhrasesBuilder
                    .append("She swallowed the ")
                    .append(animals.get(i))
                    .append(" to catch the ")
                    .append(animals.get(i-1))
                    .append(lastSymbol)
                    .append("\n");
        }
        return shallowedPhrasesBuilder.toString();
    }

    private static String lastParagraph(String[] args) {

        return INITIAL_PHRASE + args[args.length - 1] + "...\n" +
            "...She's dead, of course!";
    }
}
