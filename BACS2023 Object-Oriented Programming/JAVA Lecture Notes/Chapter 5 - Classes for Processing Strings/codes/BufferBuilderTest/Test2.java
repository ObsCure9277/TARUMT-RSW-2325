
public class Test2 extends Thread {
    static StringBuilder s = new StringBuilder();
    // static StringBuffer s = new StringBuffer();

   public void run() 
    { 
        try
        { 
                
           for(int i=0; i<10; i++){
               s.append(Thread.currentThread().getId()+ " ");
               Thread.sleep(1);
           }
 
        } 
        catch (Exception e) 
        { 
            // Throwing an exception 
            System.out.println ("Exception is caught"); 
        } 
    } 
  
   public static void main(String[] args) 
   { 
        Test2 t1 = new Test2();
        Test2 t2 = new Test2();
       
        
        t1.start();
        t2.start();
          
        try{
            
            Thread.sleep(100);
            System.out.println(s);
            
        }catch(Exception ex){
            
        }
   } 
}