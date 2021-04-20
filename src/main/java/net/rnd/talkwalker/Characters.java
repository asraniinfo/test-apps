package net.rnd.talkwalker;

import java.util.Arrays;

public class Characters {

    public static void main(String[] ar){

        System.out.println("a   B c  d ankit Ag   ".chars().filter(Character::isWhitespace).count());
        Arrays.stream("a  B c   d ankit Ag   ".split(" ")).forEach(System.out::println);
        System.out.println("a   B c  d ankit Ag   ".split(" ").length);

        System.out.println("a\n\nB\nc\n\nd\nankit\nAg\n\n\nA".chars().filter(value -> '\n'==value).count());
    }
}
