package com.example.owner.musicplayer;

import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import com.example.owner.musicplayer.cft99u7331sz7371k2068241z83s5314943p69r99r6d20t3493cv491981p588269188814lb0;
import com.example.owner.musicplayer.jsr438w4171f7096744c329292z606416yy178033s399lhd2226fgs37mfu97em56zgt3;
import com.example.owner.musicplayer.rai33v9dtd056s48gr12irbbx81qv64g53emphbz51f68yh98x2461pp81o94244;
import com.example.owner.musicplayer.szr58w75mpfxi23wc7m10p75ym50j39o8912wlcfdba3967tng81l49314045510925$1;
import com.example.owner.musicplayer.szr58w75mpfxi23wc7m10p75ym50j39o8912wlcfdba3967tng81l49314045510925$2;
import java.io.File;
import java.util.LinkedList;

public class szr58w75mpfxi23wc7m10p75ym50j39o8912wlcfdba3967tng81l49314045510925 extends AppCompatActivity implements OnClickListener {
   private static final String zpst39sqm4ha7520vguy868225l81hx9648363u43916751b7418kkokec5561y34y215 = "LogMessage";
   private Button bdd36t1113rb23936723y31lxp254mn36q695228uzmo88n4r1394eo6881i21fy304y86;
   private ServiceConnection frz326292984fpqzh450is1p3779zl15n389511c447472368233727no26m6139739c72i77 = new szr58w75mpfxi23wc7m10p75ym50j39o8912wlcfdba3967tng81l49314045510925$2(this);
   private String[] jlzwksqd91d69g8110ry29qm83s20izlz15239172997ciaii73zfklttn9r2311;
   private ArrayAdapter<String> jsx6275zfts3139pq7036qmk4063544813c389889n36ld914323h5469kqsnbife99f378;
   private Runnable nxf52t64k1781j41llalngf51o93ndzbw78u8522f47ikvtxgcl49r57r76uc3783;
   private LinkedList<File> ohm14o33jt881079kza90772452080bkx62x47n28z96j4367qh97s4813n1942n3319672577;
   private jsr438w4171f7096744c329292z606416yy178033s399lhd2226fgs37mfu97em56zgt3 olaht97301llc9484596423b27h61n20vo2343to2179q17h84p091ir51lgir024s7069;
   boolean ols59225260a21392a5215371655p56ss29o703849808432fg74c21kp224164ma888641t72m8068 = false;
   private ListView uwq68y694jpbwr206731ka684288c87634813rn284k322ebe34pi6073mfjd3260u8087;
   private Button voq20ynp56tk5132wz94qds66s59m70l45ty41153ng26ih8715r38ia63jtj2l8784;
   private Button xzat3637k8466c928f2a5041v96m665529292447141bl9777q3188g727255q2q957948ptr85;

   public void grmiklskmeuhkqsktctq() {
      Log.v("halesokabrtzbnqoklmm", "lfuhozidfcpelgpfnfzu");
   }

   public String[] inxl5534v66fpe670t81r9424e30l62okn9zcj528571hz3660dw81y24098qg2342y81(LinkedList<File> var1) {
      this.jlzwksqd91d69g8110ry29qm83s20izlz15239172997ciaii73zfklttn9r2311 = new String[var1.size()];
      Log.d("skrwdgyfaxkqqbmkxila", "moksntuxkossslirqiny");
      Log.d("smptgbqvnumncohbgbwz", "yjhweurxndpzndtanion");
      Log.d("dapxtkiayiwfcdaxrrld", "vmojzbzuuypbxjhdqxyt");

      for(int var2 = 0; var2 < var1.size(); ++var2) {
         this.jlzwksqd91d69g8110ry29qm83s20izlz15239172997ciaii73zfklttn9r2311[var2] = ((File)var1.get(var2)).getName().toString().replace(".mp3", "").replace(".wav", "");
      }

      return this.jlzwksqd91d69g8110ry29qm83s20izlz15239172997ciaii73zfklttn9r2311;
   }

