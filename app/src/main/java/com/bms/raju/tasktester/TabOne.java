package com.bms.raju.tasktester;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.VideoView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TabOne extends Fragment {

    String TAG = "logfragmentOne";
    View view;
    String videourl = "";
    private VideoView videoView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tabone, container, false);

        videoView = (VideoView) view.findViewById(R.id.videovv);
//        final VideoView videoView = new VideoView(getContext());


        String url = "https://egcashback.in/manage/api/video_ads/all/?X-Api-Key=B1271BD939B74CA8D5C9A183C53BACDD&field1=video_status&filter1=Active&field=shop_id&filter=1155";
        String urlv = "https://egcashback.in//manage//uploads//video_ads//1543407594.mp4";

        return view;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final ArrayList newsFeed = new ArrayList<>();
        String urlegc = "https://egcashback.in/manage/api/video_ads/all/?X-Api-Key=B1271BD939B74CA8D5C9A183C53BACDD&field1=video_status&filter1=Active&field=shop_id&filter=1155";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, urlegc, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject obj = response.getJSONObject("data");
                    Log.d(TAG, obj.toString());
                    JSONArray vidArjson = new JSONArray(obj.getString("video_ads"));
                    Log.d("logoutPUt", String.valueOf(vidArjson.getJSONObject(0)));
                    videourl = (vidArjson.getJSONObject(0)).getString("videos");
                    Log.d("logurl", (vidArjson.getJSONObject(0)).getString("videos"));
//                            NewsFeed feed = new NewsFeed(obj.getString("title"), obj.getString("description"), obj.getString("date"));
//                            newsFeed.add(feed);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                videoView = (VideoView) view.findViewById(R.id.videovv);
                if (videourl.endsWith(".mp4")) {
                    videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            videoView.requestFocus();
                            videoView.start();
                        }
                    });
                    videoView.setVideoURI(Uri.parse(videourl));


                } else {
                    Log.d("logerror", "no url");
                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(request);

//        ListView listView = (ListView) getActivity().findViewById(R.id.newsFeed);
//        NewsFeedAdapter adapter = new NewsFeedAdapter(getActivity(), (ArrayList<NewsFeed>) newsFeed);
//        listView.setAdapter(adapter);
//    }


        Button playbtn = (Button) view.findViewById(R.id.playbtn);
        Button stopbtn = (Button) view.findViewById(R.id.stopbtn);
        playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!videoView.isPlaying()) {
                    videoView.resume();
                }
                Log.d("videostart", "clicked start");
            }
        });
        stopbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.stopPlayback();
                Log.d("videostop", "clicked stop");
            }
        });

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

            }
        });
    }
}