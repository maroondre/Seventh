package com.example.seventh.ModelList;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListTeams {

    @SerializedName("data")
    private List<Datum> data = null;

    public static class Datum {
        @SerializedName("id")
        private Integer id;
        @SerializedName("name")
        private String name;
        @SerializedName("name_full")
        private String nameFull;
        @SerializedName("logo")
        private String logo;

        public Datum(Integer id, String name, String nameFull, String logo) {
            this.id = id;
            this.name = name;
            this.nameFull = nameFull;
            this.logo = logo;
        }

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getNameFull() {
            return nameFull;
        }

        public String getLogo() {
            return logo;
        }
    }

    public List<Datum> getData() {
        return data;
    }
}
