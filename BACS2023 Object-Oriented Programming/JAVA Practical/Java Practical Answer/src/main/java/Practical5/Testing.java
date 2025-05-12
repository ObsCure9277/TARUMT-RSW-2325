/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practical5;

public class Testing {
     public static void main(String[] args) {
        
        if(args.length == 0){
            System.err.println("Invalid input.");
            System.exit(-1);
        }
        
        String fullName = "";
        String surname = "";
        String title = args[args.length-1];
        
        for(int i=0; i<args.length-1; i++){
            String temp = args[i].toLowerCase();
            
            if(temp.charAt(0) == '['){
                temp = temp.replaceAll("[\\[\\]]", "");
                surname = Character.toUpperCase(temp.charAt(0)) + temp.substring(1);
            }
            
            args[i] = Character.toUpperCase(temp.charAt(0)) + temp.substring(1);
            
            fullName += args[i] + " ";
            
            //System.out.println(args[i]);
        }
        System.out.println("To: " + fullName);
        System.out.println("Wishing you a Merry Christmas, " + title + " " + surname);
    }
}
