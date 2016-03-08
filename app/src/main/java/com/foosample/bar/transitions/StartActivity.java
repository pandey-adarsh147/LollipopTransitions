package com.foosample.bar.transitions;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBarActivity;
import android.util.Pair;
import android.view.View;
import android.widget.Button;

/**
 * Created by adarshpandey on 3/8/16.
 */
public class StartActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_b);

        final Button button1 = (Button) findViewById(R.id.item1);
        final Button button2 = (Button) findViewById(R.id.item2);


        ViewCompat.setTransitionName(button1, "item0");
        ViewCompat.setTransitionName(button2, "item1");
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                        StartActivity.this, button1, "item0");
                Intent intent = new Intent(StartActivity.this, AActivity.class);
                startActivity(intent, options.toBundle());

                /*ListDialogeFragment listDialogeFragment = new ListDialogeFragment();

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.addSharedElement(button1, "item0").add(R.id.main_layout, listDialogeFragment).addToBackStack(null).commitAllowingStateLoss();*/

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                        StartActivity.this, new Pair<View, String>(button1, "item0"),
                        new Pair(button2, "item1"));
                Intent intent = new Intent(StartActivity.this, AActivity.class);
                startActivity(intent, options.toBundle());

                /*ListDialogeFragment listDialogeFragment = new ListDialogeFragment();

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.addSharedElement(button2, "item1").add(R.id.main_layout, listDialogeFragment).addToBackStack(null).commitAllowingStateLoss();*/
            }
        });
    }
}
