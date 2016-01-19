package com.example.lenovo.form1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class netwk extends AppCompatActivity {
    public static String msg="mm";
    public static int succ=22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_netwk);
        Intent intent= getIntent();
        String s1= intent.getStringExtra("s1");
        String s2= intent.getStringExtra("s2");
        String s3= intent.getStringExtra("s3");
        String s4= intent.getStringExtra("s4");
        String s5= intent.getStringExtra("s5");
        String s6= intent.getStringExtra("s6");
        String s7= intent.getStringExtra("s7");

        TextView t1= (TextView) findViewById(R.id.textView2);
        TextView t2= (TextView) findViewById(R.id.textView3);
        // the POST parameters:


        String url = "http://agni.iitd.ernet.in/cop290/assign0/register/";

        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                            msg=response;
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<>();
                // the POST parameters:
                params.put("teamname", "code");
                params.put("entry1", "2012EE50561");
                params.put("name1", "Utkarsh");
                params.put("entry2", "2012EE50542");
                params.put("name2", "Abhilash Parashar");
                params.put("entry3", "2012EE50557");
                params.put("name3", "Shobhit Zakhmi");
                return params;
            }
        };
        Volley.newRequestQueue(this).add(postRequest);
        t2.setText("Message: "+msg);

    }

}
