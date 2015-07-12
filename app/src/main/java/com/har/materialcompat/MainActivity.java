package com.har.materialcompat;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

  NavigationView mNavigationView;
  DrawerLayout mDrawer;
  private Toolbar mToolbar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mDrawer = (DrawerLayout) findViewById(R.id.drawer);

    //attach the mToolbar to activity
    mToolbar = (Toolbar) findViewById(R.id.toolbar);
    mToolbar.setTitle(R.string.app_title);
//    mToolbar.setLogo(android.R.drawable.ic_menu_compass);

    //initiate navigation drawer view
    mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
    mNavigationView.setNavigationItemSelectedListener(this);

    setSupportActionBar(mToolbar);

    //add the toggling
    final ActionBar ab = getSupportActionBar();
    ab.setHomeAsUpIndicator(R.drawable.ic_action_menu_light);
    ab.setDisplayHomeAsUpEnabled(true);

    //setup FAB
    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
            .setAction("Action", null).show();
      }
    });

    TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

    //init Tabs
    ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
    if (viewPager != null) {
      setupViewPager(viewPager);
      tabLayout.setupWithViewPager(viewPager);
    }
  }

  private void setupViewPager(ViewPager viewPager) {
    SimplePagerAdapter adapter = new SimplePagerAdapter(getSupportFragmentManager());
    adapter.addFragment(new RecyclerListFragment(), "Contacts");
    adapter.addFragment(new RecyclerListFragment(), "People");
    adapter.addFragment(new RecyclerListFragment(), "Students");
    viewPager.setAdapter(adapter);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    switch (id) {
      case R.id.action_settings:
        return true;
      case R.id.action_sub_activity:
        //explicit intent (with-in APP)
        Intent intent = new Intent(this, BaseWidgetsActivity.class);
        startActivity(intent);
        return true;
      case android.R.id.home:
        mDrawer.openDrawer(GravityCompat.START);
        return true;
    }

    return super.onOptionsItemSelected(item);
  }

  @Override
  public boolean onNavigationItemSelected(MenuItem menuItem) {
    menuItem.setChecked(true);
    mDrawer.closeDrawer(GravityCompat.START);
    switch (menuItem.getItemId()) {
      case R.id.nav_item_widgets:
        startActivity(new Intent(this, BaseWidgetsActivity.class));
        return true;
      case R.id.nav_item_ctoolbar:
        startActivity(new Intent(this, CollapsingToolBarActivity.class));
        return true;
    }
    return false;
  }

  @Override
  protected void onStart() {
    super.onStart();
    Fresco.initialize(this);
  }

  static class SimplePagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragments = new ArrayList<>();
    private final List<String> mFragmentTitles = new ArrayList<>();

    public SimplePagerAdapter(FragmentManager fm) {
      super(fm);
    }

    public void addFragment(Fragment fragment, String title) {
      mFragments.add(fragment);
      mFragmentTitles.add(title);
    }

    @Override
    public Fragment getItem(int position) {
      return mFragments.get(position);
    }

    @Override
    public int getCount() {
      return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
      return mFragmentTitles.get(position);
    }
  }
}
