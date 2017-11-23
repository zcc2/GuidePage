package com.example.zcc.guidepage.tip_view;
import android.content.Context;
import android.content.SharedPreferences;


public class StoreUtils {
	private Context context;

	public StoreUtils(Context context) {
		this.context = context;

	}

	boolean hasShown(int id) {
		return context.getSharedPreferences("showtips", Context.MODE_PRIVATE).getBoolean("id" + id, false);
	}

	void storeShownId(int id) {
		SharedPreferences internal = context.getSharedPreferences("showtips", Context.MODE_PRIVATE);
		internal.edit().putBoolean("id" + id, true).apply();
	}
}
