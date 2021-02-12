package com.kata;

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
        StringBuilder builder = new StringBuilder();

        builder.append(firstParagraph(args)).append("\n");
        for (int i = 1; i < args.length-1; i ++) {
            builder.append(middleParagraphFull(args, i)).append("\n");
        }
        builder.append(lastParagraph(args));

        System.out.println(builder.toString());
    }

    private static String firstParagraph(String[] args) {

        return INITIAL_PHRASE + args[INITIAL_POSITION_LIST] + ".\n" +
            ANIMAL_PHRASES.get(args[INITIAL_POSITION_LIST]) + "\n";
    }

    private static String middleParagraphFull(String[] args, int animals) {

        return INITIAL_PHRASE + args[animals] + ";\n" +
            ANIMAL_PHRASES.get(args[animals]) + "\n" +
            shallowedPhrases(args, animals) +
            ANIMAL_PHRASES.get(args[INITIAL_POSITION_LIST]) + "\n";
    }

    private static String shallowedPhrases(String[] args, int animals) {
        StringBuilder shallowedPhrasesBuilder = new StringBuilder("");
        for (int i = animals; i > INITIAL_POSITION_LIST; i--) {
            String lastSymbol = i == 1 ? ";" : ",";
            shallowedPhrasesBuilder
                    .append("She swallowed the ")
                    .append(args[i]).append(" to catch the ")
                    .append(args[i-1])
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
