package com.example.catchexpenses;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
//For Reading SMS
import android.content.Intent;
import android.net.Uri;
import android.database.Cursor;
import android.util.Log;

public class MessagesActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_messages);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.messages, menu);
		this.displaySmsLog();
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_messages,
					container, false);
			return rootView;
		}
	}
	private void displaySmsLog() {
	    Uri allMessages = Uri.parse("content://sms/");
	     //Cursor cursor = managedQuery(allMessages, null, null, null, null); Both are same
	    Cursor cursor = this.getContentResolver().query(allMessages, null,
	            null, null, null);

	    while (cursor.moveToNext()) {
	        for (int i = 0; i < cursor.getColumnCount(); i++) {
	            Log.e(cursor.getColumnName(i) + "",  cursor.getString(i) + "");
	        }
	        Log.e("One row finished",
	                "**************************************************");
	    }
	}
}
