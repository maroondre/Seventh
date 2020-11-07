package com.example.seventh.ModelList;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListPlayers {

    @SerializedName("data")
    private List<Datum> data = null;

    public static class Datum{

            @SerializedName("id")
            private String id;
            @SerializedName("slug")
            private String slug;
            @SerializedName("name")
            private String name;
            @SerializedName("name_short")
            private String nameShort;
            @SerializedName("has_photo")
            private Boolean hasPhoto;
            @SerializedName("photo")
            private String photo;
            @SerializedName("position")
            private String position;
            @SerializedName("weight")
            private String weight;
            @SerializedName("age")
            private String age;
            @SerializedName("date_birth_at")
            private String dateBirthAt;
            @SerializedName("height")
            private Float height;
            @SerializedName("shirt_number")
            private String shirtNumber;
            @SerializedName("preferred_foot")
            private String preferredFoot;
            @SerializedName("nationality_code")
            private String nationalityCode;
            @SerializedName("flag")
            private String flag;
            @SerializedName("market_currency")
            private String marketCurrency;
            @SerializedName("market_value")
            private String marketValue;
            @SerializedName("contract_until")
            private String contractUntil;
            @SerializedName("rating")
            private Float rating;
            @SerializedName("sport")
            private Sport sport;
            @SerializedName("main_team")
            private MainTeam mainTeam;

            public Datum(String name) {
                this.id = id;
                this.name = name;
                this.photo = photo;
                this.position = position;
                this.weight = weight;
                this.age = age;
                this.height = height;
                this.shirtNumber = shirtNumber;
                this.rating = rating;
                this.sport = sport;
                this.mainTeam = mainTeam;
            }

                public class Sport{

                    @SerializedName("id")
                    private String id;
                    @SerializedName("name")
                    private String name;

                    public Sport(String id, String name) {
                        this.id = id;
                        this.name = name;
                    }

                    public String getId() {
                        return id;
                    }

                    public String getName() {
                        return name;
                    }
                }

                public class MainTeam{

                    @SerializedName("id")
                    private String id;
                    @SerializedName("name")
                    private String name;
                    @SerializedName("logo")
                    private String logo;
                    @SerializedName("gender")
                    private String gender;
                    @SerializedName("country")
                    private String country;

                    public MainTeam(String id, String name, String logo, String gender, String country) {
                        this.id = id;
                        this.name = name;
                        this.logo = logo;
                        this.gender = gender;
                        this.country = country;
                    }

                    public String getId() {
                        return id;
                    }

                    public String getName() {
                        return name;
                    }

                    public String getLogo() {
                        return logo;
                    }

                    public String getGender() {
                        return gender;
                    }

                    public String getCountry() {
                        return country;
                    }
                }

            public String getId() {
                return id;
            }

            public String getName() {
                return name;
            }

            public String getPhoto() {
                return photo;
            }

            public String getPosition() {
                return position;
            }

            public String getWeight() {
                return weight;
            }

            public String getAge() {
                return age;
            }

            public Float getHeight() {
                return height;
            }

            public String getShirtNumber() {
                return shirtNumber;
            }

            public Float getRating() {
                return rating;
            }

            public Sport getSport() {
                return sport;
            }

            public MainTeam getMainTeam() {
                return mainTeam;
            }
        }


        public List<Datum> getData() {
            return data;
        }
}
