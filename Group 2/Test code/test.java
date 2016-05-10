import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;  
public class test{
  innerClass ic;
  public static void main(String[] args){
    new test();
  }
  
  
  
  test(){
    ic = new innerClass();
    //System.out.println(innerClass.add());
    try{
      //System.out.println(innerClass.class.getName());
      Method m = Class.forName(ic.getClass().getName()).getDeclaredMethod("add",new Class[]{Integer.class,Integer.class});
      m.setAccessible(true);
      System.out.println(m.invoke(ic,new Object[]{1,2}));
      Class<?> c = Class.forName(innerClass.class.getName());
      Method[] temp = Class.forName(innerClass.class.getName()).getDeclaredMethods();
      for(int i=0; i< temp.length;i++){
        System.out.println(temp[i].getName());
      }
      Method m2 = c.getDeclaredMethod(temp[0].getName(),new Class[0]);
      
      System.out.println(m2.invoke(null,new Object[0]));
      //System.out.println(RefInvoke.invokeStaticMethod(innerClass.class.getName(),"add",new Class[0],new Object[0]));
      Field f = Class.forName(ic.getClass().getName()).getDeclaredField("str");
      f.setAccessible(true);
      
      System.out.println(f.get(ic));
    }catch(Exception e){
      System.err.println(e);
    }
  }
}

class innerClass{
    private static int a=2;
    private static int b=5;
    private String str;
    
    innerClass(){
      this.a=1;
      this.b=3;
      this.str = "Hello world.";
    }
    private int add(java.lang.Integer i, java.lang.Integer j){
      return i+j;
    }
    static int add(){
      return a+b;
    }
  }
