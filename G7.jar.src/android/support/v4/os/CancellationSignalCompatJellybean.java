package android.support.v4.os;

import android.os.CancellationSignal;

class CancellationSignalCompatJellybean
{
  public static void cancel(Object paramObject)
  {
    ((CancellationSignal)paramObject).cancel();
  }
  
  public static Object create()
  {
    return new CancellationSignal();
  }
}


/* Location:              C:\Users\colin\Documents\GitHub\cchr158First\G7.jar!\android\support\v4\os\CancellationSignalCompatJellybean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */