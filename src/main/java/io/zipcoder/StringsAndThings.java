package io.zipcoder;


/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input){
       int endYOrZ = 0;
        String words[] = input.split(" ");
        for(int i = 0; i < words.length; i++){
            int lastChar = words[i].length()-1;
            if((words[i].charAt(lastChar) == 89) | (words[i].charAt(lastChar) == 90) | (words[i].charAt(lastChar) == 121) | (words[i].charAt(lastChar) == 122)){
                endYOrZ++;
            }
        }


        return endYOrZ;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove){
        String newStr = base.replaceAll(remove, "");
        return newStr;
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input){
        int isCounter = 0;
        int notCounter = 0;
        boolean result;
        input = input.toUpperCase();

        while(input.contains("IS")){
            input = input.replaceFirst("IS", Integer.toString(isCounter++));
        }
        while(input.contains("NOT")){
            input = input.replaceFirst("NOT", Integer.toString(notCounter++));
        }
        if(isCounter == notCounter) {
            result = true;
        }
        else{
            result = false;
        }
        return result;
    }

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input){
        boolean result = true;

        input = input.toLowerCase();

        char[] ch = new char[input.length()];
        for(int i = 0; i < input.length(); i++){
            ch[i] = input.charAt(i);
        }

        for(int i = 1; i < ch.length; i++) {
            if(ch[i] == 103){
                if (ch[i - 1] != 103) {
                    result = false;
                }
            }

        }

        return result;
    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input){
        char check;
        int counter = 0;
        input = input.toLowerCase();

        char [] ch = input.toCharArray();

        for (int i = 0; i < ch.length - 1; i++) {
            check = ch[i];
            if (ch[i] == check) {
                if (ch[i] == check  && ch[i + 1] == check && ch[i + 2] == check) {
                    counter++;
                }
            }
        }


        return counter;
    }
}
