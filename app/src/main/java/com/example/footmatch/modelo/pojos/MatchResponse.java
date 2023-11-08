package com.example.footmatch.modelo.pojos;

import java.util.List;

public class MatchResponse {
    public class Area {
        private int id;
        private String name;
        private String code;
        private String flag;

        // Getters y setters


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getFlag() {
            return flag;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }
    }

    public class Competition {
        private int id;
        private String name;
        private String code;
        private String type;
        private String emblem;

        // Getters y setters

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getEmblem() {
            return emblem;
        }

        public void setEmblem(String emblem) {
            this.emblem = emblem;
        }
    }

    public class Season {
        private int id;
        private String startDate;
        private String endDate;
        private int currentMatchday;
        private String winner;
        private List<String> stages;

        // Getters y setters

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getStartDate() {
            return startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public int getCurrentMatchday() {
            return currentMatchday;
        }

        public void setCurrentMatchday(int currentMatchday) {
            this.currentMatchday = currentMatchday;
        }

        public String getWinner() {
            return winner;
        }

        public void setWinner(String winner) {
            this.winner = winner;
        }

        public List<String> getStages() {
            return stages;
        }

        public void setStages(List<String> stages) {
            this.stages = stages;
        }
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


    // Otras propiedades, getters y setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUtcDate() {
        return utcDate;
    }

