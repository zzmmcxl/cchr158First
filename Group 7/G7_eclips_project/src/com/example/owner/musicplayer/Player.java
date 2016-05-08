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

public class Player
  extends Service
  implements MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener
{
  private List<File> songList;
  private int trakeNumber;
  private MediaPlayer player;
  private final IBinder binder = new playerBinder();
  private File song;
  
  public int getPosition()
  {
    return this.player.getCurrentPosition();
  }
  
  public void nextSong()
  {
    this.player.stop();
    this.player.release();
    this.trakeNumber = ((this.trakeNumber + 1) % this.songList.size());
    this.song = ((File)this.songList.get(this.trakeNumber));
    this.player = MediaPlayer.create(getApplicationContext(), setSongAndGetItsURI(this.song));
    this.player.start();
  }
  
  public Bitmap setAlbumArt(Uri paramUri, byte[] paramArrayOfByte)
  {
	 FFmpegMediaMetadataRetriever var4 = new FFmpegMediaMetadataRetriever();
    var4.setDataSource(paramUri.toString());
    byte[] var3 = var4.getEmbeddedPicture();
    if (var3 != null) {
      return BitmapFactory.decodeByteArray(var3, 0, var3.length);
    }
    return BitmapFactory.decodeResource(getResources(), R.drawable.albumdefault);
  }
  
  public boolean fastward5Seconds()
  {
    if (this.player.getCurrentPosition() + 5000 < this.player.getDuration())
    {
      this.player.seekTo(this.player.getCurrentPosition() + 5000);
      return false;
    }
    nextSong();
    return true;
  }
  
  public void setPlayer()
  {
    this.player = MediaPlayer.create(getApplicationContext(), setSongAndGetItsURI((File)this.songList.get(this.trakeNumber)));
    this.player.start();
  }
  
  public int getDuration()
  {
    return this.player.getDuration();
  }
  
  public boolean rewind5Seconds()
  {
    if (this.player.getCurrentPosition() - 5000 > 0)
    {
      this.player.seekTo(this.player.getCurrentPosition() - 5000);
      return false;
    }
    previous();
    return true;
  }
  
  public void stopPlayer()
  {
    if (this.player.isPlaying())
    {
      this.player.stop();
      this.player.release();
      this.trakeNumber = 0;
    }
  }
  
  public String pauseOrUnpause()
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
    return this.binder;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.player = new MediaPlayer();
    this.songList = PlayList.getPlayList().getFileList();
    this.trakeNumber = 0;
    this.player.setOnErrorListener(this);
    this.player.setOnPreparedListener(this);
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer) {}
  
   
  public void skeepToThisTime(int paramInt)
  {
    this.player.seekTo(paramInt);
  }
  
  public void stopSong()
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
  
  public Uri setSongAndGetItsURI(File paramFile)
  {
    this.song = paramFile;
    return Uri.parse(this.song.toString());
  }
  
  public File getSong()
  {
    return this.song;
  }
  
  public void previous()
  {
    this.player.stop();
    this.player.release();
    int i;
    if(this.trakeNumber - 1 <0)
    {
    	i = this.songList.size()-1;
    }else{
    	i = this.trakeNumber-1;
    }
    this.trakeNumber = i;
    this.song = ((File)this.songList.get(this.trakeNumber));
    this.player = MediaPlayer.create(getApplicationContext(), setSongAndGetItsURI(this.song));
    this.player.start();
    return;
  }
  
  public class playerBinder
    extends Binder
  {
    public playerBinder() {}
    
    Player getThisPlayer()
    {
      return Player.this;
    }
  }
}


/* Location:              C:\Users\colin\Documents\GitHub\cchr158First\G7.jar!\com\example\owner\musicplayer\jsr438w4171f7096744c329292z606416yy178033s399lhd2226fgs37mfu97em56zgt3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */