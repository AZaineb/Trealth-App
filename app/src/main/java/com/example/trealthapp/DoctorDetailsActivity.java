package com.example.trealthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String [][] doctor_details1={
            {"Doctor Name :  Yosr KAMARTI","Hospital Address: Centre Apollo Medical","Mobile Number: 71.842.500","Exp: 5yrs"},
            {"Doctor Name :  Majed HAMMAMI","Hospital Address: El Mourouj","Mobile Number: 54.910.060","Exp: 20yrs"},
            {"Doctor Name :  Hend BELHAOUANE","Hospital Address: Denden 2011 Mannouba","Mobile Number: 71.606.999","Exp: 20yrs"},
            {"Doctor Name :  Rabaa MATHLOUTHI","Hospital Address: El Manar 2","Mobile Number: 20.999.352","Exp: 30yrs"}
    };
    private String [][] doctor_details2={
            {"Doctor Name :  Yosra BORNAZ","Hospital Address: Centre Urbain Nord","Mobile Number: 25.486.058","Exp: 10yrs"},
            {"Doctor Name :  Maha SIALA JEMAL","Hospital Address: Cité El Ghazala","Mobile Number: 24.732.449","Exp: 15yrs"},
            {"Doctor Name :  Chayma AYARI","Hospital Address: La Marsa","Mobile Number: 71.749.503","Exp: 20yrs"},
            {"Doctor Name :  Dorra BEJI","Hospital Address: La Soukra","Mobile Number: 94.847.473","Exp: 25yrs"}
    };
    private String [][] doctor_details3={
            {"Doctor Name :  Amine MLAYAH","Hospital Address: Centre Urbain Nord","Mobile Number: 23.860.083","Exp: 10yrs"},
            {"Doctor Name :  Aziza BOUASSIDA LAKHOUA","Hospital Address: les Berges du Lac 1","Mobile Number: 36.049.557","Exp: 15yrs"},
            {"Doctor Name :  Khaoula JEAIEM","Hospital Address: Le Bardo","Mobile Number: 71.221.127","Exp: 20yrs"},
            {"Doctor Name :  Sarra CHEFFI","Hospital Address: Jardins de carthage","Mobile Number: 20.242.640","Exp: 25yrs"}

    };
    private String [][] doctor_details4={
            {"Doctor Name :  Bilel GUIGA","Hospital Address:  Les berges du lac 2","Mobile Number: 54.583.255","Exp: 7yrs"},
            {"Doctor Name :  Taher DJEMAL","Hospital Address: ,Les berges du lac 2","Mobile Number: 27.115.144","Exp: 15yrs"},
            {"Doctor Name :  Hichem MAHMOUD ","Hospital Address:Centre Urbain Nord","Mobile Number: 24.706.749","Exp: 10yrs"},
            {"Doctor Name :  Samy LASTA","Hospital Address: La Marsa","Mobile Number: 55.845.000","Exp: 5yrs"}

    };
    private String [][] doctor_details5={
            {"Doctor Name :  Leila RIAHI","Hospital Address: Cite El Khadra","Mobile Number: 99.326.618","Exp: 20yrs"},
            {"Doctor Name :  Tarek BEN CHEDLI","Hospital Address: ,Soukra","Mobile Number: 20.263.617","Exp: 15yrs"},
            {"Doctor Name :  Faouzi ELKHIARI","Hospital Address: Kram","Mobile Number: 26.188.000","Exp: 10yrs"},
            {"Doctor Name :   Habib HAOUALA","Hospital Address: Les Berges Du Lac 2","Mobile Number: 95.557.007","Exp: 9yrs"}
    };


    TextView tv;
    Button btn;
    String [][] doctor_details = {};
    ArrayList<HashMap<String, String>> list;
    SimpleAdapter sa;
    HashMap<String,String> item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        tv=findViewById(R.id.textViewODTitle);
        btn=findViewById(R.id.buttonODBack);

        Intent it=getIntent();
        String title=it.getStringExtra("title");
        tv.setText(title);
        //The compareTo method of Comparable interface returns exactly zero if equal
        assert title != null;
        if(title.compareTo("Family Physicians")==0)
            doctor_details=doctor_details1;
        else
            if (title.compareTo("Dietitian")==0)
                doctor_details=doctor_details2;
            else
            if (title.compareTo("Dentist")==0)
                doctor_details=doctor_details3;
            else
            if (title.compareTo("Surgeon")==0)
                doctor_details=doctor_details4;
            else
            if (title.compareTo("Cardiologist")==0)
                doctor_details=doctor_details5;

        list = new ArrayList<HashMap<String, String>>();
        for (String[] doctorDetail : doctor_details) {
            item = new HashMap<String, String>();
            item.put("line1", doctorDetail[0]);
            item.put("line2", doctorDetail[1]);
            item.put("line3", doctorDetail[2]);
            item.put("line4", doctorDetail[3]);
            list.add(item);
        }
        sa=new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d}
        );
        ListView lst=findViewById(R.id.listViewOD);
        lst.setAdapter(sa);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it=new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[position][0]);
                it.putExtra("text3",doctor_details[position][1]);
                it.putExtra("text4",doctor_details[position][2]);
                it.putExtra("text5",doctor_details[position][3]);
                startActivity(it);
            }
        });

    }
}