    public void setUtcDate(String utcDate) {
        this.utcDate = utcDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getInjuryTime() {
        return injuryTime;
    }

    public void setInjuryTime(int injuryTime) {
        this.injuryTime = injuryTime;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public int getMatchday() {
        return matchday;
    }

    public void setMatchday(int matchday) {
        this.matchday = matchday;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public HomeTeam getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(HomeTeam homeTeam) {
        this.homeTeam = homeTeam;
    }

    public AwayTeam getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(AwayTeam awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Score getScore(){return score;}

    public void setScore(Score score){this.score = score;}

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }


    public class HomeTeam {
        private String id;
        private String name;
        private String shortName;
        private String tla;
        private String crest;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getShortName() {
            return shortName;
        }

        public void setShortName(String shortName) {
            this.shortName = shortName;
        }

        public String getTla() {
            return tla;
        }

        public void setTla(String tla) {
            this.tla = tla;
        }

        public String getCrest() {
            return crest;
        }

        public void setCrest(String crest) {
            this.crest = crest;
        }
    }

    public class AwayTeam {
        private String id;
        private String name;
        private String shortName;
        private String tla;
        private String crest;

        // Getters y setters

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getShortName() {
            return shortName;
        }

        public void setShortName(String shortName) {
            this.shortName = shortName;
        }

        public String getTla() {
            return tla;
        }

        public void setTla(String tla) {
            this.tla = tla;
        }

        public String getCrest() {
            return crest;
        }

        public void setCrest(String crest) {
            this.crest = crest;
        }
    }
    public class Score {
        private String winner;
        private String duration;
        private FullTime fullTime;
        private HalfTime halfTime;

        // Getters y setters

        public String getWinner() {
            return winner;
        }

        public void setWinner(String winner) {
            this.winner = winner;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public FullTime getFullTime() {
            return fullTime;
        }

        public void setFullTime(FullTime fullTime) {
            this.fullTime = fullTime;
        }

        public HalfTime getHalfTime() {
            return halfTime;
        }

        public void setHalfTime(HalfTime halfTime) {
            this.halfTime = halfTime;
        }
    }

    public class FullTime {
        private int home;
        private int away;

        // Getters y setters

        public int getHome() {
            return home;
        }

        public void setHome(int home) {
            this.home = home;
        }

        public int getAway() {
            return away;
        }

        public void setAway(int away) {
            this.away = away;
        }
    }

    public class HalfTime {
        private int home;
        private int away;

        // Getters y setters

        public int getHome() {
            return home;
        }

        public void setHome(int home) {
            this.home = home;
        }

        public int getAway() {
            return away;
        }

        public void setAway(int away) {
            this.away = away;
        }
    }





    public class Goals {
        private int minute;
        private Integer injuryTime;
        private String type;
        private Team team;
        private Scorer scorer;
        private Object assist;
        private Score score;

        // Getters y setters

        public int getMinute() {
            return minute;
        }

        public void setMinute(int minute) {
            this.minute = minute;
        }

        public Integer getInjuryTime() {
            return injuryTime;
        }

        public void setInjuryTime(Integer injuryTime) {
            this.injuryTime = injuryTime;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Team getTeam() {
            return team;
        }

        public void setTeam(Team team) {
            this.team = team;
        }

        public Scorer getScorer() {
            return scorer;
        }

        public void setScorer(Scorer scorer) {
            this.scorer = scorer;
        }

        public Object getAssist() {
            return assist;
        }

        public void setAssist(Object assist) {
            this.assist = assist;
        }

        public Score getScore() {
            return score;
        }

        public void setScore(Score score) {
            this.score = score;
        }
    }

    public class Team {
        private int id;
        private String name;

        // Getters y setters

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public class Scorer {
        private int id;
        private String name;

        // Getters y setters

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public class Penalties {
        private Player player;
        private Team team;
        private boolean scored;

        // Getters y setters

        public Player getPlayer() {
            return player;
        }

        public void setPlayer(Player player) {
            this.player = player;
        }

        public Team getTeam() {
            return team;
        }

        public void setTeam(Team team) {
            this.team = team;
        }

        public boolean isScored() {
            return scored;
        }

        public void setScored(boolean scored) {
            this.scored = scored;
        }
    }

    public class Bookings {
        private int minute;
        private Team team;
        private Player player;
        private String card;

        // Getters y setters

        public int getMinute() {
            return minute;
        }

        public void setMinute(int minute) {
            this.minute = minute;
        }

        public Team getTeam() {
            return team;
        }

        public void setTeam(Team team) {
            this.team = team;
        }

        public Player getPlayer() {
            return player;
        }

        public void setPlayer(Player player) {
            this.player = player;
        }

        public String getCard() {
            return card;
        }

        public void setCard(String card) {
            this.card = card;
        }
    }

    public class Player {
        private int id;
        private String name;

        // Getters y setters

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public class Substitutions {
        private int minute;
        private Team team;
        private Player playerOut;
        private Player playerIn;

        // Getters y setters

        public int getMinute() {
            return minute;
        }

        public void setMinute(int minute) {
            this.minute = minute;
        }

        public Team getTeam() {
            return team;
        }

        public void setTeam(Team team) {
            this.team = team;
        }

        public Player getPlayerOut() {
            return playerOut;
        }

        public void setPlayerOut(Player playerOut) {
            this.playerOut = playerOut;
        }

        public Player getPlayerIn() {
            return playerIn;
        }

        public void setPlayerIn(Player playerIn) {
            this.playerIn = playerIn;
        }
    }

    public class Odds {
        private double homeWin;
        private double draw;
        private double awayWin;

        // Getters y setters

        public double getHomeWin() {
            return homeWin;
        }

        public void setHomeWin(double homeWin) {
            this.homeWin = homeWin;
        }

        public double getDraw() {
            return draw;
        }

        public void setDraw(double draw) {
            this.draw = draw;
        }

        public double getAwayWin() {
            return awayWin;
        }

        public void setAwayWin(double awayWin) {
            this.awayWin = awayWin;
        }
    }

    public class Referees {
        private int id;
        private String name;
        private String type;
        private String nationality;

        // Getters y setters

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getNationality() {
            return nationality;
        }

        public void setNationality(String nationality) {
            this.nationality = nationality;
        }
    }

    // Getters y setters para las clases anidadas

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", minute=" + minute +
                ", matchday=" + matchday +
                ", homeTeam=" + homeTeam.getName() +
                ", awayTeam=" + awayTeam.getName() +
                '}';
    }


    // Puedes agregar otros getters y setters según sea necesario
}
