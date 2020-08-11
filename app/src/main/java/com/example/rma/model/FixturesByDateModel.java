package com.example.rma.model;

public class FixturesByDateModel {

    private String fixtureId;
    private String eventTimestamp;
    private String eventDate;
    private String leagueId;
    private String round;
    private String homeTeamId;
    private String awayTeamId;
    private String homeTeam;
    private String awayTeam;
    private String status;
    private String statusShort;
    private String goalsHomeTeam;
    private String goalsAwayTeam;
    private String halftimeScore;
    private String finalScore;
    private String penalty;
    private String elapsed;
    private String firstHalfStart;
    private String secondHalfStart;

    public FixturesByDateModel(String homeTeam, String awayTeam) {
            this.homeTeam=homeTeam;
            this.awayTeam=awayTeam;
    }

    public void setFixtureId(String fixtureId) {
        this.fixtureId = fixtureId;
    }

    public void setEventTimestamp(String eventTimestamp) {
        this.eventTimestamp = eventTimestamp;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public void setLeagueId(String leagueId) {
        this.leagueId = leagueId;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public void setHomeTeamId(String homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public void setAwayTeamId(String awayTeamId) {
        this.awayTeamId = awayTeamId;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStatusShort(String statusShort) {
        this.statusShort = statusShort;
    }

    public void setGoalsHomeTeam(String goalsHomeTeam) {
        this.goalsHomeTeam = goalsHomeTeam;
    }

    public void setGoalsAwayTeam(String goalsAwayTeam) {
        this.goalsAwayTeam = goalsAwayTeam;
    }

    public void setHalftimeScore(String halftimeScore) {
        this.halftimeScore = halftimeScore;
    }

    public void setFinalScore(String finalScore) {
        this.finalScore = finalScore;
    }

    public void setPenalty(String penalty) {
        this.penalty = penalty;
    }

    public void setElapsed(String elapsed) {
        this.elapsed = elapsed;
    }

    public void setFirstHalfStart(String firstHalfStart) {
        this.firstHalfStart = firstHalfStart;
    }

    public void setSecondHalfStart(String secondHalfStart) {
        this.secondHalfStart = secondHalfStart;
    }

    public String getFixtureId() {
        return fixtureId;
    }

    public String getEventTimestamp() {
        return eventTimestamp;
    }

    public String getEventDate() {
        return eventDate;
    }

    public String getLeagueId() {
        return leagueId;
    }

    public String getRound() {
        return round;
    }

    public String getHomeTeamId() {
        return homeTeamId;
    }

    public String getAwayTeamId() {
        return awayTeamId;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public String getStatus() {
        return status;
    }

    public String getStatusShort() {
        return statusShort;
    }

    public String getGoalsHomeTeam() {
        return goalsHomeTeam;
    }

    public String getGoalsAwayTeam() {
        return goalsAwayTeam;
    }

    public String getHalftimeScore() {
        return halftimeScore;
    }

    public String getFinalScore() {
        return finalScore;
    }

    public String getPenalty() {
        return penalty;
    }

    public String getElapsed() {
        return elapsed;
    }

    public String getFirstHalfStart() {
        return firstHalfStart;
    }

    public String getSecondHalfStart() {
        return secondHalfStart;
    }

    public FixturesByDateModel(String fixtureId, String eventTimestamp, String eventDate, String leagueId, String round, String homeTeamId, String awayTeamId, String homeTeam, String awayTeam, String status, String statusShort, String goalsHomeTeam, String goalsAwayTeam, String halftimeScore, String finalScore, String penalty, String elapsed, String firstHalfStart, String secondHalfStart) {
        this.fixtureId = fixtureId;
        this.eventTimestamp = eventTimestamp;
        this.eventDate = eventDate;
        this.leagueId = leagueId;
        this.round = round;
        this.homeTeamId = homeTeamId;
        this.awayTeamId = awayTeamId;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.status = status;
        this.statusShort = statusShort;
        this.goalsHomeTeam = goalsHomeTeam;
        this.goalsAwayTeam = goalsAwayTeam;
        this.halftimeScore = halftimeScore;
        this.finalScore = finalScore;
        this.penalty = penalty;
        this.elapsed = elapsed;
        this.firstHalfStart = firstHalfStart;
        this.secondHalfStart = secondHalfStart;
    }

    public FixturesByDateModel() {
    }
}
