package com.example.owner.musicplayer;

//import android.util.Log;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class PlayList
{
  private static PlayList playlist = new PlayList();
  private LinkedList<File> fileList = new LinkedList<File>();
  
  public static PlayList getPlayList()
  {
    //Log.d("mexfslvtnbtpsuecpgbn", "qqocmcpdqqknimczdfhr");
    return playlist;
  }
  
  public LinkedList<File> getFileList()
  {
    return this.fileList;
  }
  
//  public void goyctcvvsurrvxboulti()
//  {
////    Log.i("svwowynqfvlxguaigjaq", "gxktcovlejwwmsjjzfxu");
////    Log.i("mlfvtfojfnlfaxavujqf", "irfdbudfhhzoekqxqfvn");
////    Log.w("vymbizizzftuvjolfijr", "imkwjdfqbmtukpcsdkfj");
////    Log.i("abmvlvamvvunozejuzpa", "yhpmgxdhchytgkzioeyd");
////    Log.i("rabewaumzeuuegfxrfuu", "nuobqigogqsdgvizawad");
//  }
}


/* Location:              C:\Users\colin\Documents\GitHub\cchr158First\G7.jar!\com\example\owner\musicplayer\playList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */