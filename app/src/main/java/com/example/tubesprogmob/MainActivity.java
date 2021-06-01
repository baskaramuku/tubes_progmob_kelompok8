package com.example.tubesprogmob;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public DataAdapter dataAdapter;
    public RecyclerView recyclerView;
    public ArrayList dataModelArrayList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //mengambil data yang dikirimkan
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        DataModel dataModel = (DataModel) bundle.getSerializable("dataModel");
        String pilihan=""+dataModel.getKonten();
        //membuat data yang akan ditampilkan dalam list
        //file .html mengambil di folder assets


        if(pilihan.equals("ap")) {
            //appetizer
            inputData("Mandu", "mandu.html");
            inputData("Rice Cake", "teokbokki.html");
            inputData("Teokkebi", "teokkebi.html");
            inputData("Onion Ring", "Onion ring.html");
            inputData("Agedashi Tofu", "agedashi tofu.html");
            inputData("Algamja Jorim", "algamjajorim.html");
            inputData("Chawan Mushi", "cawan mushi.html");
            inputData("Martabak Telur", "martabak telur.html");
            inputData("Potato Salad with Boiled Egg", "potato salad with boled egg.html");
            inputData("Selada Banjar", "selada banjar.html");
            inputData("Serabi", "serabi.html");
            inputData("Siomay Ikan", "siomay ikan.html");
        }else if(pilihan.equals("mc")) {
            //main course
            inputData("Creamy Tomyan", "Creamy Tomyam.html");
            inputData("Nasi Goreng", "nasi goreng.html");
            inputData("Sandwich", "sandwich.html");
            inputData("Sup Ikan", "Sup ikan.html");
            inputData("Ikan Bakar", "Ikan Bakar.html");
            inputData("Cumi Asam Manis", "Cumi asam manis.html");
            inputData("Ratatouille", "Ratatouille.html");
            inputData("Foire Gras", "Foire Gras.html");
            inputData("Rice with Beef Teriyaki", "Rice with beef teriyaki.html");
            inputData("Spaghetti Carbonara", "Spaghetti Carbonara.html");
            inputData("Soto Ayam", "soto ayam.html");
            inputData("Lasagna", "Lasagna.html");
            inputData("Salmon Grilled Honey Sauce", "Salmon Grilled Honey Sauce.html");
            inputData("Chicken Parmigiana", "Chicken Parmigiana.html");
            inputData("Shirataki Salmon Mentai", "Shirataki Salmon Mentai.html");

        }else if(pilihan.equals("ds")) {
            //Dessert
            inputData("Pancake Mangga", "Pancake mangga.html");
            inputData("Bolu Gulung", "Bolu Gulung.html");
            inputData("Mango Cheesecake", "Mango Cheesecake.html");
            inputData("Milo Lava Cake", "Milo Lava Cake.html");
            inputData("Chocolate Panna Cotta", "Chocolate Panna Cotta..html");
            inputData("No-Bake Oreo Cheesecake", "No-bake Oreo Cheesecake.html");
            inputData("Choco Brownies Pudding", "Choco brownies pudding..html");
            inputData("Pudding Lumut", "Puding lumut.html");
            inputData("Pudding Milo Oreo", "Pudding Milo Oreo.html");
            inputData("Banana Milk Crispy", "Banana milk crispy..html");
            inputData("Waffle Banana Caramel", "Waffle banana caramel..html");
        }else if(pilihan.equals("dr")) {
            //drinks
            inputData("Apple Cooler", "Es apple cooler.html");
            inputData("Patbingsoo", "es patbingso.html");
            inputData("Oreo Frappucino", "es oreo frappucino.html");
            inputData("Milkshake Redvelvet", "es milshake redvelvet.html");
            inputData("Mango Thai", "es mango thai.html");
            inputData("Thai Tea", "thai_tea.html");
            inputData("Es Coffee Boba", "es coffe boba.html");
            inputData("Es Cream Cheese", "es cream cheese.html");
            inputData("Es Jeruk Sirup Melon", "es_jeruk_sirub_melon.html");
            inputData("Es Mangga Jelly", "es_mangga_jelly.html");
            inputData("Es Soda Gembira", "es_soda_gembira.html");
            inputData("Es Timun Nata De Coco", "es_timun_nata_de_coco.html");
        }else{
            Toast.makeText(getApplicationContext(),"coba lagi", Toast.LENGTH_LONG).show();


        }




        //menampilkan data ke dalam recyclerView
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        dataAdapter = new DataAdapter(this, dataModelArrayList);
        recyclerView.setAdapter(dataAdapter);

        /*//menambahakan header
        DataModel headerModel = new DataModel();
        headerModel.setViewType(2);
        dataModelArrayList.add(0, headerModel);*/

        //menambahkan footer
        DataModel footerModel = new DataModel();
        footerModel.setViewType(2);
        dataModelArrayList.add(footerModel);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

    }

    //fungsi input
    public void inputData(String judul, String konten) {
        DataModel dataModel = new DataModel();
        dataModel.setJudul(judul);
        dataModel.setKonten(konten);
        dataModel.setViewType(1);
        dataModelArrayList.add(dataModel);
    }

    public static void setWindowFlag(Activity activity, final int bits, boolean on) {
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

}