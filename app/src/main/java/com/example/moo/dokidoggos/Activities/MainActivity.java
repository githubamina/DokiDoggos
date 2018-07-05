package com.example.moo.dokidoggos.Activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.moo.dokidoggos.Helpers.BottomNavHelper;
import com.example.moo.dokidoggos.MainFragments.BehaviourFragment;
import com.example.moo.dokidoggos.MainFragments.CarersFragment;
import com.example.moo.dokidoggos.MainFragments.DietFragment;
import com.example.moo.dokidoggos.MainFragments.FunFragment;
import com.example.moo.dokidoggos.MainFragments.GroomingFragment;
import com.example.moo.dokidoggos.MainFragments.MedicalFragment;
import com.example.moo.dokidoggos.MainFragments.PetProfileFragment;
import com.example.moo.dokidoggos.MainFragments.SocialFragment;
import com.example.moo.dokidoggos.R;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Instance of menu for toolbar menu items
    private Menu toolbarManu;

    //Instance of NavigationView to be used for the app's nav drawer
    public NavigationView navigationView;

    //Int variable to store the current menuItemId
    //used to prevent duplicate fragments being opened
    private int menuItemId;


    private BottomNavigationView bottomNavigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Set layout to activity_main
        setContentView(R.layout.activity_main);

        //Inflate toolbar from tool_bar_main.xml
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        assert toolbar != null;
        setSupportActionBar(toolbar);

        /**
         * Disable the app title from displaying in the action bar
         * so that the logo and menu item icons can be displayed instead
         */
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //Set the app logo (from the drawables file) to appear in the action bar
        toolbar.setLogo(R.drawable.logo);

        //Inflate drawer_layout from activity_main.xml layout to instance of DrawerLayout
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);


        bottomNavigation = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //Disable default bottom navigation shift animation using helper class
        BottomNavHelper.disableShiftMode(bottomNavigation);
        //Disable bottom navigation icon default tint behaviour
        bottomNavigation.setItemIconTintList(null);

        //Prevent bottom nav items from being checked
        bottomNavigation.getMenu().setGroupCheckable(0, false, false);

        //bottomNavigation.getMenu().getItem(0).setChecked(false);






        /**
         * Instance of ActionBarDrawerToggle to be used on drawer with addDrawerListener to open and close the
         * navigation drawer when the menu icon in the toolbar is pressed
         */
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        /**
         * If drawer contains a layout, call 'addDrawerListener' on it and pass in toggle
         * to listen for drawer open and close events so that when the user presses the
         * menu icon in the toolbar, the navigation drawer opens or closes
         */
        if (drawer != null) {
            drawer.addDrawerListener(toggle);
        }

        /**Call syncState() on toggle to sync the current state of the drawer toggle **/
        toggle.syncState();


        /**Inflate nav_view from activity_main.xml to instance of NavigationView **/
        navigationView = findViewById(R.id.nav_view);

        /** If navigationView contains a NavigationView layout,
         * call setNavigationItemSelectedLister() on navigationView to listen for
         * navigation drawer item selections
         */
        if(navigationView != null) {
            navigationView.setNavigationItemSelectedListener(this);
        }

        openPetFrag();

        setIcon(0);


    }



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {


                case R.id.nav_pets:

                    setIcon(0);

                    openPetFrag();


                    return true;
                case R.id.nav_diet:

                    setIcon(1);

                    openDietFrag();
                    return true;
                case R.id.nav_fun:

                    setIcon(2);

                    openFunFrag();
                    return true;
                case R.id.nav_medical:

                    setIcon(3);

                    openMedicalFrag();
                    return true;
            }
            return false;
        }
    };



    /**
     * onNavigationItemSelected handles menu item selections in the navigation drawer
     * @param item is the selected menu item in the navigation drawer
     */

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        //Inflate drawer layout from activity_main.xml
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        //Get the currently selected item's Id, and use switch statement
        //to carry out appropriate actions for selected item
        switch (item.getItemId()) {

            case R.id.nav_pets:
                drawer.closeDrawer(GravityCompat.START);
                setIcon(0);
                //Open MainFragment
                openPetFrag();

                return true;

            case R.id.nav_diet:

                drawer.closeDrawer(GravityCompat.START);

                setIcon(1);
                //Open MainFragment
                openDietFrag();

                return true;
            case R.id.nav_fun:
                drawer.closeDrawer(GravityCompat.START);

                setIcon(2);
                //Open MainFragment
                openFunFrag();

                return true;


            case R.id.nav_medical:
                drawer.closeDrawer(GravityCompat.START);
                setIcon(3);

                //Open MainFragment
                openMedicalFrag();

                return true;

            case R.id.nav_grooming:
                drawer.closeDrawer(GravityCompat.START);

                setIcon(4);
                //Open MainFragment
                openGroomingFrag();

                return true;



            case R.id.nav_social:
                drawer.closeDrawer(GravityCompat.START);

                setIcon(4);
                //Open MainFragment
                openSocialFrag();

                return true;

            case R.id.nav_behaviour:
                drawer.closeDrawer(GravityCompat.START);

                setIcon(4);

                //Open MainFragment
                openBehaviourFrag();

                return true;

            case R.id.nav_carers:
                drawer.closeDrawer(GravityCompat.START);

                setIcon(4);
                bottomNavigation.getMenu().setGroupCheckable(0, false, false);
                //Open MainFragment
                openCarersFrag();

                return true;

            default:
                return false;

        }
    }

    /**
     * Helper method that takes in an int representing the id of the current
     * menu item and updates the action bar icons to reflect the current selection
     * also sets the corresponding navigation drawer item to be checked
     * @param itemId id int of the current menu item selection
     */
    public void setIcon(int itemId){

        Menu menu = bottomNavigation.getMenu();

        switch(itemId){
            case 0:
                menu.getItem(0).setIcon(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_pets2));
                menu.getItem(1).setIcon(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_diet));
                menu.getItem(2).setIcon(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_fun));
                menu.getItem(3).setIcon(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_medical));
                break;
            case 1:
                menu.getItem(0).setIcon(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_pets));
                menu.getItem(1).setIcon(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_diet2));
                menu.getItem(2).setIcon(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_fun));
                menu.getItem(3).setIcon(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_medical));
                break;
            case 2:
                menu.getItem(0).setIcon(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_pets));
                menu.getItem(1).setIcon(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_diet));
                menu.getItem(2).setIcon(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_fun2));
                menu.getItem(3).setIcon(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_medical));
                break;
            case 3:
                menu.getItem(0).setIcon(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_pets));
                menu.getItem(1).setIcon(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_diet));
                menu.getItem(2).setIcon(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_fun));
                menu.getItem(3).setIcon(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_medical2));
                break;
            default:
                menu.getItem(0).setIcon(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_pets));
                menu.getItem(1).setIcon(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_diet));
                menu.getItem(2).setIcon(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_fun));
                menu.getItem(3).setIcon(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_medical));
        }
    }











    public void openPetFrag() {
        //Create instance of MainFragment
        PetProfileFragment mainFragment = new PetProfileFragment();
        //Create Fragment Manager instance
        FragmentManager manager = getSupportFragmentManager();
        //Replace current fragment in location_fragment with mainFragment
        manager.beginTransaction()
                .replace(R.id.container_fragment, mainFragment)
                .commit();
    }






    /**
     * Method to be called when the diet menu item is selected
     * Opens the diet fragment
     */
    public void openDietFrag() {
        //Create instance of DietFragment
        DietFragment dietFragment = new DietFragment();
        //Create FragmentManager instance
        FragmentManager manager = getSupportFragmentManager();
        //Replace current fragment in container_fragment with dietFragment
        manager.beginTransaction()
                .replace(R.id.container_fragment, dietFragment)
                .commit();

    }

    /**
     * Method to be called when the diet menu item is selected
     * Opens the diet fragment
     */
    public void openFunFrag() {
        //Create instance of DietFragment
        FunFragment funFragment = new FunFragment();
        //Create FragmentManager instance
        FragmentManager manager = getSupportFragmentManager();
        //Replace current fragment in container_fragment with dietFragment
        manager.beginTransaction()
                .replace(R.id.container_fragment, funFragment)
                .commit();

    }

    /**
     * Method to be called when the diet menu item is selected
     * Opens the diet fragment
     */
    public void openGroomingFrag() {
        //Create instance of DietFragment
        GroomingFragment groomingFragment = new GroomingFragment();
        //Create FragmentManager instance
        FragmentManager manager = getSupportFragmentManager();
        //Replace current fragment in container_fragment with dietFragment
        manager.beginTransaction()
                .replace(R.id.container_fragment, groomingFragment)
                .commit();

    }


    /**
     * Method to be called when the diet menu item is selected
     * Opens the diet fragment
     */
    public void openMedicalFrag() {
        //Create instance of DietFragment
        MedicalFragment medicalFragment = new MedicalFragment();
        //Create FragmentManager instance
        FragmentManager manager = getSupportFragmentManager();
        //Replace current fragment in container_fragment with dietFragment
        manager.beginTransaction()
                .replace(R.id.container_fragment, medicalFragment)
                .commit();

    }


    /**
     * Method to be called when the diet menu item is selected
     * Opens the diet fragment
     */
    public void openSocialFrag() {
        //Create instance of DietFragment
        SocialFragment socialFragment = new SocialFragment();
        //Create FragmentManager instance
        FragmentManager manager = getSupportFragmentManager();
        //Replace current fragment in container_fragment with dietFragment
        manager.beginTransaction()
                .replace(R.id.container_fragment, socialFragment)
                .commit();

    }

    /**
     * Method to be called when the diet menu item is selected
     * Opens the diet fragment
     */
    public void openCarersFrag() {
        //Create instance of DietFragment
        CarersFragment carersFragment = new CarersFragment();
        //Create FragmentManager instance
        FragmentManager manager = getSupportFragmentManager();
        //Replace current fragment in container_fragment with dietFragment
        manager.beginTransaction()
                .replace(R.id.container_fragment, carersFragment)
                .commit();

    }

    /**
     * Method to be called when the diet menu item is selected
     * Opens the diet fragment
     */
    public void openBehaviourFrag() {
        //Create instance of DietFragment
        BehaviourFragment behaviourFragment = new BehaviourFragment();
        //Create FragmentManager instance
        FragmentManager manager = getSupportFragmentManager();
        //Replace current fragment in container_fragment with dietFragment
        manager.beginTransaction()
                .replace(R.id.container_fragment, behaviourFragment)
                .commit();

    }

}
