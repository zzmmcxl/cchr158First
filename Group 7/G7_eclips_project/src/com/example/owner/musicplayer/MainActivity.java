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

public class MainActivity extends AppCompatActivity {
	private Button playlistButton;
	private ArrayAdapter<String> onScreenListOfSongs;
	private LinkedList<File> songList;

	protected void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		setContentView(R.layout.activity_main);
		ListView var5 = (ListView) findViewById(R.id.allSongs);
		this.playlistButton = ((Button) findViewById(R.id.btPlayer));
		this.playlistButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramAnonymousView) {
				Intent var2 = new Intent(MainActivity.this.getApplicationContext(), PlayListActivity.class);
				MainActivity.this.startActivity(var2);
			}
		});
		this.songList = PlayList.getPlayList().getFileList();
		final ArrayList localArrayList = findSongsOnPhone(
				Environment.getExternalStorageDirectory());
		final String[] songNames = new String[localArrayList.size()];
		int i = 0;
		while (i < localArrayList.size()) {
			songNames[i] = ((File) localArrayList.get(i)).getName().toString().replace(".mp3", "").replace(".wav", "");
			i += 1;
		}
		this.onScreenListOfSongs = new ArrayAdapter(getApplicationContext(), R.layout.song_layout, R.id.textView,
				songNames);
		var5.setAdapter(this.onScreenListOfSongs);
		var5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView,
					int paramAnonymousInt, long paramAnonymousLong) {
				File var6 = (File) localArrayList.get(paramAnonymousInt);
				MainActivity.this.songList.addLast(var6);
				Toast.makeText(MainActivity.this.getApplicationContext(),
						songNames[paramAnonymousInt] + " IS ADDED TO THE QUEUE", 0).show();
			}
		});
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

	public ArrayList<File> findSongsOnPhone(File paramFile) {
		ArrayList localArrayList = new ArrayList();
		File[] var6 = paramFile.listFiles();
		if (var6 != null) {
			int j = var6.length;

			for (int i = 0; i < j; i++) {
				File localFile = var6[i];
				if ((localFile.isDirectory()) && (!localFile.isHidden())) {
					localArrayList
							.addAll(findSongsOnPhone(localFile));
				} else if ((localFile.getName().endsWith(".mp3")) || (localFile.getName().endsWith(".wav"))) {
					localArrayList.add(localFile);
				}
			}
		}
		return localArrayList;
	}
}

/*
 * Location:
 * C:\Users\colin\Documents\GitHub\cchr158First\G7.jar!\com\example\owner\
 * musicplayer\dvl61qch195gmbfdj60477757641065hra50ruvsbsl7gk10629bhw36o349871i1
 * .class Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */