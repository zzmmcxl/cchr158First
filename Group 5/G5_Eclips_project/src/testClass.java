
public class testClass{
  static int a;
  static int b;
  static {
    a=3;
    b=5;
  }
  public static void main(String[] args){
    testClass t = new testClass();
    System.out.println(t.a+" "+t.b);
    
  }
}