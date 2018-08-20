package com.principa.subnetting.easy.MainActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;
import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.principa.subnetting.easy.ActivitiesLogin.ForoActivity;
import com.principa.subnetting.easy.AditionalsFragment;
import com.principa.subnetting.easy.Fragments.CalculatorFragment;
import com.principa.subnetting.easy.Fragments.ClassExampleFragment;
import com.principa.subnetting.easy.Fragments.CreditsFragment;
import com.principa.subnetting.easy.Fragments.GuessFragment;
import com.principa.subnetting.easy.Fragments.SocialNetworksFragment;
import com.principa.subnetting.easy.Fragments.MemoryFragment;
import com.principa.subnetting.easy.Fragments.QuizFragment;
import com.principa.subnetting.easy.Fragments.TheoryFragment;
import com.principa.subnetting.easy.Fragments.VideoFragment;
import com.principa.subnetting.easy.Fragments.PublicPrivateFragment;
import com.principa.subnetting.easy.R;
import com.principa.subnetting.easy.Fragments.TableFragment;
import com.principa.subnetting.easy.Units.UnitFive;
import com.principa.subnetting.easy.Units.UnitFour;
import com.principa.subnetting.easy.Units.UnitOne;
import com.principa.subnetting.easy.Units.UnitThree;
import com.principa.subnetting.easy.Units.UnitTwo;

public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, TheoryFragment.OnFragmentInteractionListener,
        VideoFragment.OnFragmentInteractionListener, CalculatorFragment.OnFragmentInteractionListener,
        MemoryFragment.OnFragmentInteractionListener, CreditsFragment.OnFragmentInteractionListener,
        QuizFragment.OnFragmentInteractionListener, GuessFragment.OnFragmentInteractionListener,
        SocialNetworksFragment.OnFragmentInteractionListener, TableFragment.OnFragmentInteractionListener,
        PublicPrivateFragment.OnFragmentInteractionListener, ClassExampleFragment.OnFragmentInteractionListener,
        AditionalsFragment.OnFragmentInteractionListener{




    String arrayName[] = {"Unit1",
            "Unit2",
            "Unit3",
            "Unit4",
            "Unit5"};

    private CircleMenu circleMenu;
    private Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        circleMenu = findViewById(R.id.circle_menu);

        circleMenu.setMainMenu(Color.parseColor("#CDCDCD"), R.mipmap.icon_menu, R.mipmap.icon_cancel)
                .addSubMenu(Color.parseColor("#76D7C4"), R.drawable.unidad_uno)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {
                    @Override
                    public void onMenuSelected(int index) {
                        if (index == 0) {
                            Toast.makeText(MenuActivity.this, "Unidad 1", Toast.LENGTH_SHORT).show();
                            Intent newFor = new Intent(MenuActivity.this, UnitOne.class);
                            startActivity(newFor);
                        } else {
                            if (index == 1) {
                                Toast.makeText(MenuActivity.this, "Unidad 2", Toast.LENGTH_SHORT).show();
                                Intent newFor = new Intent(MenuActivity.this, UnitTwo.class);
                                startActivity(newFor);
                            } else {

                                if (index == 2) {
                                    Toast.makeText(MenuActivity.this, "Unidad 3", Toast.LENGTH_SHORT).show();
                                    Intent newFor = new Intent(MenuActivity.this, UnitThree.class);
                                    //Esta es la actividad 3 ActivityThreeActivity
                                    startActivity(newFor);

                                }else {

                                    if (index == 3) {
                                        Toast.makeText(MenuActivity.this, "Unidad 4", Toast.LENGTH_SHORT).show();
                                        Intent newFor = new Intent(MenuActivity.this, UnitFour.class);
                                        //Esta es la actividad 4 StepFourActivity
                                        startActivity(newFor);

                                    }else {
                                        if (index == 4) {
                                            Toast.makeText(MenuActivity.this, "Unidad 5", Toast.LENGTH_SHORT).show();
                                            Intent newFor = new Intent(MenuActivity.this, UnitFive.class);
                                            startActivity(newFor);

                                        }
                                    }

                                }
                            }

                        }

                    }
                })
                .addSubMenu(Color.parseColor("#76D7C4"), R.drawable.unidad_dos)
                .addSubMenu(Color.parseColor("#76D7C4"), R.drawable.unidad_tres)
                .addSubMenu(Color.parseColor("#76D7C4"), R.drawable.unidad_cuatro)
                .addSubMenu(Color.parseColor("#76D7C4"),R.drawable.unidad_cinco);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Foros", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent = new Intent(MenuActivity.this, ForoActivity.class);
                startActivity(intent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
      /* DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }*/

        int count = getFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();
            getFragmentManager().popBackStack();
        } else {
            getFragmentManager().popBackStack();
        }
    }

    public void goHome(){
        finish();
        startActivity(new Intent(getApplicationContext(), MenuActivity.class));
    }

    public void other(Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.remove(fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        boolean fragmentoSeleccionado = false;

        if (id == R.id.nav_home) {

            if(fragment!=null){
                Log.i("Fragment: ", fragment.toString());
                other(fragment);
            }

        } else if (id == R.id.nav_calculator) {
            fragment = new CalculatorFragment();
            fragmentoSeleccionado=true;


        } else if (id == R.id.nav_videos) {
            fragment = new VideoFragment();
            fragmentoSeleccionado=true;

        } else if (id == R.id.nav_quiz) {
            fragment = new QuizFragment();
            fragmentoSeleccionado=true;

        } else if (id == R.id.nav_credits) {
            fragment = new CreditsFragment();
            fragmentoSeleccionado=true;


        } else if (id == R.id.nav_memory) {
            fragment = new MemoryFragment();
            fragmentoSeleccionado=true;

        } else if (id == R.id.nav_guess) {
            fragment = new GuessFragment();
            fragmentoSeleccionado=true;


        } else if (id == R.id.nav_foros) {
            fragment = new SocialNetworksFragment();
            fragmentoSeleccionado=true;

        } else if (id == R.id.nav_table) {
            fragment = new TableFragment();
            fragmentoSeleccionado=true;

        }else if (id == R.id.nav_public) {
            fragment = new PublicPrivateFragment();
            fragmentoSeleccionado=true;

        }else if (id == R.id.nav_example) {
            fragment = new ClassExampleFragment();
            fragmentoSeleccionado=true;

        }else if (id == R.id.nav_aditionals) {
            fragment = new AditionalsFragment();
            fragmentoSeleccionado=true;

        } else if (id == R.id.nav_exit) {
            finish();

        }

        if (fragmentoSeleccionado){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main, fragment).commit();
            // getSupportFragmentManager().beginTransaction().add(R.id.content_main, fragment, "fragment_tag").addToBackStack(null).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
