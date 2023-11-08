package com.example.footmatch.modelo.pojos;

public class ResultSet {
    private int count;
    private String competitions;
    private String first;
    private String last;
    private int played;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getCompetitions() {
        return competitions;
    }

    public void setCompetitions(String competitions) {
        this.competitions = competitions;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public int getPlayed() {
        return played;
    }

    public void setPlayed(int played) {
        this.played = played;
    }
}
