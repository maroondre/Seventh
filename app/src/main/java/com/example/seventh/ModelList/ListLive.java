package com.example.seventh.ModelList;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListLive {

    @SerializedName("data")
    private List<Datum> data = null;

        public class Datum {
            @SerializedName("id")
            private Integer id;
            @SerializedName("slug")
            private String slug;
            @SerializedName("name")
            private String name;
            @SerializedName("status")
            private String status;
            @SerializedName("status_more")
            private String statusMore;
            @SerializedName("home_team")
            private HomeTeam homeTeam;
            @SerializedName("away_team")
            private HomeTeam awayTeam;
            @SerializedName("start_at")
            private String startAt;
            @SerializedName("priority")
            private Integer priority;
            @SerializedName("home_score")
            private HomeScore homeScore;
            @SerializedName("away_score")
            private HomeScore awayScore;
            @SerializedName("winner_code")
            private Integer winnerCode;
            @SerializedName("aggregated_winner_code")
            private Object aggregatedWinnerCode;
            @SerializedName("result_only")
            private Boolean resultOnly;
            @SerializedName("coverage")
            private Integer coverage;
            @SerializedName("ground_type")
            private Object groundType;
            @SerializedName("round_number")
            private Integer roundNumber;
            @SerializedName("series_count")
            private Integer seriesCount;
            @SerializedName("medias_count")
            private Object mediasCount;
            @SerializedName("status_lineup")
            private Object statusLineup;
            @SerializedName("first_supply")
            private Object firstSupply;
            @SerializedName("cards_code")
            private String cardsCode;
            @SerializedName("main_stat")
            private Object mainStat;
            @SerializedName("periods")
            private Object periods;
            @SerializedName("periods_time")
            private Object periodsTime;
            @SerializedName("lasted_period")
            private String lastedPeriod;
            @SerializedName("default_period_count")
            private Object defaultPeriodCount;
            @SerializedName("attendance")
            private Object attendance;
            @SerializedName("cup_match_order")
            private Integer cupMatchOrder;
            @SerializedName("cup_match_in_round")
            private Integer cupMatchInRound;
            @SerializedName("season")
            private Season season;

            public Datum(Integer id, String name, String status, String statusMore, HomeTeam homeTeam, HomeTeam awayTeam, String startAt, Integer priority, HomeScore homeScore, HomeScore awayScore, Season season) {
                this.id = id;
                this.name = name;
                this.status = status;
                this.statusMore = statusMore;
                this.homeTeam = homeTeam;
                this.awayTeam = awayTeam;
                this.startAt = startAt;
                this.priority = priority;
                this.homeScore = homeScore;
                this.awayScore = awayScore;
                this.season = season;
            }

            public class HomeTeam {

                @SerializedName("id")
                private Integer id;
                @SerializedName("slug")
                private String slug;
                @SerializedName("name")
                private String name;
                @SerializedName("name_short")
                private String nameShort;
                @SerializedName("name_full")
                private String nameFull;
                @SerializedName("name_code")
                private String nameCode;
                @SerializedName("has_sub")
                private Boolean hasSub;
                @SerializedName("has_logo")
                private Boolean hasLogo;
                @SerializedName("logo")
                private String logo;
                @SerializedName("gender")
                private String gender;
                @SerializedName("is_nationality")
                private Boolean isNationality;
                @SerializedName("country_code")
                private String countryCode;
                @SerializedName("country")
                private String country;
                @SerializedName("flag")
                private String flag;
                @SerializedName("foundation")
                private String foundation;
                @SerializedName("details")
                private Object details;

                public HomeTeam(Integer id, String name, String nameFull, String nameCode, String logo, String gender, String countryCode, String foundation) {
                    this.id = id;
                    this.name = name;
                    this.nameFull = nameFull;
                    this.nameCode = nameCode;
                    this.logo = logo;
                    this.gender = gender;
                    this.countryCode = countryCode;
                    this.foundation = foundation;
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

                public String getNameFull() {
                    return nameFull;
                }

                public String getNameCode() {
                    return nameCode;
                }

                public Boolean getHasSub() {
                    return hasSub;
                }

                public Boolean getHasLogo() {
                    return hasLogo;
                }

                public String getLogo() {
                    return logo;
                }

                public String getGender() {
                    return gender;
                }

                public Boolean getNationality() {
                    return isNationality;
                }

                public String getCountryCode() {
                    return countryCode;
                }

                public String getCountry() {
                    return country;
                }

                public String getFlag() {
                    return flag;
                }

                public String getFoundation() {
                    return foundation;
                }

                public Object getDetails() {
                    return details;
                }
            }

            public class HomeScore {
                @SerializedName("current")
                private Integer current;
                @SerializedName("display")
                private Integer display;
                @SerializedName("period_1")
                private Integer period1;

                public HomeScore(Integer current, Integer display, Integer period1) {
                    this.current = current;
                    this.display = display;
                    this.period1 = period1;
                }

                public Integer getCurrent() {
                    return current;
                }

                public Integer getDisplay() {
                    return display;
                }

                public Integer getPeriod1() {
                    return period1;
                }
            }

                public class Season {
                    @SerializedName("id")
                    private Integer id;
                    @SerializedName("slug")
                    private String slug;
                    @SerializedName("name")
                    private String name;
                    @SerializedName("year_start")
                    private Integer yearStart;
                    @SerializedName("year_end")
                    private Integer yearEnd;

                    public Season(Integer id, String slug, String name, Integer yearStart, Integer yearEnd) {
                        this.id = id;
                        this.slug = slug;
                        this.name = name;
                        this.yearStart = yearStart;
                        this.yearEnd = yearEnd;
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

                    public Integer getYearStart() {
                        return yearStart;
                    }

                    public Integer getYearEnd() {
                        return yearEnd;
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

            public String getStatus() {
                return status;
            }

            public String getStatusMore() {
                return statusMore;
            }

            public HomeTeam getHomeTeam() {
                return homeTeam;
            }

            public HomeTeam getAwayTeam() {
                return awayTeam;
            }

            public String getStartAt() {
                return startAt;
            }

            public Integer getPriority() {
                return priority;
            }

            public HomeScore getHomeScore() {
                return homeScore;
            }

            public HomeScore getAwayScore() {
                return awayScore;
            }

            public Integer getWinnerCode() {
                return winnerCode;
            }

            public Season getSeason() {
                return season;
            }
        }

        public List<Datum> getData() {
        return data;
    }
}
