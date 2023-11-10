package com.example.footmatch.modelo.pojos;

import java.util.List;

import lombok.Data;

@Data
public class MatchResponse {

    @Data
    public class Area {
        private int id;
        private String name;
        private String code;
        private String flag;

    }

    @Data
    public class Competition {
        private int id;
        private String name;
        private String code;
        private String type;
        private String emblem;

    }

    @Data
    public class Season {
        private int id;
        private String startDate;
        private String endDate;
        private int currentMatchday;
        private String winner;
        private List<String> stages;

    }

    private int id;
    private String utcDate;
    private String status;
    private int minute;
    private int injuryTime;
    private int attendance;
    private String venue;
    private int matchday;
    private String stage;
    private String group;
    private String lastUpdated;
    private HomeTeam homeTeam;
    private AwayTeam awayTeam;
    private Score score;
    private Season season;



    @Data
    public class HomeTeam {
        private String id;
        private String name;
        private String shortName;
        private String tla;
        private String crest;

    }

    @Data
    public class AwayTeam {
        private String id;
        private String name;
        private String shortName;
        private String tla;
        private String crest;

    }

    @Data
    public class Score {
        private String winner;
        private String duration;
        private FullTime fullTime;
        private HalfTime halfTime;

    }

    @Data
    public class FullTime {
        private int home;
        private int away;

    }

    @Data
    public class HalfTime {
        private int home;
        private int away;

    }

    @Data
    public class Goals {
        private int minute;
        private Integer injuryTime;
        private String type;
        private Team team;
        private Scorer scorer;
        private Object assist;
        private Score score;

    }

    @Data
    public class Team {
        private int id;
        private String name;

    }

    @Data
    public class Scorer {
        private int id;
        private String name;

    }

    @Data
    public class Penalties {
        private Player player;
        private Team team;
        private boolean scored;

    }

    @Data
    public class Bookings {
        private int minute;
        private Team team;
        private Player player;
        private String card;

    }

    @Data
    public class Player {
        private int id;
        private String name;

    }

    @Data
    public class Substitutions {
        private int minute;
        private Team team;
        private Player playerOut;
        private Player playerIn;

    }

    @Data
    public class Odds {
        private double homeWin;
        private double draw;
        private double awayWin;

    }

    @Data
    public class Referees {
        private int id;
        private String name;
        private String type;
        private String nationality;

    }


}
