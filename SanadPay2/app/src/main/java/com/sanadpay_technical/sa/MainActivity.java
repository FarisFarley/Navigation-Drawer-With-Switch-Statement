package com.sanadpay_technical.sa;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.internal.NavigationMenuView;
import com.google.android.material.navigation.NavigationView;
import com.sanadpay_technical.sa.ui.Aggregations;
import com.sanadpay_technical.sa.ui.Consumeable_Custodies;
import com.sanadpay_technical.sa.ui.Customer_Reports;
import com.sanadpay_technical.sa.ui.Dashboard;
import com.sanadpay_technical.sa.ui.Requests;
import com.sanadpay_technical.sa.ui.Sim_Custodies;
import com.sanadpay_technical.sa.ui.Sla_Reports;
import com.sanadpay_technical.sa.ui.Stock_Reports;
import com.sanadpay_technical.sa.ui.Terminal_Custodies;
import com.sanadpay_technical.sa.ui.Tickets;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavigationView navigationView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);

        disableNavigationViewScrollbars(navigationView);
        setSupportActionBar(toolbar);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main, new Dashboard()).commit();
            navigationView.setCheckedItem(R.id.nav_dashboard);
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.nav_dashboard:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main, new Dashboard()).commit();
                break;

            case R.id.nav_requests:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main, new Requests()).commit();
                break;

            case R.id.nav_tickets:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main, new Tickets()).commit();
                break;

            case R.id.nav_aggregations:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main, new Aggregations()).commit();
                break;

            case R.id.nav_customer_report:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main, new Customer_Reports()).commit();
                break;

            case R.id.nav_sla_reports:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main, new Sla_Reports()).commit();
                break;

            case R.id.nav_stock_reports:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main, new Stock_Reports()).commit();
                break;

            case R.id.nav_consumeable_custodies:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main, new Consumeable_Custodies()).commit();
                break;

            case R.id.nav_sim_custodies:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main, new Sim_Custodies()).commit();
                break;

            case R.id.nav_terminal_custodies:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main, new Terminal_Custodies()).commit();
                break;

            default:
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }


    private void disableNavigationViewScrollbars(NavigationView navigationView) {
        if (navigationView != null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) navigationView.getChildAt(0);
            if (navigationMenuView != null) {
                navigationMenuView.setVerticalScrollBarEnabled(false);
            }
        }
    }
}
