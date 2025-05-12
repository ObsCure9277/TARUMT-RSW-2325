
public class CheckPalindrome {

    public static void main(String[] args) {
        String str = "madam";
        boolean result = isPalindrome(str);
        System.out.println("Result : " + result);
    }
    
    public static boolean isPalindrome(String str){
        
        for(int i=0; i<str.length()/2; i++){
            char left = str.charAt(i);
            char right = str.charAt(str.length()-1-i);
            if (left!=right){
                return false;
            }
        }
        
        return true;
    }

    
}
