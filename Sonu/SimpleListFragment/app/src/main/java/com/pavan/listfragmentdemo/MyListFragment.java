package com.pavan.listfragmentdemo;

import android.annotation.SuppressLint;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Toast;

@SuppressLint("NewApi")
public class MyListFragment extends ListFragment implements OnItemClickListener {

	String str[] = { "a", "b", "c" };

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.list_fragment, container, false);

		return view;

	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);

		ArrayAdapter<CharSequence> aa = ArrayAdapter.createFromResource(
				getActivity(), R.array.Planets,
				android.R.layout.simple_list_item_1);

		setListAdapter(aa);
		getListView().setOnItemClickListener(this);

	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View view, int position,
			long id) {

		String[] Itemname = getResources().getStringArray(R.array.Planets);

		Toast.makeText(getActivity(), Itemname[position], Toast.LENGTH_SHORT)
				.show();

	}

}
