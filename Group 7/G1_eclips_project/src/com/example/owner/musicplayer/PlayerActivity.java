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

public class PlayerActivity extends AppCompatActivity
		implements SeekBar.OnSeekBarChangeListener, View.OnClickListener {
	private ImageView albumArt;
	private ArrayList<File> songList;
	private int songPosition;
	private ServiceConnection service = new ServiceConnection() {
		public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder) {
			paramAnonymousComponentName = (Player.playerBinder) paramAnonymousIBinder;
			PlayerActivity.access$002(
					PlayerActivity.this,
					paramAnonymousComponentName.getThisPlayerActivity());
			PlayerActivity
					.access$202(PlayerActivity.this, true);
			PlayerActivity.this
					.startPlayer();
		}

		public void onServiceDisconnected(ComponentName paramAnonymousComponentName) {
			PlayerActivity
					.access$202(PlayerActivity.this, false);
		}
	};
	private TextView songTitle;
	private Button nextButton;
	private Button playPauseButton;
	private Button fastforwardButton;
	private Player player;
	// private boolean
	// ols59225260a21392a5215371655p56ss29o703849808432fg74c21kp224164ma888641t72m8068
	// = false;
	private Thread seekBarThread;
	private SeekBar theSeekBar;
	private Button rewindButton;
	private Button previousSongButton;

	public void startPlayer() {
		this.player.setPlayer();
		this.songTitle.setText(this.player.getSong().getName().replace(".mp3", "").replace(".wav", ""));
		setAlbumArt(this.player.setSongAndGetItsURI(this.player.getSong()));
		this.theSeekBar.setMax(this.player.getDuration());
		this.seekBarThread.start();
	}

	public void onClick(View paramView) {
		int i = paramView.getId();
		switch (i) {
		default:
		case R.id.btPlay:
			this.playPauseButton.setText(this.player.pauseOrUnpause());
			return;
		case R.id.btFf:
			if (this.player.fastward5Seconds()) {
				setAlbumArt(this.player.setSongAndGetItsURI(this.player.getSong()));
				this.songTitle.setText(this.player.getSong().getName().replace(".mp3", "").replace(".wav", ""));
				this.theSeekBar.setMax(this.player.getDuration());
				this.playPauseButton.setText("||");
			}
			return;
		case R.id.btRw:
			if (this.player.rewind5Seconds()) {
				setAlbumArt(this.player.setSongAndGetItsURI(this.player.getSong()));
				this.songTitle.setText(this.player.getSong().getName().replace(".mp3", "").replace(".wav", ""));
				this.theSeekBar.setMax(this.player.getDuration());
				this.playPauseButton.setText("||");
			}
			return;
		case R.id.btNext:
			this.player.nextSong();
			setAlbumArt(this.player.setSongAndGetItsURI(this.player.getSong()));
			this.songTitle.setText(this.player.getSong().getName().replace(".mp3", "").replace(".wav", ""));
			this.theSeekBar.setMax(this.player.getDuration());
			this.playPauseButton.setText("||");
			return;
		}
		this.player.skipToLastSong();
		setAlbumArt(this.player.setSongAndGetItsURI(this.player.getSong()));
		this.songTitle.setText(this.player.getSong().getName().replace(".mp3", "").replace(".wav", ""));
		this.theSeekBar.setMax(this.player.getDuration());
		this.playPauseButton.setText("||");
	}

	protected void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		setContentView(R.layout.activity_player);
		bindService(new Intent(this, Player.class),
				this.service, 1);
		this.playPauseButton = ((Button) findViewById(R.id.btPlay));
		this.fastforwardButton = ((Button) findViewById(R.id.btFf));
		this.rewindButton = ((Button) findViewById(R.id.btRw));
		this.nextButton = ((Button) findViewById(R.id.btNext));
		this.previousSongButton = ((Button) findViewById(R.id.btPrev));
		this.songTitle = ((TextView) findViewById(R.id.songName));
		this.playPauseButton.setOnClickListener(this);
		this.fastforwardButton.setOnClickListener(this);
		this.rewindButton.setOnClickListener(this);
		this.nextButton.setOnClickListener(this);
		this.previousSongButton.setOnClickListener(this);
		this.albumArt = ((ImageView) findViewById(R.id.albumView));
		this.theSeekBar = ((SeekBar) findViewById(R.id.seekBar));
		this.theSeekBar.setOnSeekBarChangeListener(this);
		this.seekBarThread = new Thread() {
			public void run() {
				int k = PlayerActivity.this.player
						.getDuration();
				int i = 0;
				PlayerActivity.this.theSeekBar.setMax(k);
				while (i < k) {
					int j = i;
					try {
						Thread.sleep(500L);
						i = PlayerActivity.this.player
								.getPosition();
						PlayerActivity.this.theSeekBar.setProgress(i);
					} catch (Exception localException) {
						localException.printStackTrace();
						i = j;
					}
				}
			}
		};
		paramBundle = getIntent().getExtras();
		this.songList = paramBundle.getParcelableArrayList("songlist");
		this.songPosition = paramBundle.getInt("pos", 0);
	}

	public boolean onCreateOptionsMenu(Menu paramMenu) {
		getMenuInflater().inflate(2131558400, paramMenu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
		Log.e("cpuqwhdnzmxasigrfrkx", "edrhtgahjeriwqewyrka");
		Log.e("aimlsdmvmxrjcotpfejk", "phtwabozvxsfaasfsqam");
		int i = paramMenuItem.getItemId();
		Log.v("aexrutolxyaaaaudxvmt", "tsfzebtmwgsrlhsbawoz");
		if (i == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(paramMenuItem);
	}

	public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean) {
	}

	public void onStartTrackingTouch(SeekBar paramSeekBar) {
	}

	public void onStopTrackingTouch(SeekBar paramSeekBar) {
		this.player.skeepToThisTime(paramSeekBar.getProgress());
	}

	public void setAlbumArt(Uri paramUri) {
		this.albumArt.setImageBitmap(this.player.setAlbumArt(paramUri, null));
	}
}

/*
 * Location:
 * C:\Users\colin\Documents\GitHub\cchr158First\G7.jar!\com\example\owner\
 * musicplayer\rai33v9dtd056s48gr12irbbx81qv64g53emphbz51f68yh98x2461pp81o94244.
 * class Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */