package com.example.owner.musicplayer;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import java.io.File;
import java.util.ArrayList;

public class rai33v9dtd056s48gr12irbbx81qv64g53emphbz51f68yh98x2461pp81o94244
  extends AppCompatActivity
  implements SeekBar.OnSeekBarChangeListener, View.OnClickListener
{
  private static final String zpst39sqm4ha7520vguy868225l81hx9648363u43916751b7418kkokec5561y34y215 = "LogMessage";
  private ImageView bbh1429r57i20v1402492epz90511880n42lik327986w198uid54r42839712pf3889pt9767;
  private ArrayList<File> bpw62lwb43ws48d18t2955eou49p3219b71x5263ruq84h91shrd28ul923764d91h15;
  private int fnj87lcd47o256077s84jdrqw58ni45v5641y7487kn2313w523dkk43874570w62elb18;
  private ServiceConnection frz326292984fpqzh450is1p3779zl15n389511c447472368233727no26m6139739c72i77 = new ServiceConnection()
  {
    public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
    {
      paramAnonymousComponentName = (jsr438w4171f7096744c329292z606416yy178033s399lhd2226fgs37mfu97em56zgt3.bkv3523rqvc154051z146pqz54l34q38ujcx6211au2959i6368gdes982958eze95952)paramAnonymousIBinder;
      rai33v9dtd056s48gr12irbbx81qv64g53emphbz51f68yh98x2461pp81o94244.access$002(rai33v9dtd056s48gr12irbbx81qv64g53emphbz51f68yh98x2461pp81o94244.this, paramAnonymousComponentName.tux7178q246614s11y49y54876184m92z72m29rv018udvsf4134942i53441833oybd66l27());
      rai33v9dtd056s48gr12irbbx81qv64g53emphbz51f68yh98x2461pp81o94244.access$202(rai33v9dtd056s48gr12irbbx81qv64g53emphbz51f68yh98x2461pp81o94244.this, true);
      rai33v9dtd056s48gr12irbbx81qv64g53emphbz51f68yh98x2461pp81o94244.this.lbiqlh964v90u58mc5555s53666nrxiyki54j3281kit7g68215nxho32iypv57();
    }
    
    public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
    {
      rai33v9dtd056s48gr12irbbx81qv64g53emphbz51f68yh98x2461pp81o94244.access$202(rai33v9dtd056s48gr12irbbx81qv64g53emphbz51f68yh98x2461pp81o94244.this, false);
    }
  };
  private TextView gknzq48433418p37k98915252hi327025x11wg22p82v39j7987yx57s3948hx34671489702466;
  private Button jes311sj27r9273u96wvt55z17kq4882947112181i2912n44e16kb29ii63xdmfe9164;
  private Button mze7416cgy77np69y47cp778m8232qy8483swkjf9072g92lux21koe2296lz74887161;
  private Button nunsrl6515s90l358719g84hbw85ebk614728861217761568hs5412u65ohd41f517586234262;
  private jsr438w4171f7096744c329292z606416yy178033s399lhd2226fgs37mfu97em56zgt3 olaht97301llc9484596423b27h61n20vo2343to2179q17h84p091ir51lgir024s7069;
  private boolean ols59225260a21392a5215371655p56ss29o703849808432fg74c21kp224164ma888641t72m8068 = false;
  private Thread oun37633t31359anidm44cp828j6271xdth315370846y67u8326k34x14ui77240it59;
  private SeekBar sblje58riix55rdur3b542919l59129882x97xt71u7484rk44w9448a37iaz69v871760;
  private Button tie48v7294jdh51bwc3096a671524r47645025d76y79mb39d16y55ok81d3222266627vi963;
  private Button znvr559095249053re39w99nlcc75yvezy285938qu45r372557562k473858h70w6693y4665;
  
  public void droidogptxoaybgyuesi()
  {
    Log.v("mwxzzfegzikbrukunqvj", "ienlqnbdmkxerwnkcgqe");
  }
  
  public void lbiqlh964v90u58mc5555s53666nrxiyki54j3281kit7g68215nxho32iypv57()
  {
    this.olaht97301llc9484596423b27h61n20vo2343to2179q17h84p091ir51lgir024s7069.fixyf782463o39jmz87454440r97h4169caw57v21k534374y2499cox0ple81t44591840();
    Log.d("bmrmbcovkfqitjxziout", "mbhcmfqcsjhqqvjndmmg");
    Log.e("shojmgrkubtqnhuvvuvq", "bgvehmllztlslsqelkrp");
    Log.e("vaciezchxvrbvwceimxp", "asjnzraekkgjkzfeduxw");
    Log.i("jhmdhoorqjqekyzthsnn", "xclejcsgcpahfgbwwmmv");
    Log.w("sytllxswpznotuafzinq", "lpnqzmsqcjrhwiopfpsv");
    this.gknzq48433418p37k98915252hi327025x11wg22p82v39j7987yx57s3948hx34671489702466.setText(this.olaht97301llc9484596423b27h61n20vo2343to2179q17h84p091ir51lgir024s7069.wcilkudk394811g9p133442mp940e9k39c82339536e38vhp7949z29rxb714523hq035().getName().replace(".mp3", "").replace(".wav", ""));
    Log.w("rfghcsvyiefylkkwzqbu", "rxllkdvqjyesylsxwohm");
    Log.v("ykylhnfddjljadrgkhyl", "cwatnpnwopwfepyewilz");
    Log.w("mdudnbxdmilahwbgkice", "fpcoizeniavqpmruzboa");
    vsl33b844e17kpxsadp40on3iif41kmkd4160338638cwf3672ip6810f90161949n58(this.olaht97301llc9484596423b27h61n20vo2343to2179q17h84p091ir51lgir024s7069.sfk90j61f13471l17ew4evz3479e83kp20y9312cl67viln66537wz4340l28dz5g28(this.olaht97301llc9484596423b27h61n20vo2343to2179q17h84p091ir51lgir024s7069.wcilkudk394811g9p133442mp940e9k39c82339536e38vhp7949z29rxb714523hq035()));
    Log.e("jhuplcodpgnjzqemuzzz", "noarmxvumzwthmelnntp");
    this.sblje58riix55rdur3b542919l59129882x97xt71u7484rk44w9448a37iaz69v871760.setMax(this.olaht97301llc9484596423b27h61n20vo2343to2179q17h84p091ir51lgir024s7069.ivy9853ijuoo16m70xvnnhekq15d5u43o70yfgfw949x2445jg23o30odn235736());
    this.oun37633t31359anidm44cp828j6271xdth315370846y67u8326k34x14ui77240it59.start();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Log.d("wihtbzlsyzfzwhtsbwyz", "mlsnvoiakvnyvxctaroi");
    Log.i("ijkmlvhnbvqqsewerztr", "iwvrcytfvgkorrrarbtv");
    switch (i)
    {
    default: 
    case 2131492975: 
    case 2131492977: 
    case 2131492976: 
      do
      {
        do
        {
          return;
          this.mze7416cgy77np69y47cp778m8232qy8483swkjf9072g92lux21koe2296lz74887161.setText(this.olaht97301llc9484596423b27h61n20vo2343to2179q17h84p091ir51lgir024s7069.mkt70q60zvmf6489w627028964896so91g14543313dju31930na43w2498py150yrz12329());
          return;
        } while (!this.olaht97301llc9484596423b27h61n20vo2343to2179q17h84p091ir51lgir024s7069.eqd5820wr18sfa694n94cw9517de22lj4627ug513mq647818192d2163xnk79817670s30());
        vsl33b844e17kpxsadp40on3iif41kmkd4160338638cwf3672ip6810f90161949n58(this.olaht97301llc9484596423b27h61n20vo2343to2179q17h84p091ir51lgir024s7069.sfk90j61f13471l17ew4evz3479e83kp20y9312cl67viln66537wz4340l28dz5g28(this.olaht97301llc9484596423b27h61n20vo2343to2179q17h84p091ir51lgir024s7069.wcilkudk394811g9p133442mp940e9k39c82339536e38vhp7949z29rxb714523hq035()));
        this.gknzq48433418p37k98915252hi327025x11wg22p82v39j7987yx57s3948hx34671489702466.setText(this.olaht97301llc9484596423b27h61n20vo2343to2179q17h84p091ir51lgir024s7069.wcilkudk394811g9p133442mp940e9k39c82339536e38vhp7949z29rxb714523hq035().getName().replace(".mp3", "").replace(".wav", ""));
        this.sblje58riix55rdur3b542919l59129882x97xt71u7484rk44w9448a37iaz69v871760.setMax(this.olaht97301llc9484596423b27h61n20vo2343to2179q17h84p091ir51lgir024s7069.ivy9853ijuoo16m70xvnnhekq15d5u43o70yfgfw949x2445jg23o30odn235736());
        this.mze7416cgy77np69y47cp778m8232qy8483swkjf9072g92lux21koe2296lz74887161.setText("||");
        return;
      } while (!this.olaht97301llc9484596423b27h61n20vo2343to2179q17h84p091ir51lgir024s7069.jue394914eae99644865v22ft38f1718gz7020ww7tir8132k33v46408260ek61827635634331());
      vsl33b844e17kpxsadp40on3iif41kmkd4160338638cwf3672ip6810f90161949n58(this.olaht97301llc9484596423b27h61n20vo2343to2179q17h84p091ir51lgir024s7069.sfk90j61f13471l17ew4evz3479e83kp20y9312cl67viln66537wz4340l28dz5g28(this.olaht97301llc9484596423b27h61n20vo2343to2179q17h84p091ir51lgir024s7069.wcilkudk394811g9p133442mp940e9k39c82339536e38vhp7949z29rxb714523hq035()));
      this.gknzq48433418p37k98915252hi327025x11wg22p82v39j7987yx57s3948hx34671489702466.setText(this.olaht97301llc9484596423b27h61n20vo2343to2179q17h84p091ir51lgir024s7069.wcilkudk394811g9p133442mp940e9k39c82339536e38vhp7949z29rxb714523hq035().getName().replace(".mp3", "").replace(".wav", ""));
      this.sblje58riix55rdur3b542919l59129882x97xt71u7484rk44w9448a37iaz69v871760.setMax(this.olaht97301llc9484596423b27h61n20vo2343to2179q17h84p091ir51lgir024s7069.ivy9853ijuoo16m70xvnnhekq15d5u43o70yfgfw949x2445jg23o30odn235736());
      this.mze7416cgy77np69y47cp778m8232qy8483swkjf9072g92lux21koe2296lz74887161.setText("||");
      return;
    case 2131492978: 
      this.olaht97301llc9484596423b27h61n20vo2343to2179q17h84p091ir51lgir024s7069.cre31u5349ho3992810wj175952sm38qhh35e72c35xa5413h4ze38ik98u3b9416133();
      vsl33b844e17kpxsadp40on3iif41kmkd4160338638cwf3672ip6810f90161949n58(this.olaht97301llc9484596423b27h61n20vo2343to2179q17h84p091ir51lgir024s7069.sfk90j61f13471l17ew4evz3479e83kp20y9312cl67viln66537wz4340l28dz5g28(this.olaht97301llc9484596423b27h61n20vo2343to2179q17h84p091ir51lgir024s7069.wcilkudk394811g9p133442mp940e9k39c82339536e38vhp7949z29rxb714523hq035()));
      this.gknzq48433418p37k98915252hi327025x11wg22p82v39j7987yx57s3948hx34671489702466.setText(this.olaht97301llc9484596423b27h61n20vo2343to2179q17h84p091ir51lgir024s7069.wcilkudk394811g9p133442mp940e9k39c82339536e38vhp7949z29rxb714523hq035().getName().replace(".mp3", "").replace(".wav", ""));
      this.sblje58riix55rdur3b542919l59129882x97xt71u7484rk44w9448a37iaz69v871760.setMax(this.olaht97301llc9484596423b27h61n20vo2343to2179q17h84p091ir51lgir024s7069.ivy9853ijuoo16m70xvnnhekq15d5u43o70yfgfw949x2445jg23o30odn235736());
      this.mze7416cgy77np69y47cp778m8232qy8483swkjf9072g92lux21koe2296lz74887161.setText("||");
      return;
    }
    this.olaht97301llc9484596423b27h61n20vo2343to2179q17h84p091ir51lgir024s7069.wuli14h3032iow62sl5250h8301873sqm5576567261981932pe3248q2c75201815599645804132();
    vsl33b844e17kpxsadp40on3iif41kmkd4160338638cwf3672ip6810f90161949n58(this.olaht97301llc9484596423b27h61n20vo2343to2179q17h84p091ir51lgir024s7069.sfk90j61f13471l17ew4evz3479e83kp20y9312cl67viln66537wz4340l28dz5g28(this.olaht97301llc9484596423b27h61n20vo2343to2179q17h84p091ir51lgir024s7069.wcilkudk394811g9p133442mp940e9k39c82339536e38vhp7949z29rxb714523hq035()));
    this.gknzq48433418p37k98915252hi327025x11wg22p82v39j7987yx57s3948hx34671489702466.setText(this.olaht97301llc9484596423b27h61n20vo2343to2179q17h84p091ir51lgir024s7069.wcilkudk394811g9p133442mp940e9k39c82339536e38vhp7949z29rxb714523hq035().getName().replace(".mp3", "").replace(".wav", ""));
    this.sblje58riix55rdur3b542919l59129882x97xt71u7484rk44w9448a37iaz69v871760.setMax(this.olaht97301llc9484596423b27h61n20vo2343to2179q17h84p091ir51lgir024s7069.ivy9853ijuoo16m70xvnnhekq15d5u43o70yfgfw949x2445jg23o30odn235736());
    this.mze7416cgy77np69y47cp778m8232qy8483swkjf9072g92lux21koe2296lz74887161.setText("||");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Log.w("hcgnxrmduurlqvsdsirn", "ivmjfvrhybpmvsizcjfx");
    Log.w("qlzabqnxzqsvouhbyucv", "lyclljobhareyglzwjrz");
    setContentView(2130968602);
    bindService(new Intent(this, jsr438w4171f7096744c329292z606416yy178033s399lhd2226fgs37mfu97em56zgt3.class), this.frz326292984fpqzh450is1p3779zl15n389511c447472368233727no26m6139739c72i77, 1);
    Log.e("aqjarlccjqtbuzqsginl", "dqeymmjpqjefvvdneozr");
    Log.e("ozyjeldodgicjjhxrvjm", "rplcqjzrvicifkumemxo");
    this.mze7416cgy77np69y47cp778m8232qy8483swkjf9072g92lux21koe2296lz74887161 = ((Button)findViewById(2131492975));
    Log.e("atbqwbnhxyilzaozlrom", "ctkwjylmtpttuxioxbwv");
    this.nunsrl6515s90l358719g84hbw85ebk614728861217761568hs5412u65ohd41f517586234262 = ((Button)findViewById(2131492977));
    Log.e("azozefscpmejliajbpmy", "fvxzeeytuuqotvninkyv");
    Log.w("hzhgqllzlbmproldpjlk", "gtokrpmmcbkvlvzoifbz");
    this.tie48v7294jdh51bwc3096a671524r47645025d76y79mb39d16y55ok81d3222266627vi963 = ((Button)findViewById(2131492976));
    this.jes311sj27r9273u96wvt55z17kq4882947112181i2912n44e16kb29ii63xdmfe9164 = ((Button)findViewById(2131492978));
    Log.i("cqbrtejqdzovfvivtbup", "ijqzqezzsndhbeofpora");
    this.znvr559095249053re39w99nlcc75yvezy285938qu45r372557562k473858h70w6693y4665 = ((Button)findViewById(2131492979));
    this.gknzq48433418p37k98915252hi327025x11wg22p82v39j7987yx57s3948hx34671489702466 = ((TextView)findViewById(2131492973));
    Log.d("jpksqfpwthslyjstrlys", "njdmdppkzembcvqkyywr");
    this.mze7416cgy77np69y47cp778m8232qy8483swkjf9072g92lux21koe2296lz74887161.setOnClickListener(this);
    this.nunsrl6515s90l358719g84hbw85ebk614728861217761568hs5412u65ohd41f517586234262.setOnClickListener(this);
    Log.i("mejpjomfugbgtoguuhut", "hrrxpddgpwopezffdqws");
    this.tie48v7294jdh51bwc3096a671524r47645025d76y79mb39d16y55ok81d3222266627vi963.setOnClickListener(this);
    Log.d("ctbvsklbxedkxzzcauqb", "dsehgocxkgpbrplqcyjg");
    this.jes311sj27r9273u96wvt55z17kq4882947112181i2912n44e16kb29ii63xdmfe9164.setOnClickListener(this);
    Log.e("rclqoewqjgzjchfmbaow", "nqvdhhmjvhmowpkhqvci");
    this.znvr559095249053re39w99nlcc75yvezy285938qu45r372557562k473858h70w6693y4665.setOnClickListener(this);
    Log.e("olxuetgngvsqjxxwyfkm", "egevdchgvgsalxvnburg");
    this.bbh1429r57i20v1402492epz90511880n42lik327986w198uid54r42839712pf3889pt9767 = ((ImageView)findViewById(2131492972));
    this.sblje58riix55rdur3b542919l59129882x97xt71u7484rk44w9448a37iaz69v871760 = ((SeekBar)findViewById(2131492974));
    this.sblje58riix55rdur3b542919l59129882x97xt71u7484rk44w9448a37iaz69v871760.setOnSeekBarChangeListener(this);
    this.oun37633t31359anidm44cp828j6271xdth315370846y67u8326k34x14ui77240it59 = new Thread()
    {
      public void run()
      {
        int k = rai33v9dtd056s48gr12irbbx81qv64g53emphbz51f68yh98x2461pp81o94244.this.olaht97301llc9484596423b27h61n20vo2343to2179q17h84p091ir51lgir024s7069.ivy9853ijuoo16m70xvnnhekq15d5u43o70yfgfw949x2445jg23o30odn235736();
        int i = 0;
        rai33v9dtd056s48gr12irbbx81qv64g53emphbz51f68yh98x2461pp81o94244.this.sblje58riix55rdur3b542919l59129882x97xt71u7484rk44w9448a37iaz69v871760.setMax(k);
        while (i < k)
        {
          int j = i;
          try
          {
            Thread.sleep(500L);
            j = i;
            i = rai33v9dtd056s48gr12irbbx81qv64g53emphbz51f68yh98x2461pp81o94244.this.olaht97301llc9484596423b27h61n20vo2343to2179q17h84p091ir51lgir024s7069.bbz59q96q113916i24g9lw8348hc481395381666d82jl5164dv71q15b47z53j565267qos37();
            j = i;
            rai33v9dtd056s48gr12irbbx81qv64g53emphbz51f68yh98x2461pp81o94244.this.sblje58riix55rdur3b542919l59129882x97xt71u7484rk44w9448a37iaz69v871760.setProgress(i);
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            i = j;
          }
        }
      }
    };
    Log.d("tirslhkbfxcdatqroymf", "ixqpxptkqzasuvbosxal");
    paramBundle = getIntent().getExtras();
    this.bpw62lwb43ws48d18t2955eou49p3219b71x5263ruq84h91shrd28ul923764d91h15 = paramBundle.getParcelableArrayList("songlist");
    this.fnj87lcd47o256077s84jdrqw58ni45v5641y7487kn2313w523dkk43874570w62elb18 = paramBundle.getInt("pos", 0);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131558400, paramMenu);
    Log.i("fzknvqwmiciqcbxhummq", "kptdxqzoccuqhawktezo");
    Log.w("auqywnzaytttlvhdsdcu", "uermmxyutzvdwxrizwsd");
    Log.w("zknfvvmnuezexuvdydke", "podacnuxnobzrmicddgo");
    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    Log.e("cpuqwhdnzmxasigrfrkx", "edrhtgahjeriwqewyrka");
    Log.e("aimlsdmvmxrjcotpfejk", "phtwabozvxsfaasfsqam");
    int i = paramMenuItem.getItemId();
    Log.v("aexrutolxyaaaaudxvmt", "tsfzebtmwgsrlhsbawoz");
    if (i == 2131493007) {
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean) {}
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    Log.d("nflgcjbxyptxgudsgddg", "jfmxsisayezgeezwuqpj");
    Log.w("shoefzsgkhclreaubcwe", "wxccxtvrcxhrqleqphnk");
    Log.i("wtwxjkphpwmbuoakykdf", "pcjuzenpdwefwflomybj");
    this.olaht97301llc9484596423b27h61n20vo2343to2179q17h84p091ir51lgir024s7069.qmkx6f46qlu54477718a2g51e6321yk7925351d99eutybwmwjyu36s9x75pv1741(paramSeekBar.getProgress());
  }
  
  public void vsl33b844e17kpxsadp40on3iif41kmkd4160338638cwf3672ip6810f90161949n58(Uri paramUri)
  {
    Log.v("jzhilrmcjuiwhlqjidwr", "ketxfinmwzkywtjoxogl");
    this.bbh1429r57i20v1402492epz90511880n42lik327986w198uid54r42839712pf3889pt9767.setImageBitmap(this.olaht97301llc9484596423b27h61n20vo2343to2179q17h84p091ir51lgir024s7069.dhwxafp5426051t98dz47zpz4747025bn25uf93m56a1tqd033pxfhq18d62nl34(paramUri, null));
  }
}


/* Location:              C:\Users\colin\Documents\GitHub\cchr158First\G7.jar!\com\example\owner\musicplayer\rai33v9dtd056s48gr12irbbx81qv64g53emphbz51f68yh98x2461pp81o94244.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */