package com.example.rma.model;

import com.example.rma.model.player.Players;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class FixturesMatchFixturesModel {

    @SerializedName("fixture_id")
    @Expose
    private Long fixtureId;
    @SerializedName("league_id")
    @Expose
    private Long leagueId;
    @SerializedName("league")
    @Expose
    private FixturesMatchLeagueModel league;
    @SerializedName("event_date")
    @Expose
    private String eventDate;
    @SerializedName("event_timestamp")
    @Expose
    private Long eventTimestamp;
    @SerializedName("firstHalfStart")
    @Expose
    private Long firstHalfStart;
    @SerializedName("secondHalfStart")
    @Expose
    private Long secondHalfStart;
    @SerializedName("round")
    @Expose
    private String round;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("statusShort")
    @Expose
    private String statusShort;
    @SerializedName("elapsed")
    @Expose
    private Long elapsed;
    @SerializedName("venue")
    @Expose
    private String venue;
    @SerializedName("referee")
    @Expose
    private String referee;
    @SerializedName("homeTeam")
    @Expose
    private FixturesMatchHomeTeamModel homeTeam;
    @SerializedName("awayTeam")
    @Expose
    private FixturesMatchAwayTeamModel awayTeam;
    @SerializedName("goalsHomeTeam")
    @Expose
    private Long goalsHomeTeam;
    @SerializedName("goalsAwayTeam")
    @Expose
    private Long goalsAwayTeam;
    @SerializedName("score")
    @Expose(deserialize = false,serialize = false)
    private String score=null;
    @SerializedName("events")
    @Expose(deserialize = false,serialize = false)
    private String events = null;
    @SerializedName("lineups")
    @Expose()
    private Map<String, Map<String,Object>> lineups;
    @SerializedName("statistics")
    @Expose(deserialize = false,serialize = false)
    private String statistics=null;
    @SerializedName("players")
    @Expose()
    private List<Players> players;

    public Long getFixtureId() {
        return fixtureId;
    }

    public void setFixtureId(Long fixtureId) {
        this.fixtureId = fixtureId;
    }

    public Long getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Long leagueId) {
        this.leagueId = leagueId;
    }

    public FixturesMatchLeagueModel getLeague() {
        return league;
    }

    public void setLeague(FixturesMatchLeagueModel league) {
        this.league = league;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public Long getEventTimestamp() {
        return eventTimestamp;
    }

    public void setEventTimestamp(Long eventTimestamp) {
        this.eventTimestamp = eventTimestamp;
    }

    public Long getFirstHalfStart() {
        return firstHalfStart;
    }

    public void setFirstHalfStart(Long firstHalfStart) {
        this.firstHalfStart = firstHalfStart;
    }

    public Long getSecondHalfStart() {
        return secondHalfStart;
    }

    public void setSecondHalfStart(Long secondHalfStart) {
        this.secondHalfStart = secondHalfStart;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusShort() {
        return statusShort;
    }

    public void setStatusShort(String statusShort) {
        this.statusShort = statusShort;
    }

    public Long getElapsed() {
        return elapsed;
    }

    public void setElapsed(Long elapsed) {
        this.elapsed = elapsed;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getReferee() {
        return referee;
    }

    public void setReferee(String referee) {
        this.referee = referee;
    }

    public FixturesMatchHomeTeamModel getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(FixturesMatchHomeTeamModel homeTeam) {
        this.homeTeam = homeTeam;
    }

    public FixturesMatchAwayTeamModel getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(FixturesMatchAwayTeamModel awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Long getGoalsHomeTeam() {
        return goalsHomeTeam;
    }

    public void setGoalsHomeTeam(Long goalsHomeTeam) {
        this.goalsHomeTeam = goalsHomeTeam;
    }

    public Long getGoalsAwayTeam() {
        return goalsAwayTeam;
    }

    public void setGoalsAwayTeam(Long goalsAwayTeam) {
        this.goalsAwayTeam = goalsAwayTeam;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getEvents() {
        return events;
    }

    public void setEvents(String events) {
        this.events = events;
    }

    public  Map<String, Map<String,Object>> getLineups() {
        return lineups;
    }

    public void setLineups( Map<String, Map<String,Object>> lineups) {
        this.lineups = lineups;
    }

    public String getStatistics() {
        return statistics;
    }

    public void setStatistics(String statistics) {
        this.statistics = statistics;
    }

    public List<Players> getPlayers() {
        return players;
    }

    public void setPlayers(List<Players> players) {
        this.players = players;
    }
}
