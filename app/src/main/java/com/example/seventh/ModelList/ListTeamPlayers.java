package com.example.seventh.ModelList;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListTeamPlayers {

    @SerializedName("data")
    private List<Datum> data = null;

        public static class Datum{
            @SerializedName("id")
            private Integer id;
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
            private Integer weight;
            @SerializedName("age")
            private Integer age;
            @SerializedName("date_birth_at")
            private String dateBirthAt;
            @SerializedName("height")
            private Float height;
            @SerializedName("shirt_number")
            private Integer shirtNumber;
            @SerializedName("preferred_foot")
            private String preferredFoot;
            @SerializedName("nationality_code")
            private String nationalityCode;
            @SerializedName("flag")
            private String flag;
            @SerializedName("market_currency")
            private String marketCurrency;
            @SerializedName("market_value")
            private Integer marketValue;
            @SerializedName("contract_until")
            private String contractUntil;
            @SerializedName("rating")
            private Float rating;
            @SerializedName("positions")
            private Positions positions;
            public static class Positions{
                @SerializedName("main")

                private String main;

                public String getMain() {
                    return main;
                }
            }

            public Integer getId() {
                return id;
            }

            public String getSlug() {
                return slug;
            }

            public String getName() {
                return name;
            }

            public String getNameShort() {
                return nameShort;
            }

            public Boolean getHasPhoto() {
                return hasPhoto;
            }

            public String getPhoto() {
                return photo;
            }

            public String getPosition() {
                return position;
            }

            public Integer getWeight() {
                return weight;
            }

            public Integer getAge() {
                return age;
            }

            public String getDateBirthAt() {
                return dateBirthAt;
            }

            public Float getHeight() {
                return height;
            }

            public Integer getShirtNumber() {
                return shirtNumber;
            }

            public String getPreferredFoot() {
                return preferredFoot;
            }

            public String getNationalityCode() {
                return nationalityCode;
            }

            public String getFlag() {
                return flag;
            }

            public String getMarketCurrency() {
                return marketCurrency;
            }

            public Integer getMarketValue() {
                return marketValue;
            }

            public String getContractUntil() {
                return contractUntil;
            }

            public Float getRating() {
                return rating;
            }

            public Positions getPositions() {
                return positions;
            }
        }

    public List<Datum> getData() {
        return data;
    }
}
