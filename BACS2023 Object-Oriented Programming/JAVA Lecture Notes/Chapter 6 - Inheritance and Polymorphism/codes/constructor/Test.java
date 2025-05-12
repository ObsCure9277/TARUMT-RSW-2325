
class A{
  private int dataA;
  
  public A(){
  
  }
  
  public A(int d){
  	this.dataA =d;
  }	
  

}

//--------

class B extends A{
	private int dataB;
	
	public B(int d){
		this.dataB =d;
	}
}

//-------



public class Test {
    public static void main(String[] args) {
       B b = new B(10);
       
    }
}
