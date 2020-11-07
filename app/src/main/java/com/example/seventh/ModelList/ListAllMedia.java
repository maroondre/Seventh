package com.example.seventh.ModelList;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListAllMedia {

    @SerializedName("data")
    public List<Data> data;

    public static class Data
    {
        @SerializedName("title")
        private String title;
        @SerializedName("sub_title")
        private String subTitle;
        @SerializedName("source_url")
        private String url;
        @SerializedName("thumbnail_url")
        private String thumbnailUrl;
        @SerializedName("source")
        private Source source;

        public Data(String title,String subTitle,String url, String thumbnailUrl, Source source) {
            super();
            this.title = title;
            this.url = url;
            this.thumbnailUrl = thumbnailUrl;
            this.source = source;
            this.subTitle = subTitle;
        }

        public Data(String title, String subTitle, String thumbnailUrl) {
            this.title = title;
            this.subTitle = subTitle;
            this.thumbnailUrl = thumbnailUrl;
        }

        public class Source
            {
                @SerializedName("name")
                private String name;
                @SerializedName("home_team")
                private HomeTeam homeTeam;
                @SerializedName("away_team")
                private AwayTeam awayTeam;
                @SerializedName("start_at")
                private String startAt;
                @SerializedName("home_score")
                private HomeScore homeScore;
                @SerializedName("away_score")
                private HomeScore awayScore;

                public Source(String name, HomeTeam homeTeam, AwayTeam awayTeam, String startAt, HomeScore homeScore, HomeScore awayScore) {
                    super();
                    this.name = name;
                    this.homeTeam = homeTeam;
                    this.awayTeam = awayTeam;
                    this.startAt = startAt;
                    this.homeScore = homeScore;
                    this.awayScore = awayScore;

                }

                    public class HomeTeam
                    {
                        @SerializedName("name")
                        private String name;
                        @SerializedName("logo")
                        private String logo;

                        public HomeTeam(String name,String logo)
                        {
                            super();
                            this.name = name;
                            this.logo = logo;
                        }

                        public String getName() {
                            return name;
                        }

                        public String getLogo() {
                            return logo;
                        }

                    }

                    public class AwayTeam
                    {
                        @SerializedName("name")
                        private String name;
                        @SerializedName("logo")
                        private String logo;

                        public AwayTeam(String name, String logo)
                        {
                            super();
                            this.name = name;
                            this.logo = logo;
                        }

                        public String getName() {
                            return name;
                        }

                        public String getLogo() {
                            return logo;
                        }

                    }


                    public class HomeScore
                    {
                        @SerializedName("display")
                        private String display;

                        public HomeScore(String display) {
                            this.display = display;
                        }

                        public String getDisplay() {
                            return display;
                        }
                    }

                public String getName() {
                    return name;
                }

                public HomeTeam getHomeTeam() {
                    return homeTeam;
                }

                public AwayTeam getAwayTeam() {
                    return awayTeam;
                }

                public String getStartAt() {
                    return startAt;
                }

                public HomeScore getHomeScore() {
                    return homeScore;
                }

                public HomeScore getAwayScore() {
                    return awayScore;
                }
            }

        public String getTitle() {
            return title;
        }

        public String getSubTitle() {
            return subTitle;
        }

        public String getUrl() {
            return url;
        }

        public String getThumbnailUrl() {
            return thumbnailUrl;
        }

        public Source getSource() {
            return source;
        }

    }

    public List<Data> getData() {
    return data;
}

}