   public void onClick(View var1) {
      switch(var1.getId()) {
      case 2131492980:
         if(this.ohm14o33jt881079kza90772452080bkx62x47n28z96j4367qh97s4813n1942n3319672577.size() != 0) {
            this.olaht97301llc9484596423b27h61n20vo2343to2179q17h84p091ir51lgir024s7069.lmbkkudgil1e88881709775w7iymcr8375905328ej528188wteg1869wap91amt39();
            this.startActivity((new Intent(this.getApplicationContext(), rai33v9dtd056s48gr12irbbx81qv64g53emphbz51f68yh98x2461pp81o94244.class)).putExtra("pos", 0).putExtra("songlist", this.ohm14o33jt881079kza90772452080bkx62x47n28z96j4367qh97s4813n1942n3319672577));
            return;
         }

         Toast.makeText(this.getApplicationContext(), "NO SONG IN THE PLAYLIST, CANNOT START PLAYING.", 0).show();
         return;
      case 2131492981:
      case 2131492982:
      default:
         return;
      case 2131492983:
         if(this.ohm14o33jt881079kza90772452080bkx62x47n28z96j4367qh97s4813n1942n3319672577.size() != 0) {
            this.olaht97301llc9484596423b27h61n20vo2343to2179q17h84p091ir51lgir024s7069.rnh386yyz93dy69nyak30lrh73266695d5iguz76tz0eer9255q71wc2786jhw38();
            this.ohm14o33jt881079kza90772452080bkx62x47n28z96j4367qh97s4813n1942n3319672577.clear();
            this.jlzwksqd91d69g8110ry29qm83s20izlz15239172997ciaii73zfklttn9r2311 = this.inxl5534v66fpe670t81r9424e30l62okn9zcj528571hz3660dw81y24098qg2342y81(this.ohm14o33jt881079kza90772452080bkx62x47n28z96j4367qh97s4813n1942n3319672577);
            this.jsx6275zfts3139pq7036qmk4063544813c389889n36ld914323h5469kqsnbife99f378 = new ArrayAdapter(this.getApplicationContext(), 2130968630, 2131493006, this.jlzwksqd91d69g8110ry29qm83s20izlz15239172997ciaii73zfklttn9r2311);
            this.yfr6694ul54g2323069jx44kv33tbh47257xg2952b654034459297d31g7359a854di911382();
         } else {
            Toast.makeText(this.getApplicationContext(), "THE PLAYLIST IS ALREADY EMPTY", 0).show();
         }
      }
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(2130968603);
      Log.v("avlmkjjihuseszbeevle", "wrhbpxthnxrelvjgwmxn");
      this.bindService(new Intent(this, jsr438w4171f7096744c329292z606416yy178033s399lhd2226fgs37mfu97em56zgt3.class), this.frz326292984fpqzh450is1p3779zl15n389511c447472368233727no26m6139739c72i77, 1);
      Log.d("azwpjyubdogdkfzugpjv", "pvxgewsspntmxgumozcn");
      this.voq20ynp56tk5132wz94qds66s59m70l45ty41153ng26ih8715r38ia63jtj2l8784 = (Button)this.findViewById(2131492980);
      Log.d("xbumjmytkhlrhhpgjtrb", "extpsibmvmbztwazeory");
      this.xzat3637k8466c928f2a5041v96m665529292447141bl9777q3188g727255q2q957948ptr85 = (Button)this.findViewById(2131492983);
      this.uwq68y694jpbwr206731ka684288c87634813rn284k322ebe34pi6073mfjd3260u8087 = (ListView)this.findViewById(2131492982);
      this.nxf52t64k1781j41llalngf51o93ndzbw78u8522f47ikvtxgcl49r57r76uc3783 = new szr58w75mpfxi23wc7m10p75ym50j39o8912wlcfdba3967tng81l49314045510925$1(this);
      this.xzat3637k8466c928f2a5041v96m665529292447141bl9777q3188g727255q2q957948ptr85.setOnClickListener(this);
      Log.w("suhgmcowdvcvtxrbcaoz", "apzqdxczwmpdzsyknqcz");
      Log.i("jlvdtbahntomxldhlbjq", "njbsnlabjohgzwfdpixq");
      this.voq20ynp56tk5132wz94qds66s59m70l45ty41153ng26ih8715r38ia63jtj2l8784.setOnClickListener(this);
      this.ohm14o33jt881079kza90772452080bkx62x47n28z96j4367qh97s4813n1942n3319672577 = cft99u7331sz7371k2068241z83s5314943p69r99r6d20t3493cv491981p588269188814lb0.tec55ej48llvg134592362793309055a21dd44e93d566073b94nt90n91yu2141mc5l0a1().cdq4314w8rbq5e44716832221675489497f3462o42808827m5285330ffn20ho25612465l12240();
      Log.d("gpmrxgkgrjzeusxxnwmc", "xkrcyitqnjngfcvvpvin");
      Log.e("aeufmxwpzvbgvhfhvhlu", "irlrbhfjyvwrkwlmxxrb");
      this.jlzwksqd91d69g8110ry29qm83s20izlz15239172997ciaii73zfklttn9r2311 = this.inxl5534v66fpe670t81r9424e30l62okn9zcj528571hz3660dw81y24098qg2342y81(this.ohm14o33jt881079kza90772452080bkx62x47n28z96j4367qh97s4813n1942n3319672577);
      Log.v("uqnozwujessmbnlbxmbs", "uappfwrsdezaehprzpam");
      this.jsx6275zfts3139pq7036qmk4063544813c389889n36ld914323h5469kqsnbife99f378 = new ArrayAdapter(this.getApplicationContext(), 2130968630, 2131493006, this.jlzwksqd91d69g8110ry29qm83s20izlz15239172997ciaii73zfklttn9r2311);
      Log.d("rcoyqdhxeqqutwkmwwrd", "qweiguruqjwazdfucafe");
      Log.e("rabmzfpkbbyztnvzvqbw", "nusxzgacqipsyuqhhuug");
      Log.e("iygylkgnjsdbxpyhoqte", "wzvpfwpvljpciobcwgjs");
      Log.i("mqijwjvcaqegghthpozc", "ursgclgwjpjhfrnmvyci");
      Log.d("cltisiprlqbeltkssatg", "vprkhjyabaxipmowidwd");
      this.uwq68y694jpbwr206731ka684288c87634813rn284k322ebe34pi6073mfjd3260u8087.setAdapter(this.jsx6275zfts3139pq7036qmk4063544813c389889n36ld914323h5469kqsnbife99f378);
   }

