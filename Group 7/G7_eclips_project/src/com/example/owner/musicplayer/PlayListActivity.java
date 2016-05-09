package com.example.owner.musicplayer;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import java.io.File;
import java.util.LinkedList;

public class PlayListActivity extends AppCompatActivity implements View.OnClickListener {
	private String[] songNames;
	private ArrayAdapter<String> onScreenListOfSongs;
	private Runnable displayListOnScreen;
	private LinkedList<File> fileList;
	private Player player;
	boolean connected = false;
	private ListView lvPlaylist;
	private Button playButton;
	private Button clearButton;

	private ServiceConnection playListActivityService = new ServiceConnection() {
		public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder) {
			Player.playerBinder var3 = (Player.playerBinder) paramAnonymousIBinder;
			PlayListActivity.this.player = var3.getThisPlayer();
			PlayListActivity.this.connected = true;
		}

		public void onServiceDisconnected(ComponentName paramAnonymousComponentName) {
			PlayListActivity.this.connected = false;
		}
	};

	public String[] getSongNamesFromFiles(LinkedList<File> fL) {
		this.songNames = new String[fL.size()];
		int i = 0;
		while (i < fL.size()) {
			this.songNames[i] = ((File) fL.get(i)).getName().toString().replace(".mp3", "").replace(".wav", "");
			i += 1;
		}
		return this.songNames;
	}

	public void onClick(View paramView) {
		if (paramView.getId() == R.id.playButton) {
			if (this.fileList.size() != 0) {
				this.player
						.stopPlayer();
				startActivity(new Intent(getApplicationContext(),
						PlayerActivity.class).putExtra("pos", 0)
								.putExtra("songlist", this.fileList));
				return;
			}
			Toast.makeText(getApplicationContext(), "NO SONG IN THE PLAYLIST, CANNOT START PLAYING.", 0).show();
			return;
		}else if (this.fileList.size() != 0) {
			this.player
					.stopSong();
			this.fileList.clear();
			this.songNames = getSongNamesFromFiles(this.fileList);
			this.onScreenListOfSongs = new ArrayAdapter(getApplicationContext(), R.layout.song_layout, R.id.textView,
					this.songNames);
			runOnUiThread(this.displayListOnScreen);
			return;
		}
		Toast.makeText(getApplicationContext(), "THE PLAYLIST IS ALREADY EMPTY", 0).show();
	}

	protected void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		setContentView(R.layout.activity_playlist);
		bindService(new Intent(this, Player.class),
				this.playListActivityService, 1);
		this.playButton = ((Button) findViewById(R.id.playButton));
		this.clearButton = ((Button) findViewById(R.id.clearButton));
		this.lvPlaylist = ((ListView) findViewById(R.id.lvPlaylist));
		this.displayListOnScreen = new Runnable() {
			public void run() {
				PlayListActivity.this.lvPlaylist.setAdapter(PlayListActivity.this.onScreenListOfSongs);
				PlayListActivity.this.onScreenListOfSongs.notifyDataSetChanged();
				PlayListActivity.this.lvPlaylist.invalidateViews();
				PlayListActivity.this.lvPlaylist.refreshDrawableState();
			}
		};
		this.clearButton.setOnClickListener(this);
		this.playButton.setOnClickListener(this);
		this.fileList = playList.getPlayList().getFileList();
		this.songNames = getSongNamesFromFiles(this.fileList);
		this.onScreenListOfSongs = new ArrayAdapter(getApplicationContext(), R.layout.song_layout, R.id.textView,
				this.songNames);
		this.lvPlaylist.setAdapter(this.onScreenListOfSongs);
	}

	public boolean onCreateOptionsMenu(Menu paramMenu) {
		getMenuInflater().inflate(R.menu.menu_main, paramMenu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
		int i = paramMenuItem.getItemId();
		if (i == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(paramMenuItem);
	}

	protected void onResume() {
		super.onResume();
		this.fileList = playList.getPlayList().getFileList();
		runOnUiThread(this.displayListOnScreen);
	}

//	public void putListOnUIThread() {
//		runOnUiThread(this.displayListOnScreen);
//	}
}

/*
 * music dvisjsjfjshd344561 musicservice dvisjsjfjshd344561gaksdfjapsoidfj
 * poaisdjf
 *
 * Location:
 * C:\Users\colin\Documents\GitHub\cchr158First\G7.jar!\com\example\owner\
 * musicplayer\ PlayListActivity.class Java compiler version: 6 (50.0) JD-Core
 * Version: 0.7.1
 */