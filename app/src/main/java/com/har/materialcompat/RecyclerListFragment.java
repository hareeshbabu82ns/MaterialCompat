package com.har.materialcompat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hareesh on 6/13/15.
 */
public class RecyclerListFragment extends Fragment {
  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    RecyclerView rv = (RecyclerView) inflater.inflate(R.layout.fragment_recycler_list, container,
        false);
    setupRecyclerView(rv);
    return rv;
  }

  private void setupRecyclerView(RecyclerView recyclerView) {
    recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
    recyclerView.setAdapter(new SimpleStringRecyclerAdapter());
  }
}
