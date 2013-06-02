package com.github.ppaper;


import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;

public class TabbedViewActivity extends Activity implements ActionBar.TabListener {

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ActionBar.Tab charTab,  diceTab,  rulesTab,  notesTab;
    Fragment      charFrag, diceFrag, rulesFrag, notesFrag;

    public enum FragmentViews{
        CHAR,DICE,RULES,NOTES
    }

    FragmentViews startView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Change the ActionBar, so it will be possible to choose Tabs
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowTitleEnabled(false);

        //Generate new tabs
        charTab  = actionBar.newTab()
                .setText(R.string.action_char_launcher)
                .setTabListener(this);

        diceTab  = actionBar.newTab()
                .setText(R.string.action_dice_launcher)
                .setTabListener(this);

        rulesTab = actionBar.newTab()
                .setText(R.string.action_rules_launcher)
                .setTabListener(this);

        notesTab = actionBar.newTab()
                .setText(R.string.action_notes_launcher)
                .setTabListener(this);

        //Add them to the Actionbar
        actionBar.addTab( charTab);
        actionBar.addTab( diceTab);
        actionBar.addTab(rulesTab);
        actionBar.addTab(notesTab);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tab_view, menu);
        return true;
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

        if(tab == diceTab){
            Log.d(this.toString(), "dice");

            if(diceFrag == null)
                diceFrag = new DiceView();

            fragmentTransaction.replace(android.R.id.content, diceFrag);

        }

        if(tab == rulesTab){
            Log.d(this.toString(), "rules");

            if(rulesFrag == null)
                rulesFrag = new RulesView();

            fragmentTransaction.replace(android.R.id.content, rulesFrag);

        }

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    public void showDiceView(){
        startView = FragmentViews.DICE;
    }

    public void showCharsView(){
        startView = FragmentViews.CHAR;
    }
    public void showNotesView(){
        startView = FragmentViews.NOTES;
    }
    public void showRulesView(){
        startView = FragmentViews.RULES;
    }


}