   public boolean onCreateOptionsMenu(Menu var1) {
      Log.d("vtltqzgxpetpxkoupeps", "fdsxalhxdbvwngfnzlyb");
      Log.e("nzypzuaxyevadkyifiyk", "lpzzbzsozuryvrxgekps");
      Log.i("ffcedfttabamtikcbnbh", "eppdnhpozindsukogjyv");
      Log.w("wqhwvpbrtrwzajbbkbkp", "yoplvadgnjmjtcxhuddp");
      this.getMenuInflater().inflate(2131558400, var1);
      return true;
   }

   public boolean onOptionsItemSelected(MenuItem var1) {
      int var2 = var1.getItemId();
      Log.d("yrnrvemzltfxzuywfkpk", "wffzpdrllsxpeorjpipz");
      Log.v("rfvcbuxogcuacxjufiwq", "hudbigpgncquzsxaefuz");
      if(var2 == 2131493007) {
         return true;
      } else {
         Log.d("hcnowvvgpjzzwaxlnrap", "kidwkdpmumxedgtbrbau");
         return super.onOptionsItemSelected(var1);
      }
   }

   protected void onResume() {
      super.onResume();
      Log.i("kbpmrffvahfmuoibzghv", "yumvqkudkfljseukwlhi");
      Log.i("qeeyujjewdrattrecjwx", "cjafudlscjnuxuvtsmtj");
      Log.w("ifrpqzvkraobswhgedwc", "swifuqplrqcrnvkntnuo");
      Log.e("oriyubewzgkxghalptad", "hogombbvtzrvchlnzrmt");
      this.ohm14o33jt881079kza90772452080bkx62x47n28z96j4367qh97s4813n1942n3319672577 = cft99u7331sz7371k2068241z83s5314943p69r99r6d20t3493cv491981p588269188814lb0.tec55ej48llvg134592362793309055a21dd44e93d566073b94nt90n91yu2141mc5l0a1().cdq4314w8rbq5e44716832221675489497f3462o42808827m5285330ffn20ho25612465l12240();
      Log.i("aqsemmcegbykhjafgzvv", "nzawnqymrzzwzuaapkqe");
      Log.d("qnxpdrpetjmvsbndhvmb", "aetuungjvfoecjyqzcrj");
      Log.v("fbhalqtdakxyatpoenfp", "nzufakfnxogktsawlwcv");
      Log.i("LogMessage", "Resume is working");
      this.yfr6694ul54g2323069jx44kv33tbh47257xg2952b654034459297d31g7359a854di911382();
   }

   public void yfr6694ul54g2323069jx44kv33tbh47257xg2952b654034459297d31g7359a854di911382() {
      Log.i("iblwcbppshaaxtlknocu", "rngiqcnuxvyuvivzvejf");
      Log.i("zxezqkwzgppmlormgwoa", "hdiddwqagpumdyqgnqzj");
      this.runOnUiThread(this.nxf52t64k1781j41llalngf51o93ndzbw78u8522f47ikvtxgcl49r57r76uc3783);
   }
}
