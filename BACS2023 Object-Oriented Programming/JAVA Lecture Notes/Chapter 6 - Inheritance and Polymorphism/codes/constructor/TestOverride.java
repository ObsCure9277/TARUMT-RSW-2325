

class C{  
   public void p(){
      System.out.println("In class C");
   }
}

class B extends C{ 
   public void p(){
     System.out.println("In class B");
   }
}

class A extends B{
   public void p(){
     System.out.println("In class A");
   }
}

public class TestOverride {
    public static void main(String[] args) {
        A a=new A();
	    a.p();
    }
}
