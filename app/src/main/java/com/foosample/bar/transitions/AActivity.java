package com.foosample.bar.transitions;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adarshpandey on 3/8/16.
 */
public class AActivity extends ActionBarActivity {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*Transition exitTrans = new Explode();
        exitTrans.setDuration(3000);
        exitTrans.setStartDelay(1000);
        getWindow().setExitTransition(exitTrans);

        Transition enterTrans = new Slide();
        enterTrans.setDuration(3000);
        getWindow().setEnterTransition(enterTrans);*/

        setContentView(R.layout.layout_a);

        View view1 = (View) findViewById(R.id.item0);
        View view2 = (View) findViewById(R.id.item1);

        view1.setTransitionName("item0");
        view2.setTransitionName("item1");

        ((TextView)view1.findViewById(R.id.title)).setText("Start 1");
        ((TextView)view2.findViewById(R.id.title)).setText("Start 2");

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
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
