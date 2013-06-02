package com.github.ppaper;

import java.io.Console;
import java.util.Locale;


import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;

public class TabView extends Activity implements ActionBar.TabListener {

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ActionBar.Tab charTab,  diceTab,  rulesTab;
    Fragment      charFrag, diceFrag, rulesFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowTitleEnabled(false);

        charTab  = actionBar.newTab()
                .setText(R.string.action_char_launcher)
                .setTabListener(this);

        diceTab  = actionBar.newTab()
                .setText(R.string.action_dice_launcher)
                .setTabListener(this);

        rulesTab = actionBar.newTab()
                .setText(R.string.action_rules_launcher)
                .setTabListener(this);

        actionBar.addTab(charTab);
        actionBar.addTab(diceTab);
        actionBar.addTab(rulesTab);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tab_view, menu);
        return true;
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        if(tab == charTab)
            Log.d(this.toString(), "charTab");

        if(tab == diceTab){
            Log.d(this.toString(), "dice");

            if(diceFrag == null)
                diceFrag = new DiceView();

            fragmentTransaction.replace(android.R.id.content, diceFrag);

        }

        if(tab == rulesTab)
            Log.d(this.toString(), "rules");
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

}
