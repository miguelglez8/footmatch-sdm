package com.example.footmatch.modelo.pojos;

import java.util.List;

import lombok.Data;
@Data
public class MatchesResponse {
    private Filters filters;
    private ResultSet resultSet;
    private List<MatchResponse> matches;

    @Data
    public class ResultSet {
        private int count;
        private String competitions;
        private String first;
        private String last;
        private int played;

    }

    @Data
    public class Filters {
        private String dateFrom;
        private String dateTo;
        private String permission;


    }


}
