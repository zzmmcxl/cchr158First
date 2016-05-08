package com.example.owner.musicplayer;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import com.example.owner.musicplayer.dvl61qch195gmbfdj60477757641065hra50ruvsbsl7gk10629bhw36o349871i1;
import java.io.File;
import java.util.ArrayList;

class dvl61qch195gmbfdj60477757641065hra50ruvsbsl7gk10629bhw36o349871i1$2 implements OnItemClickListener {
   dvl61qch195gmbfdj60477757641065hra50ruvsbsl7gk10629bhw36o349871i1$2(dvl61qch195gmbfdj60477757641065hra50ruvsbsl7gk10629bhw36o349871i1 var1, ArrayList var2, String[] var3) {
      this.this$0 = var1;
      this.val$bpw62lwb43ws48d18t2955eou49p3219b71x5263ruq84h91shrd28ul923764d91h15 = var2;
      this.val$jlzwksqd91d69g8110ry29qm83s20izlz15239172997ciaii73zfklttn9r2311 = var3;
   }

   public void onItemClick(AdapterView<?> var1, View var2, int var3, long var4) {
      File var6 = (File)this.val$bpw62lwb43ws48d18t2955eou49p3219b71x5263ruq84h91shrd28ul923764d91h15.get(var3);
      dvl61qch195gmbfdj60477757641065hra50ruvsbsl7gk10629bhw36o349871i1.access$000(this.this$0).addLast(var6);
      Log.i("LogMessage", "The size of the list is: " + dvl61qch195gmbfdj60477757641065hra50ruvsbsl7gk10629bhw36o349871i1.access$000(this.this$0).size());
      Toast.makeText(this.this$0.getApplicationContext(), this.val$jlzwksqd91d69g8110ry29qm83s20izlz15239172997ciaii73zfklttn9r2311[var3] + " IS ADDED TO THE QUEUE", 0).show();
   }
}
