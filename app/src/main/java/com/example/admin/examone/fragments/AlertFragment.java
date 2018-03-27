package com.example.admin.examone.fragments;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.admin.examone.R;
import com.example.admin.examone.adapter.Cust_ALLadapter;
import com.example.admin.examone.pojo.AllData;
import com.example.admin.examone.util.AppController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class AlertFragment extends Fragment {

    RecyclerView recyclerView;
    static final String url="http://www.allintheloop.net/native_single_fcm/activity/get_all";
    ProgressDialog dialog;
    RequestQueue requestQueue;
    Cust_ALLadapter adapter;
    List<AllData> list=new ArrayList<AllData>();

    public AlertFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_alert, container, false);
        recyclerView=view.findViewById(R.id.recycler_alert);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter=new Cust_ALLadapter(getContext(),list);
        recyclerView.setAdapter(adapter);

        dialog=new ProgressDialog(getContext());
        dialog.setMessage("Loading...");
        dialog.show();

        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                dialog.dismiss();

                Log.d("AlertFragment", "onResponse: "+response);

                JSONObject jsonObject= null;
                try {
                    list.clear();

                    jsonObject = new JSONObject(response);
                    JSONObject jsonObject1=jsonObject.getJSONObject("data");

                    JSONArray jsonArray=jsonObject1.getJSONArray("alerts");

                    for (int i=0;i<jsonArray.length();i++){
                        JSONObject jsonObject2=jsonArray.getJSONObject(i);

                        AllData allData=new AllData();

                        allData.setImg(jsonObject2.getString("Logo"));
                        allData.setFname(jsonObject2.getString("Firstname"));
                        allData.setLname(jsonObject2.getString("Lastname"));
                        allData.setPosition(jsonObject2.getString("Title"));
                        allData.setCompany(jsonObject2.getString("Company_name"));
                        allData.setTime(jsonObject2.getString("Time"));

                        list.add(allData);
                    }

                    adapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(),"Something Went Wrong",Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<String, String>();
                params.put("lang","en");
                params.put("event_id","259");
                params.put("user_id","33834");

                return params;
            }
        };

        AppController.getInstance().addToRequestQueue(stringRequest,"AlertFragment");
        return view;
    }

}
