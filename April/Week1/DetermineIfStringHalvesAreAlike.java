public class DetermineIfStringHalvesAreAlike {
    public static void main(String[] args){
        String s = "book";
        System.out.println(halvesAreAlike(s));
    }

    public static boolean halvesAreAlike(String s) {
        int length = s.length() / 2;
        String a = s.substring(0, length).toLowerCase();
        String b = s.substring(length).toLowerCase();

        System.out.println(a.length() + " " + b.length());
        int vowelOfA = 0, vowelOfB = 0;
        for(int i = 0; i < length; i ++){
            char chOfA = a.charAt(i);
            char chOfB = b.charAt(i);
            if(chOfA == 'a' || chOfA == 'e' || chOfA == 'i' || chOfA == 'o' || chOfA == 'u'){
                vowelOfA ++;
            }
            if(chOfB == 'a' || chOfB == 'e' || chOfB == 'i' || chOfB == 'o' || chOfB == 'u'){
                vowelOfB ++;
            }
        }
        return vowelOfA == vowelOfB;
    }
}