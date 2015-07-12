package com.har.materialcompat;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hareesh on 6/14/15.
 */
public class SimpleStringRecyclerAdapter extends RecyclerView.Adapter<SimpleStringRecyclerAdapter.ViewHolder> {

  List<String> strings = new ArrayList<>();

  public SimpleStringRecyclerAdapter() {
    for (int i = 1; i < 1000; i++)
      strings.add("Item " + i);
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.recycler_list_item, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    holder.textView.setText(strings.get(position));
    holder.imageView.setImageURI(Uri.parse("asset:///cheese_1.jpg"));
  }

  @Override
  public int getItemCount() {
    return strings.size();
  }

  public static class ViewHolder extends RecyclerView.ViewHolder {
    TextView textView;
    SimpleDraweeView imageView;

    public ViewHolder(View itemView) {
      super(itemView);
      textView = (TextView) itemView.findViewById(R.id.textView);
      imageView = (SimpleDraweeView) itemView.findViewById(R.id.imageView);
    }

    @Override
    public String toString() {
      return textView.getText().toString();
    }
  }
}
