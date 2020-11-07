package com.example.seventh.Connections;

import com.example.seventh.ModelList.ListAllMedia;
import com.example.seventh.ModelList.ListLive;
import com.example.seventh.ModelList.ListPlayers;
import com.example.seventh.ModelList.ListTeam;
import com.example.seventh.ModelList.ListTeamPlayers;
import com.example.seventh.ModelList.ListTeams;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiCall {

    String url = "https://rapidapi.p.rapidapi.com/";
    String teamurl = "https://rapidapi.p.rapidapi.com/teams";
    String BASE_URL = "https://www.thesportsdb.com/api/v1/json/1/";

   /* @Headers({"x-rapidapi-host: sportscore1.p.rapidapi.com",
                "x-rapidapi-key: 07e55202eemshd454005e3a79774p103cccjsn4b32f05d3a2f",
                "useQueryString: true"})
    @GET("medias")
    Call<ListMedia> getMedia();*/
   /* @Headers({"x-rapidapi-host: sportscore1.p.rapidapi.com",
            "x-rapidapi-key: 07e55202eemshd454005e3a79774p103cccjsn4b32f05d3a2f",
            "useQueryString: true"})
    @GET("leagues")
    Call<ListLeagues> getLeagues();*/

        @Headers({  "x-rapidapi-host: sportscore1.p.rapidapi.com",
                    "x-rapidapi-key: 07e55202eemshd454005e3a79774p103cccjsn4b32f05d3a2f",
                    "useQueryString: true"})
        @GET("sports/1/events/live")
            Call<ListLive> getLive();

        @Headers({  "x-rapidapi-host: sportscore1.p.rapidapi.com",
                    "x-rapidapi-key: 07e55202eemshd454005e3a79774p103cccjsn4b32f05d3a2f",
                    "useQueryString: true"})
        @GET("players")
            Call<ListPlayers> getPlayers();

        @Headers({  "x-rapidapi-host: sportscore1.p.rapidapi.com",
                    "x-rapidapi-key: 07e55202eemshd454005e3a79774p103cccjsn4b32f05d3a2f",
                    "useQueryString: true"})
        @GET("medias")
            Call<ListAllMedia> getMedia();

    @GET("search_all_teams.php?l=English%20Premier%20League")
    Call<ListTeam> getTeam();

}
