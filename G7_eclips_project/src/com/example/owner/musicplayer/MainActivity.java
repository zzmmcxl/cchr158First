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

public class MainActivity extends AppCompatActivity
		implements View.OnClickListener {
	private String[] songNames;
	private ArrayAdapter<String> onScreenListOfSongs;
	private Runnable nxf52t64k1781j41llalngf51o93ndzbw78u8522f47ikvtxgcl49r57r76uc3783;
	private LinkedList<File> fileList;
	private jsr438w4171f7096744c329292z606416yy178033s399lhd2226fgs37mfu97em56zgt3 olaht97301llc9484596423b27h61n20vo2343to2179q17h84p091ir51lgir024s7069;
	boolean ols59225260a21392a5215371655p56ss29o703849808432fg74c21kp224164ma888641t72m8068 = false;
	private ListView listview;
	private Button button1;
	private Button button2;
	private ServiceConnection frz326292984fpqzh450is1p3779zl15n389511c447472368233727no26m6139739c72i77 = new ServiceConnection() {
		public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder) {
			paramAnonymousComponentName = (jsr438w4171f7096744c329292z606416yy178033s399lhd2226fgs37mfu97em56zgt3.bkv3523rqvc154051z146pqz54l34q38ujcx6211au2959i6368gdes982958eze95952) paramAnonymousIBinder;
			MainActivity.access$202(
					MainActivity.this,
					paramAnonymousComponentName
							.tux7178q246614s11y49y54876184m92z72m29rv018udvsf4134942i53441833oybd66l27());
			MainActivity.this.ols59225260a21392a5215371655p56ss29o703849808432fg74c21kp224164ma888641t72m8068 = true;
		}

		public void onServiceDisconnected(ComponentName paramAnonymousComponentName) {
			MainActivity.this.ols59225260a21392a5215371655p56ss29o703849808432fg74c21kp224164ma888641t72m8068 = false;
		}
	};

	// public void grmiklskmeuhkqsktctq() {
	// // Log.v("halesokabrtzbnqoklmm", "lfuhozidfcpelgpfnfzu");
	// }

	public String[] getSongNamesFromFiles(
			LinkedList<File> fL) {
		this.songNames = new String[fL.size()];
//		Log.d("skrwdgyfaxkqqbmkxila", "moksntuxkossslirqiny");
//		Log.d("smptgbqvnumncohbgbwz", "yjhweurxndpzndtanion");
//		Log.d("dapxtkiayiwfcdaxrrld", "vmojzbzuuypbxjhdqxyt");
		int i = 0;
		while (i < fL.size()) {
			this.songNames[i] = ((File) fL.get(i))
					.getName().toString().replace(".mp3", "").replace(".wav", "");
			i += 1;
		}
		return this.songNames;
	}

	public void onClick(View paramView) {
		switch (paramView.getId()) {
		case 2131492981:
		case 2131492982:
		default:
			return;
		case 2131492980:
			if (this.fileList.size() != 0) {
				this.olaht97301llc9484596423b27h61n20vo2343to2179q17h84p091ir51lgir024s7069
						.lmbkkudgil1e88881709775w7iymcr8375905328ej528188wteg1869wap91amt39();
				startActivity(new Intent(getApplicationContext(),
						rai33v9dtd056s48gr12irbbx81qv64g53emphbz51f68yh98x2461pp81o94244.class).putExtra("pos", 0)
								.putExtra("songlist",
										this.fileList));
				return;
			}
			Toast.makeText(getApplicationContext(), "NO SONG IN THE PLAYLIST, CANNOT START PLAYING.", 0).show();
			return;
		}
		if (this.fileList.size() != 0) {
			this.olaht97301llc9484596423b27h61n20vo2343to2179q17h84p091ir51lgir024s7069
					.rnh386yyz93dy69nyak30lrh73266695d5iguz76tz0eer9255q71wc2786jhw38();
			this.fileList.clear();
			this.songNames = getSongNamesFromFiles(
					this.fileList);
			this.onScreenListOfSongs = new ArrayAdapter(
					getApplicationContext(), 2130968630, R.id.textView,
					this.songNames);
			yfr6694ul54g2323069jx44kv33tbh47257xg2952b654034459297d31g7359a854di911382();
			return;
		}
		Toast.makeText(getApplicationContext(), "THE PLAYLIST IS ALREADY EMPTY", 0).show();
	}

	protected void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		setContentView(2130968603);
		// Log.v("avlmkjjihuseszbeevle", "wrhbpxthnxrelvjgwmxn");
		bindService(new Intent(this, jsr438w4171f7096744c329292z606416yy178033s399lhd2226fgs37mfu97em56zgt3.class),
				this.frz326292984fpqzh450is1p3779zl15n389511c447472368233727no26m6139739c72i77, 1);
		// Log.d("azwpjyubdogdkfzugpjv", "pvxgewsspntmxgumozcn");
		this.button1 = ((Button) findViewById(2131492980));
		// Log.d("xbumjmytkhlrhhpgjtrb", "extpsibmvmbztwazeory");
		this.button2 = ((Button) findViewById(
				2131492983));
		this.listview = ((ListView) findViewById(
				2131492982));
		this.nxf52t64k1781j41llalngf51o93ndzbw78u8522f47ikvtxgcl49r57r76uc3783 = new Runnable() {
			public void run() {
				MainActivity.this.listview
						.setAdapter(
								MainActivity.this.onScreenListOfSongs);
				MainActivity.this.onScreenListOfSongs
						.notifyDataSetChanged();
				MainActivity.this.listview
						.invalidateViews();
				MainActivity.this.listview
						.refreshDrawableState();
			}
		};
		this.button2.setOnClickListener(this);
		// Log.w("suhgmcowdvcvtxrbcaoz", "apzqdxczwmpdzsyknqcz");
		// Log.i("jlvdtbahntomxldhlbjq", "njbsnlabjohgzwfdpixq");
		this.button1.setOnClickListener(this);
		this.fileList = playList.getPlayList()
				.getFileList();
		// Log.d("gpmrxgkgrjzeusxxnwmc", "xkrcyitqnjngfcvvpvin");
		// Log.e("aeufmxwpzvbgvhfhvhlu", "irlrbhfjyvwrkwlmxxrb");
		this.songNames = getSongNamesFromFiles(
				this.fileList);
		// Log.v("uqnozwujessmbnlbxmbs", "uappfwrsdezaehprzpam");
		this.onScreenListOfSongs = new ArrayAdapter(
				getApplicationContext(), R.layout.song_layout,  R.id.textView,
				this.songNames);
		// Log.d("rcoyqdhxeqqutwkmwwrd", "qweiguruqjwazdfucafe");
		// Log.e("rabmzfpkbbyztnvzvqbw", "nusxzgacqipsyuqhhuug");
		// Log.e("iygylkgnjsdbxpyhoqte", "wzvpfwpvljpciobcwgjs");
		// Log.i("mqijwjvcaqegghthpozc", "ursgclgwjpjhfrnmvyci");
		// Log.d("cltisiprlqbeltkssatg", "vprkhjyabaxipmowidwd");
		this.listview.setAdapter(this.onScreenListOfSongs);
	}

	public boolean onCreateOptionsMenu(Menu paramMenu) {
		// Log.d("vtltqzgxpetpxkoupeps", "fdsxalhxdbvwngfnzlyb");
		// Log.e("nzypzuaxyevadkyifiyk", "lpzzbzsozuryvrxgekps");
		// Log.i("ffcedfttabamtikcbnbh", "eppdnhpozindsukogjyv");
		// Log.w("wqhwvpbrtrwzajbbkbkp", "yoplvadgnjmjtcxhuddp");
		getMenuInflater().inflate(2131558400, paramMenu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
		int i = paramMenuItem.getItemId();
		// Log.d("yrnrvemzltfxzuywfkpk", "wffzpdrllsxpeorjpipz");
		// Log.v("rfvcbuxogcuacxjufiwq", "hudbigpgncquzsxaefuz");
		if (i == 2131493007) {
			return true;
		}
//		Log.d("hcnowvvgpjzzwaxlnrap", "kidwkdpmumxedgtbrbau");
		return super.onOptionsItemSelected(paramMenuItem);
	}

	protected void onResume() {
		super.onResume();
		// Log.i("kbpmrffvahfmuoibzghv", "yumvqkudkfljseukwlhi");
		// Log.i("qeeyujjewdrattrecjwx", "cjafudlscjnuxuvtsmtj");
		// Log.w("ifrpqzvkraobswhgedwc", "swifuqplrqcrnvkntnuo");
		// Log.e("oriyubewzgkxghalptad", "hogombbvtzrvchlnzrmt");
		this.fileList = playList.getPlayList()
				.getFileList();
		// Log.i("aqsemmcegbykhjafgzvv", "nzawnqymrzzwzuaapkqe");
		// Log.d("qnxpdrpetjmvsbndhvmb", "aetuungjvfoecjyqzcrj");
		// Log.v("fbhalqtdakxyatpoenfp", "nzufakfnxogktsawlwcv");
		// Log.i("LogMessage", "Resume is working");
		yfr6694ul54g2323069jx44kv33tbh47257xg2952b654034459297d31g7359a854di911382();
	}

	public void yfr6694ul54g2323069jx44kv33tbh47257xg2952b654034459297d31g7359a854di911382() {
		// Log.i("iblwcbppshaaxtlknocu", "rngiqcnuxvyuvivzvejf");
		// Log.i("zxezqkwzgppmlormgwoa", "hdiddwqagpumdyqgnqzj");
		runOnUiThread(this.nxf52t64k1781j41llalngf51o93ndzbw78u8522f47ikvtxgcl49r57r76uc3783);
	}
}

/*music							dvisjsjfjshd344561
 * musicservice                  dvisjsjfjshd344561gaksdfjapsoidfj poaisdjf 
 *
 * Location:
 * C:\Users\colin\Documents\GitHub\cchr158First\G7.jar!\com\example\owner\
 * musicplayer\
 * MainActivity.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */