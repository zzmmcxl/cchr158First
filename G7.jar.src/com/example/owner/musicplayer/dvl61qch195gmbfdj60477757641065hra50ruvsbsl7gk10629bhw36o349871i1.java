package com.example.owner.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;

public class dvl61qch195gmbfdj60477757641065hra50ruvsbsl7gk10629bhw36o349871i1
  extends AppCompatActivity
{
  private static final String zpst39sqm4ha7520vguy868225l81hx9648363u43916751b7418kkokec5561y34y215 = "LogMessage";
  private Button bqo566i21yn229597xh142243z84vav755016f12w62lp2312899894m443975xl979v14y66;
  private ArrayAdapter<String> jsx6275zfts3139pq7036qmk4063544813c389889n36ld914323h5469kqsnbife99f378;
  private LinkedList<File> ohm14o33jt881079kza90772452080bkx62x47n28z96j4367qh97s4813n1942n3319672577;
  
  public void ngahghbevmwynrbxaibc()
  {
    Log.e("kvdfwtrpqqbyjxsshlwj", "dpslclilzvgrjttzkjlg");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Log.d("kbrzyyxtucvydnutqgso", "ieyzbeabvegeweaeqobe");
    Log.i("fcyvpkiekptedposzczt", "wgftetalnggjxsjrjcel");
    Log.v("nkuvefqgmfzmfhcjkplm", "gfkdkfnzmkmudggwvlbh");
    Log.v("cqnhclfgzosspeokykrs", "rpufwwgikepwkbwxfbsr");
    super.onCreate(paramBundle);
    setContentView(2130968601);
    paramBundle = (ListView)findViewById(2131492971);
    this.bqo566i21yn229597xh142243z84vav755016f12w62lp2312899894m443975xl979v14y66 = ((Button)findViewById(2131492969));
    this.bqo566i21yn229597xh142243z84vav755016f12w62lp2312899894m443975xl979v14y66.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(dvl61qch195gmbfdj60477757641065hra50ruvsbsl7gk10629bhw36o349871i1.this.getApplicationContext(), szr58w75mpfxi23wc7m10p75ym50j39o8912wlcfdba3967tng81l49314045510925.class);
        dvl61qch195gmbfdj60477757641065hra50ruvsbsl7gk10629bhw36o349871i1.this.startActivity(paramAnonymousView);
      }
    });
    this.ohm14o33jt881079kza90772452080bkx62x47n28z96j4367qh97s4813n1942n3319672577 = cft99u7331sz7371k2068241z83s5314943p69r99r6d20t3493cv491981p588269188814lb0.tec55ej48llvg134592362793309055a21dd44e93d566073b94nt90n91yu2141mc5l0a1().cdq4314w8rbq5e44716832221675489497f3462o42808827m5285330ffn20ho25612465l12240();
    Log.i("qjfwfpqfblthmeyqelus", "boxlgonawmxgrnzkwqiy");
    final ArrayList localArrayList = xyr334428s22g421979665b223620uz488a66bwh1375773373netvkiv96my19b32op514(Environment.getExternalStorageDirectory());
    final String[] arrayOfString = new String[localArrayList.size()];
    Log.d("vpxawnxwezlbygvnnhns", "oqwjoqkchhhsjpxwokqi");
    int i = 0;
    while (i < localArrayList.size())
    {
      arrayOfString[i] = ((File)localArrayList.get(i)).getName().toString().replace(".mp3", "").replace(".wav", "");
      i += 1;
    }
    this.jsx6275zfts3139pq7036qmk4063544813c389889n36ld914323h5469kqsnbife99f378 = new ArrayAdapter(getApplicationContext(), 2130968630, 2131493006, arrayOfString);
    paramBundle.setAdapter(this.jsx6275zfts3139pq7036qmk4063544813c389889n36ld914323h5469kqsnbife99f378);
    paramBundle.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        paramAnonymousAdapterView = (File)localArrayList.get(paramAnonymousInt);
        dvl61qch195gmbfdj60477757641065hra50ruvsbsl7gk10629bhw36o349871i1.this.ohm14o33jt881079kza90772452080bkx62x47n28z96j4367qh97s4813n1942n3319672577.addLast(paramAnonymousAdapterView);
        Log.i("LogMessage", "The size of the list is: " + dvl61qch195gmbfdj60477757641065hra50ruvsbsl7gk10629bhw36o349871i1.this.ohm14o33jt881079kza90772452080bkx62x47n28z96j4367qh97s4813n1942n3319672577.size());
        Toast.makeText(dvl61qch195gmbfdj60477757641065hra50ruvsbsl7gk10629bhw36o349871i1.this.getApplicationContext(), arrayOfString[paramAnonymousInt] + " IS ADDED TO THE QUEUE", 0).show();
      }
    });
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    Log.i("mntczltuvvjevhsnxulh", "akegspgpwfkkqudwrmxc");
    Log.i("pvjotwurknstkyhhobfk", "awzmxaglkqvistgjkdph");
    getMenuInflater().inflate(2131558400, paramMenu);
    Log.i("rctbpvcwybxyjvgkrtkm", "xfuezlsxxhgniyspkvbm");
    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int i = paramMenuItem.getItemId();
    Log.w("esdqmeyvxvgcajstmtyr", "vcfhuzdcenmymkjviruk");
    if (i == 2131493007) {
      return true;
    }
    Log.i("vjcppgikmbqeclayhxpa", "ffgqyimfeemhhxcexgrr");
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public ArrayList<File> xyr334428s22g421979665b223620uz488a66bwh1375773373netvkiv96my19b32op514(File paramFile)
  {
    ArrayList localArrayList = new ArrayList();
    paramFile = paramFile.listFiles();
    if (paramFile != null)
    {
      int j = paramFile.length;
      int i = 0;
      if (i < j)
      {
        File localFile = paramFile[i];
        if ((localFile.isDirectory()) && (!localFile.isHidden())) {
          localArrayList.addAll(xyr334428s22g421979665b223620uz488a66bwh1375773373netvkiv96my19b32op514(localFile));
        }
        for (;;)
        {
          i += 1;
          break;
          if ((localFile.getName().endsWith(".mp3")) || (localFile.getName().endsWith(".wav"))) {
            localArrayList.add(localFile);
          }
        }
      }
    }
    return localArrayList;
  }
}


/* Location:              C:\Users\colin\Documents\GitHub\cchr158First\G7.jar!\com\example\owner\musicplayer\dvl61qch195gmbfdj60477757641065hra50ruvsbsl7gk10629bhw36o349871i1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */