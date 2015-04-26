package com.example.cola.myapplication;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.navdrawer.SimpleSideDrawer;


public class MainActivity extends ActionBarActivity implements OnClickListener {

    private SimpleSideDrawer rightSideDrawer, leftSideDrawer;
    private ActionBar actionBar;
    private Button rightBtn, leftBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeVariables();
    }


    private void initializeVariables(){
        actionBar = this.getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        rightSideDrawer = new SimpleSideDrawer(this);
        rightSideDrawer.setRightBehindContentView(R.layout.right_side);
        leftSideDrawer = new SimpleSideDrawer(this);
        leftSideDrawer.setLeftBehindContentView(R.layout.left_side);
        findViews();
        setListeners();

    }

    private void findViews() {
        rightBtn = (Button)findViewById(R.id.right_btn);
        leftBtn = (Button)findViewById(R.id.left_btn);
    }

    private void setListeners() {
        rightBtn.setOnClickListener(this);
        leftBtn.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuList;
        menuList = menu.findItem(R.id.action_settings);
        menuList.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();

        switch (item.getItemId()) {
            case R.id.action_settings:
                rightSideDrawer.toggleRightDrawer();
                return true;
            case android.R.id.home:
                leftSideDrawer.toggleLeftDrawer();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.right_btn:
                Toast.makeText(this, "right side", Toast.LENGTH_SHORT).show();
                break;
            case R.id.left_btn:
                Toast.makeText(this, "left side", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
