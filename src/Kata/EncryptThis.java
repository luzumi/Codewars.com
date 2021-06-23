package Kata;

public class EncryptThis {
    public static String encryptThis(String text) {
        if(text.length() == 0) return "";
        if(text.length() == 1) return String.valueOf(Integer.decode(text));

        String[] wordList = text.split(" ");
        String result = "";
        for ( String word : wordList ) {
            char[] wordArr = word.toCharArray();
            int first = wordArr[0];
            String second = "", last = "";
            String body = "";

            if(word.length() > 1) {
                second = String.valueOf(wordArr[1]);

                if(word.length() > 2){
                    last = String.valueOf(wordArr[wordArr.length-1]);
                }
                if(word.length() > 3){
                    body = word.substring(2,wordArr.length-1);
                }
            }


            result += ("" + first + last + body + second).trim() + " ";
        }

        return result.trim();
    }
}
