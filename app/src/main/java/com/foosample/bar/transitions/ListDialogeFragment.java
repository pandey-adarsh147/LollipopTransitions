package com.foosample.bar.transitions;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adarshpandey on 3/8/16.
 */
public class ListDialogeFragment extends Fragment {

    private RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setStyle(STYLE_NO_FRAME, android.R.style.Theme_Holo_Light);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_a, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        View view1 = (View) getView().findViewById(R.id.item0);
        View view2 = (View) getView().findViewById(R.id.item1);

        view1.setTransitionName("item0");
        view2.setTransitionName("item1");

        ((TextView)view1.findViewById(R.id.title)).setText("Start 1");
        ((TextView)view2.findViewById(R.id.title)).setText("Start 2");

        recyclerView = (RecyclerView) getView().findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        List<DataNode> dataNodes = new ArrayList<>();

        DataNode dataNode = new DataNode();
        dataNode.description = "Start 1";
        dataNodes.add(dataNode);

        dataNode = new DataNode();
        dataNode.description = "Start 2";
        dataNodes.add(dataNode);

        dataNode = new DataNode();
        dataNode.description = "Start 3";
        dataNodes.add(dataNode);

        dataNode = new DataNode();
        dataNode.description = "Start 4";
        dataNodes.add(dataNode);

        final MyAdapter myAdapter = new MyAdapter(dataNodes);

        Handler handler = new Handler();
        recyclerView.setAdapter(myAdapter);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        }, 2000);
    }
}
