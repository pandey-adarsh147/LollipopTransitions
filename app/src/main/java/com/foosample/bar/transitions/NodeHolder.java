package com.foosample.bar.transitions;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by adarshpandey on 3/8/16.
 */
public class NodeHolder extends RecyclerView.ViewHolder {

    public TextView desc;

    public NodeHolder(View itemView) {
        super(itemView);

        desc = (TextView) itemView.findViewById(R.id.title);
    }
}
