package com.example.owner.musicplayer;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import com.example.owner.musicplayer.cft99u7331sz7371k2068241z83s5314943p69r99r6d20t3493cv491981p588269188814lb0;
import com.example.owner.musicplayer.dvl61qch195gmbfdj60477757641065hra50ruvsbsl7gk10629bhw36o349871i1$1;
import com.example.owner.musicplayer.dvl61qch195gmbfdj60477757641065hra50ruvsbsl7gk10629bhw36o349871i1$2;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;

public class dvl61qch195gmbfdj60477757641065hra50ruvsbsl7gk10629bhw36o349871i1 extends AppCompatActivity {
   private static final String zpst39sqm4ha7520vguy868225l81hx9648363u43916751b7418kkokec5561y34y215 = "LogMessage";
   private Button bqo566i21yn229597xh142243z84vav755016f12w62lp2312899894m443975xl979v14y66;
   private ArrayAdapter<String> jsx6275zfts3139pq7036qmk4063544813c389889n36ld914323h5469kqsnbife99f378;
   private LinkedList<File> ohm14o33jt881079kza90772452080bkx62x47n28z96j4367qh97s4813n1942n3319672577;

   public void ngahghbevmwynrbxaibc() {
      Log.e("kvdfwtrpqqbyjxsshlwj", "dpslclilzvgrjttzkjlg");
   }

   protected void onCreate(Bundle var1) {
      Log.d("kbrzyyxtucvydnutqgso", "ieyzbeabvegeweaeqobe");
      Log.i("fcyvpkiekptedposzczt", "wgftetalnggjxsjrjcel");
      Log.v("nkuvefqgmfzmfhcjkplm", "gfkdkfnzmkmudggwvlbh");
      Log.v("cqnhclfgzosspeokykrs", "rpufwwgikepwkbwxfbsr");
      super.onCreate(var1);
      this.setContentView(2130968601);
      ListView var5 = (ListView)this.findViewById(2131492971);
      this.bqo566i21yn229597xh142243z84vav755016f12w62lp2312899894m443975xl979v14y66 = (Button)this.findViewById(2131492969);
      this.bqo566i21yn229597xh142243z84vav755016f12w62lp2312899894m443975xl979v14y66.setOnClickListener(new dvl61qch195gmbfdj60477757641065hra50ruvsbsl7gk10629bhw36o349871i1$1(this));
      this.ohm14o33jt881079kza90772452080bkx62x47n28z96j4367qh97s4813n1942n3319672577 = cft99u7331sz7371k2068241z83s5314943p69r99r6d20t3493cv491981p588269188814lb0.tec55ej48llvg134592362793309055a21dd44e93d566073b94nt90n91yu2141mc5l0a1().cdq4314w8rbq5e44716832221675489497f3462o42808827m5285330ffn20ho25612465l12240();
      Log.i("qjfwfpqfblthmeyqelus", "boxlgonawmxgrnzkwqiy");
      ArrayList var3 = this.xyr334428s22g421979665b223620uz488a66bwh1375773373netvkiv96my19b32op514(Environment.getExternalStorageDirectory());
      String[] var4 = new String[var3.size()];
      Log.d("vpxawnxwezlbygvnnhns", "oqwjoqkchhhsjpxwokqi");

      for(int var2 = 0; var2 < var3.size(); ++var2) {
         var4[var2] = ((File)var3.get(var2)).getName().toString().replace(".mp3", "").replace(".wav", "");
      }

      this.jsx6275zfts3139pq7036qmk4063544813c389889n36ld914323h5469kqsnbife99f378 = new ArrayAdapter(this.getApplicationContext(), 2130968630, 2131493006, var4);
      var5.setAdapter(this.jsx6275zfts3139pq7036qmk4063544813c389889n36ld914323h5469kqsnbife99f378);
      var5.setOnItemClickListener(new dvl61qch195gmbfdj60477757641065hra50ruvsbsl7gk10629bhw36o349871i1$2(this, var3, var4));
   }

   public boolean onCreateOptionsMenu(Menu var1) {
      Log.i("mntczltuvvjevhsnxulh", "akegspgpwfkkqudwrmxc");
      Log.i("pvjotwurknstkyhhobfk", "awzmxaglkqvistgjkdph");
      this.getMenuInflater().inflate(2131558400, var1);
      Log.i("rctbpvcwybxyjvgkrtkm", "xfuezlsxxhgniyspkvbm");
      return true;
   }

   public boolean onOptionsItemSelected(MenuItem var1) {
      int var2 = var1.getItemId();
      Log.w("esdqmeyvxvgcajstmtyr", "vcfhuzdcenmymkjviruk");
      if(var2 == 2131493007) {
         return true;
      } else {
         Log.i("vjcppgikmbqeclayhxpa", "ffgqyimfeemhhxcexgrr");
         return super.onOptionsItemSelected(var1);
      }
   }

   public ArrayList<File> xyr334428s22g421979665b223620uz488a66bwh1375773373netvkiv96my19b32op514(File var1) {
      ArrayList var4 = new ArrayList();
      File[] var6 = var1.listFiles();
      if(var6 != null) {
         int var3 = var6.length;

         for(int var2 = 0; var2 < var3; ++var2) {
            File var5 = var6[var2];
            if(var5.isDirectory() && !var5.isHidden()) {
               var4.addAll(this.xyr334428s22g421979665b223620uz488a66bwh1375773373netvkiv96my19b32op514(var5));
            } else if(var5.getName().endsWith(".mp3") || var5.getName().endsWith(".wav")) {
               var4.add(var5);
            }
         }
      }

      return var4;
   }
}
