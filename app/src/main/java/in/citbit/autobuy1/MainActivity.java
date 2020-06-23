package in.citbit.autobuy1;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Log.d("taggggg", menuItem.toString());
                int id = menuItem.getItemId();
                switch (id) {
                    case R.id.menu_9_pro_max:
                        MainActivity.this.startActivity("amazon", "https://amzn.to/3fBkYkb");
                        Toast.makeText(MainActivity.this, "menu_9_pro_max", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_redmi_8A:
                        MainActivity.this.startActivity("amazon", "https://amzn.to/2UM3Z6F");
                        Toast.makeText(MainActivity.this, "menu_redmi_8A", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_menu_note_9_pro:
                        MainActivity.this.startActivity("amazon", "https://amzn.to/3hss5gq");
                        Toast.makeText(MainActivity.this, "nav_menu_note_9_pro", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.vivo_u10:
                        MainActivity.this.startActivity("amazon", "https://amzn.to/37Wn3V5");
                        Toast.makeText(MainActivity.this, "nav_menu_note_9_pro", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.vivou20:
                        MainActivity.this.startActivity("amazon", "https://amzn.to/2AUeyxT");
                        Toast.makeText(MainActivity.this, "nav_menu_note_9_pro", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.vivoy91i:
                        MainActivity.this.startActivity("amazon", "https://amzn.to/3fTPnua");
                        Toast.makeText(MainActivity.this, "nav_menu_note_9_pro", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.y2:
                        MainActivity.this.startActivity("amazon", "https://amzn.to/3hV4Mfq");
                        Toast.makeText(MainActivity.this, "nav_menu_note_9_pro", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.y1:
                        MainActivity.this.startActivity("amazon", "https://www.amazon.in/Redmi-Grey-3GB-32GB-Storage/dp/B0756ZJ1FN?tag=citbit010d-21");
                        Toast.makeText(MainActivity.this, "nav_menu_note_9_pro", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        return true;
                }


                return true;
            }
        });
//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                Log.d("taggggg", item.toString());
//                int id = item.getItemId();
//                switch (id) {
//                    case R.id.menu_9_pro_max:
//                        Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.menu_redmi_8A:
//                        Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.nav_menu_note_9_pro:
//                        Toast.makeText(MainActivity.this, "My Cart", Toast.LENGTH_SHORT).show();
//                        break;
//                    default:
//                        return true;
//                }
//
//
//                return true;
//
//            }
//        });
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations...
//        mAppBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
//                R.id.nav_tools, R.id.nav_share)
//                .setDrawerLayout(drawer)
//                .build();
//
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
//        NavigationUI.setupWithNavController(navigationView, navController);
    }

    public void startActivity(String sitename, String variantLink) {
        Intent intent = new Intent(this, WebViewActivity.class);
        intent.putExtra(getString(R.string.site_name), sitename);
        intent.putExtra(getString(R.string.variant_link), variantLink);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
