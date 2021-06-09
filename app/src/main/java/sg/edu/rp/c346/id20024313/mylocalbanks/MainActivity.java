package sg.edu.rp.c346.id20024313.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnDBS;
    Button btnOCBC;
    Button btnUOB;
    String btnClicked = "";
    boolean favDBS = false;
    boolean favOCBC = false;
    boolean favUOB = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDBS = findViewById(R.id.btnDBS);
        registerForContextMenu(btnDBS);
        btnOCBC = findViewById(R.id.btnOCBC);
        registerForContextMenu(btnOCBC);
        btnUOB = findViewById(R.id.btnUOB);
        registerForContextMenu(btnUOB);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the bank");
        menu.add(0, 2, 2, "Colour");
        if (v == btnDBS) {
            btnClicked = "DBS";
        } else if (v == btnOCBC) {
            btnClicked = "OCBC";
        } else if (v == btnUOB) {
            btnClicked = "UOB";
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (btnClicked.equalsIgnoreCase("DBS")) {
            if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);
                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) { //check if the selected menu item}
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+18001111111"));
                startActivity(intentCall);
                return true;
            } else if (item.getItemId() == 2) { //check if the selected menu item}

                if (favDBS) {
                    btnDBS.setTextColor(Color.BLACK);
                    favDBS = false;
                } else {
                    btnDBS.setTextColor(Color.RED);
                    favDBS = true;
                }
                return true;}
        } else if (btnClicked.equalsIgnoreCase("OCBC")) {
            if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intent);
                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) { //check if the selected menu item}
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+18003633333"));
                startActivity(intentCall);
                return true;
            } else if (item.getItemId() == 2) { //check if the selected menu item}

                if (favOCBC) {
                    btnOCBC.setTextColor(Color.BLACK);
                    favOCBC = false;
                } else {
                    btnOCBC.setTextColor(Color.RED);
                    favOCBC = true;
                }
                return true;}
        } else if (btnClicked.equalsIgnoreCase("UOB")) {
            if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);
                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) { //check if the selected menu item}
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+18002222121"));
                startActivity(intentCall);
                return true;
            } else if (item.getItemId() == 2) { //check if the selected menu item}

                if (favUOB) {
                    btnUOB.setTextColor(Color.BLACK);
                    favUOB = false;
                } else {
                    btnUOB.setTextColor(Color.RED);
                    favUOB = true;
                }
                return true; }
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        // Handle action bar item clicks here.
        int id = item.getItemId();
        if (id == R.id.englishSelection) {
            btnDBS.setText("DBS ");
            btnOCBC.setText("OCBC");
            btnUOB.setText("UOB");
            return true;
        } else if (id == R.id.chineseSelection) {
            btnDBS.setText("星展银行");
            btnOCBC.setText("华侨银行");
            btnUOB.setText("大华银行");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}