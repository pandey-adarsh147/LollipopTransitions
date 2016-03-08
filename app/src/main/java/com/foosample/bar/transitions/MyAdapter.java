package com.foosample.bar.transitions;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by adarshpandey on 3/8/16.
 */
public class MyAdapter extends RecyclerView.Adapter<NodeHolder> {

    private List<DataNode> dataNodes;

    public MyAdapter(List<DataNode> dataNodes) {
        this.dataNodes = dataNodes;
    }

    @Override
    public NodeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.row_item, parent, false);
        return new NodeHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NodeHolder holder, int position) {
        DataNode dataNode = dataNodes.get(position);
        holder.desc.setText(dataNode.description);
        holder.desc.setTransitionName("item" + position);
    }

    @Override
    public int getItemCount() {
        return dataNodes.size();
    }
}
