package com.example.seventh.Connections;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.example.seventh.ModelList.ListAllMedia;
import com.example.seventh.ModelList.ListLive;
import com.example.seventh.ModelList.ListPlayers;
import com.example.seventh.ModelList.ListTeam;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.seventh.Adapter.TeamsAdapter.teamid;

public class Calls {

    public static final String preferences = "SharedPreference";
    public static final String media = "Media";
    public static final String tm = "Team";
    public static final String live = "Live";
    public static final String players = "Players";
    public static final String teams = "Teams";
    public static final String tplayers = "Team Players";

    String id = String.valueOf(teamid);
    SharedPreferences spref;
    SharedPreferences.Editor spEditor;
    Context context;
    Retro rfit;
    Activity activity;

    public Calls(Context context){
        this.context =context;
        spref = context.getSharedPreferences(preferences, Context.MODE_PRIVATE);
        spEditor = spref.edit();
        this.activity = (Activity) this.context;
    }

        private SharedPreferences.Editor Editor() {
            return spEditor;
        }

        private SharedPreferences Shared(){
        return spref;
    }


    public <T> void saveData(String call, List<T> model)
    {
        Gson gson = new Gson();
        String jsonString = gson.toJson(model);
        spEditor.putString(call,jsonString);
        spEditor.apply();
    }

    public <T> void saveData(String call, T model)
    {
        Gson gson = new Gson();
        String jsonString = gson.toJson(model);
        spEditor.putString(call,jsonString);
        spEditor.apply();
    }

        public ArrayList<ListPlayers.Datum> loadListPlayers(){
            Gson gson = new Gson();
            String json = Shared().getString(players,"");
            Type type = new TypeToken<ArrayList<ListPlayers.Datum>>(){}.getType();
            ArrayList<ListPlayers.Datum> model = gson.fromJson(json,type);
            return model;
        }

        public List<String> loadteamPlayers(){
            Gson gson = new Gson();
            String json = Shared().getString(teams,"");
            Type type = new TypeToken<List<String>>(){}.getType();
            List<String> model = gson.fromJson(json,type);
            return model;
        }

        public List<ListLive.Datum> loadListLive(){
            Gson gson = new Gson();
            String json = Shared().getString(live,"");
            Type type = new TypeToken<List<ListLive.Datum>>(){}.getType();
            List<ListLive.Datum> model = gson.fromJson(json,type);
            return model;
        }

        public List<ListAllMedia.Data> loadListAll(){
            Gson gson = new Gson();
            String json = Shared().getString(media,"");
            Type type = new TypeToken<List<ListAllMedia.Data>>(){}.getType();
            List<ListAllMedia.Data> model = gson.fromJson(json,type);
            return model;
        }

        public List<ListTeam.Team> loadListTeam(){
            Gson gson = new Gson();
            String json = Shared().getString(tm,"");
            Type type = new TypeToken<List<ListTeam.Team>>(){}.getType();
            List<ListTeam.Team> model = gson.fromJson(json,type);
            return model;
        }

    public void clearData()
    {
        spref.edit().clear().apply();
        spref.edit().apply();
    }

        public void loadAllTeams()
        {
            rfit =  new Retro();
            Call<ListTeam> call = rfit.retrofitTeams().getTeam();
            call.enqueue(new Callback<ListTeam>() {
                @Override
                public void onResponse(Call<ListTeam> call, Response<ListTeam> response) {
                    ListTeam liveList = response.body();
                    List<ListTeam.Team> data = liveList.getTeams();

                    saveData(tm,data);
                }

                @Override
                public void onFailure(Call<ListTeam> call, Throwable t) {
                    Toast.makeText(activity,t.getMessage(),Toast.LENGTH_LONG).show();
                }
            });
        }

        public void loadAllMedia()
        {
            rfit =  new Retro();
            Call<ListAllMedia> call = rfit.retrofitBuilder().getMedia();
            call.enqueue(new Callback<ListAllMedia>() {
                @Override
                public void onResponse(Call<ListAllMedia> call, Response<ListAllMedia> response) {
                    ListAllMedia liveList = response.body();
                    List<ListAllMedia.Data> data = liveList.getData();

                    saveData(media,data);
                }

                @Override
                public void onFailure(Call<ListAllMedia> call, Throwable t) {
                    Toast.makeText(activity,t.getMessage(),Toast.LENGTH_LONG).show();
                }
            });
        }

        public void loadLive()
        {
            rfit =  new Retro();
            Call<ListLive> call = rfit.retrofitBuilder().getLive();
            call.enqueue(new Callback<ListLive>() {
                @Override
                public void onResponse(Call<ListLive> call, Response<ListLive> response) {
                    ListLive liveList = response.body();
                    List<ListLive.Datum> data = liveList.getData();

                    saveData(live,data);
                }

                @Override
                public void onFailure(Call<ListLive> call, Throwable t) {
                    Toast.makeText(activity,t.getMessage(),Toast.LENGTH_LONG).show();
                }
            });
        }

        public void loadPlayers()
        {
            rfit =  new Retro();
            Call<ListPlayers> call = rfit.retrofitBuilder().getPlayers();
            call.enqueue(new Callback<ListPlayers>() {
                @Override
                public void onResponse(Call<ListPlayers> call, Response<ListPlayers> response) {
                    ListPlayers manList = response.body();
                    List<ListPlayers.Datum> data = manList.getData();

                    saveData(players,data);
                }

                @Override
                public void onFailure(Call<ListPlayers> call, Throwable t) {
                    Toast.makeText(activity,t.getMessage(),Toast.LENGTH_LONG).show();
                }
            });
        }

        public void loadTeams()
        {
            rfit =  new Retro();
            Call<ListPlayers> call = rfit.retrofitBuilder().getPlayers();
            call.enqueue(new Callback<ListPlayers>() {
                @Override
                public void onResponse(Call<ListPlayers> call, Response<ListPlayers> response) {
                    ListPlayers manList = response.body();
                    List<ListPlayers.Datum> data = manList.getData();
                    List<String> playerss = new ArrayList<>();
                    try {
                        for (int i = 0; i < data.size(); i++) {
                            if(data.get(i).getMainTeam() !=null){
                                playerss.add(data.get(i).getMainTeam().getLogo());
                            }
                        }
                    }catch(Exception e){}

                    Set<String> set = new HashSet<>(playerss);
                    playerss.clear();
                    playerss.addAll(set);
                    saveData(teams,playerss);
                }

                @Override
                public void onFailure(Call<ListPlayers> call, Throwable t) {
                    Toast.makeText(activity,t.getMessage(),Toast.LENGTH_LONG).show();
                }
            });
        }
}
