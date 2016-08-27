package com.rameshwor.agronepal.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.rameshwor.agronepal.R;
import com.rameshwor.agronepal.adapters.CashCropAdapter;
import com.rameshwor.agronepal.object.CashCrop;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CashCrops extends Fragment{
    RecyclerView recyclerView;
    ArrayList<CashCrop> list =new ArrayList<>();
    ProgressBar progressBar;
    LinearLayout errorlayout;

    public CashCrops(){
        //public empty constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getDataFromInternet();
    }

    private void getDataFromInternet() {
        final JsonArrayRequest request=new JsonArrayRequest("http://dhakalrameshwor.com.np/agronepal/crop.json", new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                progressBar.setVisibility(View.GONE);
                for (int i=0 ;i<response.length();i++){
                    try {
                        JSONObject object=response.getJSONObject(i);
                        CashCrop cashCrop=new CashCrop();

                        cashCrop.name=object.getString("name");
                        cashCrop.climate=object.getString("climate");
                        cashCrop.place=object.getString("place");
                        cashCrop.image_link=object.getString("image_link");

                        list.add(cashCrop);
                        recyclerView.setAdapter(new CashCropAdapter(getContext(), list));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                errorlayout.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);
            }
        });

        Volley.newRequestQueue(getContext()).add(request);


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView= (RecyclerView) view.findViewById(R.id.recycashcrops);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        progressBar= (ProgressBar) view.findViewById(R.id.loadingCashcrops);
        errorlayout= (LinearLayout) view.findViewById(R.id.errorlayout);

        errorlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                errorlayout.setVisibility(View.GONE);
                getDataFromInternet();
                progressBar.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cashcrops,container,false);
    }
}
