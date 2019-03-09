package com.bms.raju.tasktester;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class TabTwo extends Fragment {
    View view2;
    String shopid = "", monday = "", tueday = "", wedday = "", thuday = "", friday = "", satday = "", sunday = "";
    LinearLayout timingsll1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view2 = inflater.inflate(R.layout.tabtwo, container, false);

        return view2;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final TextView showmessage1 = view2.findViewById(R.id.showmessage);
        timingsll1 = view2.findViewById(R.id.timingsll);
        String urlegctim = "https://www.egcashback.in/manage/api/timimgs/all/?X-Api-Key=B1271BD939B74CA8D5C9A183C53BACDD&field=shop_id&filter=2";
        Log.d("logurltime", urlegctim);
        timingsll1.removeAllViews();
        JsonObjectRequest timingsjson = new JsonObjectRequest(Request.Method.GET, urlegctim, null, new Response.Listener<JSONObject>() {
            TableLayout timeTL = new TableLayout(getContext());
            TableRow timeTRhead = new TableRow(getContext());
            TableRow timeTR1 = new TableRow(getContext());
            TableRow timeTR2 = new TableRow(getContext());
            TableRow timeTR3 = new TableRow(getContext());
            TableRow timeTR4 = new TableRow(getContext());
            TableRow timeTR5 = new TableRow(getContext());
            TableRow timeTR6 = new TableRow(getContext());
            TableRow timeTR7 = new TableRow(getContext());

            TextView day1 = new TextView(getContext());
            TextView day2 = new TextView(getContext());
            TextView day3 = new TextView(getContext());
            TextView day4 = new TextView(getContext());
            TextView day5 = new TextView(getContext());
            TextView day6 = new TextView(getContext());
            TextView day7 = new TextView(getContext());


            TextView opentv1 = new TextView(getContext());
            TextView closetv1 = new TextView(getContext());
            TextView opentv2 = new TextView(getContext());
            TextView closetv2 = new TextView(getContext());
            TextView opentv3 = new TextView(getContext());
            TextView closetv3 = new TextView(getContext());
            TextView opentv4 = new TextView(getContext());
            TextView closetv4 = new TextView(getContext());
            TextView opentv5 = new TextView(getContext());
            TextView closetv5 = new TextView(getContext());
            TextView opentv6 = new TextView(getContext());
            TextView closetv6 = new TextView(getContext());
            TextView opentv7 = new TextView(getContext());
            TextView closetv7 = new TextView(getContext());

            TextView headtv1 = new TextView(getContext());

            TextView headtv2 = new TextView(getContext());

            TextView headtv3 = new TextView(getContext());

            @Override
            public void onResponse(JSONObject response) {
                Log.d("logtimings", response.toString());

                try {
                    if (response.getBoolean("status")) {
                        showmessage1.setTextColor(Color.parseColor("#FF113810"));
                        showmessage1.setText("Shop Timings");
                        JSONObject datatimes = new JSONObject(response.getString("data"));

                        JSONArray timingsarjson = new JSONArray(datatimes.getString("timimgs"));
                        int i = 0;
                        headtv1.setText("Day");
                        headtv2.setText("Open Time");
                        headtv3.setText("Close Time");

                        headtv1.setTextSize(16);
                        headtv2.setTextSize(16);
                        headtv3.setTextSize(16);
                        day1.setText("Monday");
                        day2.setText("Tuesday");
                        day3.setText("Wednesday");
                        day3.setPadding(0, 0, 10, 0);
                        day4.setText("Thursday");
                        day5.setText("Friday");
                        day6.setText("Saturday");
                        day7.setText("Sunday");

                        opentv1.setText(timingsarjson.getJSONObject(i).getString("a1") + " - " + timingsarjson.getJSONObject(i).getString("a2"));
                        closetv1.setText(timingsarjson.getJSONObject(i).getString("a3") + " - " + timingsarjson.getJSONObject(i).getString("a4"));
                        opentv2.setText(timingsarjson.getJSONObject(i).getString("b1") + " - " + timingsarjson.getJSONObject(i).getString("b2"));
                        closetv2.setText(timingsarjson.getJSONObject(i).getString("b3") + " - " + timingsarjson.getJSONObject(i).getString("b4"));
                        opentv3.setText(timingsarjson.getJSONObject(i).getString("c1") + " - " + timingsarjson.getJSONObject(i).getString("c2"));
                        closetv3.setText(timingsarjson.getJSONObject(i).getString("c4") + " - " + timingsarjson.getJSONObject(i).getString("c4"));
                        opentv4.setText(timingsarjson.getJSONObject(i).getString("d1") + " - " + timingsarjson.getJSONObject(i).getString("d2"));
                        closetv4.setText(timingsarjson.getJSONObject(i).getString("d3") + " - " + timingsarjson.getJSONObject(i).getString("d4"));
                        opentv5.setText(timingsarjson.getJSONObject(i).getString("e1") + " - " + timingsarjson.getJSONObject(i).getString("e2"));
                        closetv5.setText(timingsarjson.getJSONObject(i).getString("e3") + " - " + timingsarjson.getJSONObject(i).getString("e4"));
                        opentv6.setText(timingsarjson.getJSONObject(i).getString("f1") + " - " + timingsarjson.getJSONObject(i).getString("f2"));
                        closetv6.setText(timingsarjson.getJSONObject(i).getString("f3") + " - " + timingsarjson.getJSONObject(i).getString("f4"));
                        opentv7.setText(timingsarjson.getJSONObject(i).getString("g1") + " - " + timingsarjson.getJSONObject(i).getString("g2"));
                        closetv7.setText(timingsarjson.getJSONObject(i).getString("g3") + " - " + timingsarjson.getJSONObject(i).getString("g4"));


                    } else {
                        showmessage1.setTextColor(Color.parseColor("#FF662D53"));
                        showmessage1.setText(response.getString("message"));
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }

                timingsll1.removeAllViews();
                timingsll1.setPadding(10, 15, 10, 10);
                headtv1.setTypeface(null, Typeface.BOLD);
                headtv2.setTypeface(null, Typeface.BOLD);
                headtv3.setTypeface(null, Typeface.BOLD);
                headtv1.setPadding(1, 5, 10, 5);
                headtv2.setPadding(1, 5, 10, 5);
                headtv3.setPadding(1, 5, 10, 5);
                day1.setPadding(5, 5, 10, 5);
                day2.setPadding(5, 5, 10, 5);
                day3.setPadding(5, 5, 10, 5);
                day4.setPadding(5, 5, 10, 5);
                day5.setPadding(5, 5, 10, 5);
                day6.setPadding(5, 5, 10, 5);
                day7.setPadding(5, 5, 10, 5);
                timeTRhead.addView(headtv1);
                timeTRhead.addView(headtv2);
                timeTRhead.addView(headtv3);

                timeTR1.addView(day1);
                timeTR1.addView(opentv1);
                timeTR1.addView(closetv1);
                timeTR2.addView(day2);
                timeTR2.addView(opentv2);
                timeTR2.addView(closetv2);
                timeTR3.addView(day3);
                timeTR3.addView(opentv3);
                timeTR3.addView(closetv3);
                timeTR4.addView(day4);
                timeTR4.addView(opentv4);
                timeTR4.addView(closetv4);
                timeTR5.addView(day5);
                timeTR5.addView(opentv5);
                timeTR5.addView(closetv5);
                timeTR6.addView(day6);
                timeTR6.addView(opentv6);
                timeTR6.addView(closetv6);
                timeTR7.addView(day7);
                timeTR7.addView(opentv7);
                timeTR7.addView(closetv7);

                timeTL.addView(timeTRhead);
                timeTL.addView(timeTR1);
                timeTL.addView(timeTR2);
                timeTL.addView(timeTR3);
                timeTL.addView(timeTR4);
                timeTL.addView(timeTR5);
                timeTL.addView(timeTR6);
                timeTL.addView(timeTR7);

                timingsll1.addView(timeTL);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        RequestQueue requestQueue1 = Volley.newRequestQueue(getActivity());
        requestQueue1.add(timingsjson);
    }
}
