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
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.admin.examone.R;
import com.example.admin.examone.adapter.Cust_SocialAdapter;
import com.example.admin.examone.pojo.AllData;
import com.example.admin.examone.pojo.SocialData;
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
public class SocialFragment extends Fragment {

    RecyclerView recyclerView;
    static final String url="http://www.allintheloop.net/native_single_fcm/activity/get_all";
    ProgressDialog dialog;
    Cust_SocialAdapter adapter;
    List<SocialData> list=new ArrayList<SocialData>();

    public SocialFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_social, container, false);
        recyclerView=view.findViewById(R.id.recycler_social);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter=new Cust_SocialAdapter(getContext(),list);
        recyclerView.setAdapter(adapter);

        dialog=new ProgressDialog(getContext());
        dialog.setMessage("Loading...");
        dialog.show();

        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                dialog.dismiss();
                Log.d("SocialFragment", "onResponse: "+response);

                JSONObject jsonObject = null;
                try {
                    list.clear();

                    jsonObject = new JSONObject(response);
                    JSONObject jsonObject1=jsonObject.getJSONObject("data");
                    JSONObject jsonObject2=jsonObject1.getJSONObject("instagram");
                    JSONArray jsonArray=jsonObject2.getJSONArray("data");

                    for (int i=0;i<jsonArray.length();i++){
                        JSONObject jsonObject3=jsonArray.getJSONObject(i);
                        JSONObject jsonObject4=jsonObject3.getJSONObject("user");

                        SocialData socialData=new SocialData();
                        socialData.setPic(jsonObject4.getString("profile_picture"));
                        socialData.setFullName(jsonObject4.getString("full_name"));
                        socialData.setUsername(jsonObject4.getString("username"));

                        socialData.setTime(jsonObject3.getString("created_time"));

                        list.add(socialData);
                        }

                        adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(),"Something Went Wrong",Toast.LENGTH_SHORT).show();
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

        AppController.getInstance().addToRequestQueue(stringRequest,"SocialFragment");
        return view;
    }

}
