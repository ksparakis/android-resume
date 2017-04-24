package sparakis.com.ksparakisresume.activities;


import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Locale;


import sparakis.com.ksparakisresume.R;
import sparakis.com.ksparakisresume.fragments.CommentsFragment;
import sparakis.com.ksparakisresume.fragments.EducationFragment;
import sparakis.com.ksparakisresume.fragments.ExperienceFragment;
import sparakis.com.ksparakisresume.fragments.InfoFragment;
import sparakis.com.ksparakisresume.fragments.ProfileFragment;
import sparakis.com.ksparakisresume.fragments.ProjectsFragment;
import sparakis.com.ksparakisresume.fragments.SkillsFragment;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class TabbedActivity extends AppCompatActivity {

        /**
         * The {@link android.support.v4.view.PagerAdapter} that will provide
         * fragments for each of the sections. We use a
         * {@link FragmentPagerAdapter} derivative, which will keep every
         * loaded fragment in memory. If this becomes too memory intensive, it
         * may be best to switch to a
         * {@link android.support.v4.app.FragmentStatePagerAdapter}.
         */
        private SectionsPagerAdapter mSectionsPagerAdapter;

        /**
         * The {@link ViewPager} that will host the section contents.
         */
        private ViewPager mViewPager;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);


            android.support.v7.app.ActionBar actionBar = getSupportActionBar();
            LayoutInflater inflator = (LayoutInflater) this .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = inflator.inflate(R.layout.actionbar_custom, null);
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            actionBar.setCustomView(v);



            /*
            // Inflate your custom layout
            final ViewGroup actionBarLayout = (ViewGroup) getLayoutInflater().inflate(
                    R.layout.actionbar_custom,
                    null);

            // Set up your ActionBar
            final ActionBar actionBar = getActionBar();
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayShowCustomEnabled(true);
            actionBar.setCustomView(actionBarLayout);
            */

            // Create the adapter that will return a fragment for each of the three
            // primary sections of the activity.
            mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

            // Set up the ViewPager with the sections adapter.
            mViewPager = (ViewPager) findViewById(R.id.view_pager);
            mViewPager.setAdapter(mSectionsPagerAdapter);

            TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
            tabLayout.setTabsFromPagerAdapter(mSectionsPagerAdapter);
            tabLayout.setupWithViewPager(mViewPager);


        }


        @Override
        protected void attachBaseContext(Context newBase) {
            super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
           // getMenuInflater().inflate(R.menu.menu_tabbed, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();


            return super.onOptionsItemSelected(item);
        }

        /**
         * A placeholder fragment containing a simple view.
         */
        public static class PlaceholderFragment extends Fragment {
            /**
             * The fragment argument representing the section number for this
             * fragment.
             */
            private static final String ARG_SECTION_NUMBER = "section_number";

            public PlaceholderFragment() {
            }

            /**
             * Returns a new instance of this fragment for the given section
             * number.
             */
            public static PlaceholderFragment newInstance(int sectionNumber) {
                PlaceholderFragment fragment = new PlaceholderFragment();
                Bundle args = new Bundle();
                args.putInt(ARG_SECTION_NUMBER, sectionNumber);
                fragment.setArguments(args);
                return fragment;
            }

            @Override
            public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                     Bundle savedInstanceState) {
                View rootView = inflater.inflate(R.layout.fragment_tabbed, container, false);
                TextView textView = (TextView) rootView.findViewById(R.id.section_label);
                textView.setText("");
                return rootView;
            }
        }

        /**
         * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
         * one of the sections/tabs/pages.
         */
        public class SectionsPagerAdapter extends FragmentPagerAdapter {

            public SectionsPagerAdapter(FragmentManager fm) {
                super(fm);
            }


            @Override
            public Fragment getItem(int position) {

                Fragment fragment = null;
                switch(position){
                    case 0:
                        return new ProfileFragment();

                    case 1:
                        return new EducationFragment();

                    case 2:
                        return new ExperienceFragment();

                    case 3:
                        return new ProjectsFragment();

                    case 4:
                        return new CommentsFragment();


                }
                return new ProfileFragment();
            }

            @Override
            public int getCount() {
                // Show 5 total pages.
                return 5;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                Locale l = Locale.getDefault();
                switch (position) {
                    case 0:
                        return "About Me";
                    case 1:
                        return "Education";
                    case 2:
                        return "Experience";
                    case 3:
                        return "Projects";
                    case 4:
                        return "Comments";
                }
                return null;
            }
        }
}



