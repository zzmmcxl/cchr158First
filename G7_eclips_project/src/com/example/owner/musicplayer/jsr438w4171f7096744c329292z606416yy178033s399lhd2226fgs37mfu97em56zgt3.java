package com.example.owner.musicplayer;

import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;
import java.io.File;
import java.util.List;
import wseemann.media.FFmpegMediaMetadataRetriever;

public class jsr438w4171f7096744c329292z606416yy178033s399lhd2226fgs37mfu97em56zgt3
  extends Service
  implements MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener
{
  private List<File> bfmb5178p9088i394560439ygvmjz475092piqt99pi9875438pq836586j4284688w649145;
  private int fsx11wsr797753d92i5886ask9833rb1089398h74k34z31d8421e7e14q22161243qqcx44;
  private MediaPlayer player;
  private final IBinder yjl3u59m97wn98eajx984015tk23pv64vu864581y60l51wbi58f702929m47u93v706746 = new bkv3523rqvc154051z146pqz54l34q38ujcx6211au2959i6368gdes982958eze95952();
  private File zcy855065y0rfl79r44m1957yr26qnw7d27dbcvat23iq8565a9m36y862h97dj43;
  
  public int bbz59q96q113916i24g9lw8348hc481395381666d82jl5164dv71q15b47z53j565267qos37()
  {
    Log.i("tjfsmfinlkoaotgsvqfi", "ojwcqdhbncsrylmzrcjw");
    return this.player.getCurrentPosition();
  }
  
  public void cre31u5349ho3992810wj175952sm38qhh35e72c35xa5413h4ze38ik98u3b9416133()
  {
    this.player.stop();
    this.player.release();
    Log.d("yqzelekdoayeuyqxqsfv", "qirwnwjpubjojlmslfvq");
    this.fsx11wsr797753d92i5886ask9833rb1089398h74k34z31d8421e7e14q22161243qqcx44 = ((this.fsx11wsr797753d92i5886ask9833rb1089398h74k34z31d8421e7e14q22161243qqcx44 + 1) % this.bfmb5178p9088i394560439ygvmjz475092piqt99pi9875438pq836586j4284688w649145.size());
    Log.w("dqroupkltzjxrgiwebte", "rejcrobhffufogowqjnd");
    this.zcy855065y0rfl79r44m1957yr26qnw7d27dbcvat23iq8565a9m36y862h97dj43 = ((File)this.bfmb5178p9088i394560439ygvmjz475092piqt99pi9875438pq836586j4284688w649145.get(this.fsx11wsr797753d92i5886ask9833rb1089398h74k34z31d8421e7e14q22161243qqcx44));
    Log.v("icdsubwsppndgpuwobbn", "hwqpqvrwshmzlqkfarqv");
    Log.v("umnpdgsdchujpfewvbzj", "koignfkesogcbqrekjve");
    this.player = MediaPlayer.create(getApplicationContext(), sfk90j61f13471l17ew4evz3479e83kp20y9312cl67viln66537wz4340l28dz5g28(this.zcy855065y0rfl79r44m1957yr26qnw7d27dbcvat23iq8565a9m36y862h97dj43));
    Log.v("vglopvnyqfhdowlokozs", "vlpinehnvnywwkhgfvgz");
    this.player.start();
  }
  
  public Bitmap dhwxafp5426051t98dz47zpz4747025bn25uf93m56a1tqd033pxfhq18d62nl34(Uri paramUri, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new FFmpegMediaMetadataRetriever();
    Log.d("urckimawyijnhusmlpwm", "capmuhlcultrzccnefge");
    paramArrayOfByte.setDataSource(paramUri.toString());
    paramUri = paramArrayOfByte.getEmbeddedPicture();
    if (paramUri != null) {
      return BitmapFactory.decodeByteArray(paramUri, 0, paramUri.length);
    }
    return BitmapFactory.decodeResource(getResources(), 2130837579);
  }
  
  public boolean eqd5820wr18sfa694n94cw9517de22lj4627ug513mq647818192d2163xnk79817670s30()
  {
    Log.e("butpshadozynpbfroqve", "fvbxbiomqoxbmftzfhzu");
    Log.v("ejvdhblmmjigcaximonn", "epcdwsibtsetngqpjcwg");
    if (this.player.getCurrentPosition() + 5000 < this.player.getDuration())
    {
      this.player.seekTo(this.player.getCurrentPosition() + 5000);
      return false;
    }
    cre31u5349ho3992810wj175952sm38qhh35e72c35xa5413h4ze38ik98u3b9416133();
    return true;
  }
  
  public void fixyf782463o39jmz87454440r97h4169caw57v21k534374y2499cox0ple81t44591840()
  {
    Log.i("mggqljwymiykobapejzh", "suzcvhffgtznfdbtvtig");
    Log.d("awcdbwrfckoknqsquqom", "fjwrejuddwdpzjzsjblx");
    Log.i("aqtdtnkjrrbkiqocozuh", "nlswshxhgfmfsvjpqzap");
    this.player = MediaPlayer.create(getApplicationContext(), sfk90j61f13471l17ew4evz3479e83kp20y9312cl67viln66537wz4340l28dz5g28((File)this.bfmb5178p9088i394560439ygvmjz475092piqt99pi9875438pq836586j4284688w649145.get(this.fsx11wsr797753d92i5886ask9833rb1089398h74k34z31d8421e7e14q22161243qqcx44)));
    Log.v("mfrsafnrpauhrvysfink", "oiodxcvduekpgzedsvkd");
    this.player.start();
  }
  
  public int ivy9853ijuoo16m70xvnnhekq15d5u43o70yfgfw949x2445jg23o30odn235736()
  {
    Log.v("kbtgeihbdsozggvmlyof", "udarkqlqvwvxslhgaeps");
    Log.d("dqjgamexwwauvmfujyxy", "zqetlihwcrqjnldragyx");
    Log.d("fptqlptmrmjggggdejqw", "oebyrfclsgkgheqcbqvc");
    Log.w("xbamyzjtatnbzrtoejsx", "tcisxphomoevgpltpjqo");
    Log.w("tjuubeatlztlrvvasfiy", "lroxddsnicnhuxuqxbba");
    return this.player.getDuration();
  }
  
  public boolean jue394914eae99644865v22ft38f1718gz7020ww7tir8132k33v46408260ek61827635634331()
  {
    if (this.player.getCurrentPosition() - 5000 > 0)
    {
      this.player.seekTo(this.player.getCurrentPosition() - 5000);
      return false;
    }
    wuli14h3032iow62sl5250h8301873sqm5576567261981932pe3248q2c75201815599645804132();
    return true;
  }
  
  public void lmbkkudgil1e88881709775w7iymcr8375905328ej528188wteg1869wap91amt39()
  {
    if (this.player.isPlaying())
    {
      this.player.stop();
      this.player.release();
      this.fsx11wsr797753d92i5886ask9833rb1089398h74k34z31d8421e7e14q22161243qqcx44 = 0;
    }
  }
  
  public String mkt70q60zvmf6489w627028964896so91g14543313dju31930na43w2498py150yrz12329()
  {
    if (this.player.isPlaying())
    {
      this.player.pause();
      return ">";
    }
    this.player.start();
    return "||";
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.yjl3u59m97wn98eajx984015tk23pv64vu864581y60l51wbi58f702929m47u93v706746;
  }
  
  public void onCreate()
  {
    Log.i("vfrdfyyjxohhruxnrtld", "fikemkrcdqlselzowwix");
    super.onCreate();
    Log.i("yoxwmiikxvgbchzacnxg", "ctiwdnzlzdaamuuxuttf");
    Log.d("mjaiadmwceczgvqdodad", "szzjugpukoixxiiijyrm");
    Log.w("jnosarvaxknjxwirchnz", "ykbeljsgpjkjhrdvrpdg");
    Log.i("pwefvsbsuqnmnoehblsm", "aczcmhvmtrvbkzehmjbd");
    this.player = new MediaPlayer();
    Log.d("jpvnplbxlxuurkosgquf", "iyybvltvxodwwgyulqnn");
    Log.e("ljkvfnxaxalbpwztbeyr", "blbtmokngnesnkoyydsc");
    this.bfmb5178p9088i394560439ygvmjz475092piqt99pi9875438pq836586j4284688w649145 = cft99u7331sz7371k2068241z83s5314943p69r99r6d20t3493cv491981p588269188814lb0.tec55ej48llvg134592362793309055a21dd44e93d566073b94nt90n91yu2141mc5l0a1().cdq4314w8rbq5e44716832221675489497f3462o42808827m5285330ffn20ho25612465l12240();
    Log.v("wxoxaklbyjdocgtbmedd", "yvpmikcwfwtzonqlabvw");
    this.fsx11wsr797753d92i5886ask9833rb1089398h74k34z31d8421e7e14q22161243qqcx44 = 0;
    Log.e("eoughjowopgonvcsgwto", "mwccichsludyavhlijti");
    Log.e("tqschnvofymvdyjgxkfx", "bjyefgzskxlqxzuqgzjk");
    this.player.setOnErrorListener(this);
    this.player.setOnPreparedListener(this);
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer) {}
  
  public void pceurfsckxyibiilqrdw()
  {
    Log.e("tpfbfucnssleyrriizqk", "ttappedhcivofcspkozm");
    Log.i("amerlavkarctberhziwy", "abqelvwqhbidpbotrzlv");
  }
  
  public void qmkx6f46qlu54477718a2g51e6321yk7925351d99eutybwmwjyu36s9x75pv1741(int paramInt)
  {
    this.player.seekTo(paramInt);
  }
  
  public void rnh386yyz93dy69nyak30lrh73266695d5iguz76tz0eer9255q71wc2786jhw38()
  {
    if (this.player != null)
    {
      if (this.player.isPlaying()) {
        Toast.makeText(getApplicationContext(), "STOPPING CURRENTLY PLAYING SONGS", 0).show();
      }
      this.player.stop();
      this.player.release();
    }
  }
  
  public Uri sfk90j61f13471l17ew4evz3479e83kp20y9312cl67viln66537wz4340l28dz5g28(File paramFile)
  {
    this.zcy855065y0rfl79r44m1957yr26qnw7d27dbcvat23iq8565a9m36y862h97dj43 = paramFile;
    return Uri.parse(this.zcy855065y0rfl79r44m1957yr26qnw7d27dbcvat23iq8565a9m36y862h97dj43.toString());
  }
  
  public File wcilkudk394811g9p133442mp940e9k39c82339536e38vhp7949z29rxb714523hq035()
  {
    return this.zcy855065y0rfl79r44m1957yr26qnw7d27dbcvat23iq8565a9m36y862h97dj43;
  }
  
  public void wuli14h3032iow62sl5250h8301873sqm5576567261981932pe3248q2c75201815599645804132()
  {
    this.player.stop();
    Log.i("qtexskrztvutdqjvkeyx", "knfxzqgkonypzvkhvigc");
    Log.e("elofxmrcxikibcbrnjdx", "vcaxyivxwbmvuloymgzz");
    this.player.release();
    if (this.fsx11wsr797753d92i5886ask9833rb1089398h74k34z31d8421e7e14q22161243qqcx44 - 1 < 0) {}
    for (int i = this.bfmb5178p9088i394560439ygvmjz475092piqt99pi9875438pq836586j4284688w649145.size() - 1;; i = this.fsx11wsr797753d92i5886ask9833rb1089398h74k34z31d8421e7e14q22161243qqcx44 - 1)
    {
      this.fsx11wsr797753d92i5886ask9833rb1089398h74k34z31d8421e7e14q22161243qqcx44 = i;
      Log.d("epsbqfnkebbetwvklngx", "xicciqqnawufrlzlmeom");
      this.zcy855065y0rfl79r44m1957yr26qnw7d27dbcvat23iq8565a9m36y862h97dj43 = ((File)this.bfmb5178p9088i394560439ygvmjz475092piqt99pi9875438pq836586j4284688w649145.get(this.fsx11wsr797753d92i5886ask9833rb1089398h74k34z31d8421e7e14q22161243qqcx44));
      Log.d("hvfznisyrorbmwnmhmgu", "lvlskybwsoosgabgbmef");
      this.player = MediaPlayer.create(getApplicationContext(), sfk90j61f13471l17ew4evz3479e83kp20y9312cl67viln66537wz4340l28dz5g28(this.zcy855065y0rfl79r44m1957yr26qnw7d27dbcvat23iq8565a9m36y862h97dj43));
      Log.w("ipztdlawvoxcsfyexcbm", "iqlpwvwrkhmgfovcarmi");
      Log.i("jtaplyxsadlztoensebq", "lbvomilyjoqdwtazldjy");
      Log.e("nckkshoavneymqprerdi", "bcbpsnqhvsulnoludkjx");
      Log.i("fmngefklmlwszpcszaxs", "vqeomcvzshjwhmmtliha");
      this.player.start();
      return;
    }
  }
  
  public class bkv3523rqvc154051z146pqz54l34q38ujcx6211au2959i6368gdes982958eze95952
    extends Binder
  {
    public bkv3523rqvc154051z146pqz54l34q38ujcx6211au2959i6368gdes982958eze95952() {}
    
    jsr438w4171f7096744c329292z606416yy178033s399lhd2226fgs37mfu97em56zgt3 tux7178q246614s11y49y54876184m92z72m29rv018udvsf4134942i53441833oybd66l27()
    {
      return jsr438w4171f7096744c329292z606416yy178033s399lhd2226fgs37mfu97em56zgt3.this;
    }
  }
}


/* Location:              C:\Users\colin\Documents\GitHub\cchr158First\G7.jar!\com\example\owner\musicplayer\jsr438w4171f7096744c329292z606416yy178033s399lhd2226fgs37mfu97em56zgt3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */