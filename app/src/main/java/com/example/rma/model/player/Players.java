package com.example.rma.model.player;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Players {

    @SerializedName("event_id")
    @Expose
    private Long eventId;
    @SerializedName("updateAt")
    @Expose
    private Long updateAt;
    @SerializedName("player_id")
    @Expose
    private Long playerId;
    @SerializedName("player_name")
    @Expose
    private String playerName;
    @SerializedName("team_id")
    @Expose
    private Long teamId;
    @SerializedName("team_name")
    @Expose
    private String teamName;
    @SerializedName("number")
    @Expose
    private Long number;
    @SerializedName("position")
    @Expose
    private String position;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("minutes_played")
    @Expose
    private Long minutesPlayed;
    @SerializedName("captain")
    @Expose
    private String captain;
    @SerializedName("substitute")
    @Expose
    private String substitute;
    @SerializedName("offsides")
    @Expose
    private Object offsides;
    @SerializedName("shots")
    @Expose
    private Shots shots;
    @SerializedName("goals")
    @Expose
    private Goals goals;
    @SerializedName("passes")
    @Expose
    private Passes passes;
    @SerializedName("tackles")
    @Expose
    private Tackles tackles;
    @SerializedName("duels")
    @Expose
    private Duels duels;
    @SerializedName("dribbles")
    @Expose
    private Dribbles dribbles;
    @SerializedName("fouls")
    @Expose
    private Fouls fouls;
    @SerializedName("cards")
    @Expose
    private Cards cards;
    @SerializedName("penalty")
    @Expose
    private Penalty penalty;

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Long getMinutesPlayed() {
        return minutesPlayed;
    }

    public void setMinutesPlayed(Long minutesPlayed) {
        this.minutesPlayed = minutesPlayed;
    }

    public String getCaptain() {
        return captain;
    }

    public void setCaptain(String captain) {
        this.captain = captain;
    }

    public String getSubstitute() {
        return substitute;
    }

    public void setSubstitute(String substitute) {
        this.substitute = substitute;
    }

    public Object getOffsides() {
        return offsides;
    }

    public void setOffsides(Object offsides) {
        this.offsides = offsides;
    }

    public Shots getShots() {
        return shots;
    }

    public void setShots(Shots shots) {
        this.shots = shots;
    }

    public Goals getGoals() {
        return goals;
    }

    public void setGoals(Goals goals) {
        this.goals = goals;
    }

    public Passes getPasses() {
        return passes;
    }

    public void setPasses(Passes passes) {
        this.passes = passes;
    }

    public Tackles getTackles() {
        return tackles;
    }

    public void setTackles(Tackles tackles) {
        this.tackles = tackles;
    }

    public Duels getDuels() {
        return duels;
    }

    public void setDuels(Duels duels) {
        this.duels = duels;
    }

    public Dribbles getDribbles() {
        return dribbles;
    }

    public void setDribbles(Dribbles dribbles) {
        this.dribbles = dribbles;
    }

    public Fouls getFouls() {
        return fouls;
    }

    public void setFouls(Fouls fouls) {
        this.fouls = fouls;
    }

    public Cards getCards() {
        return cards;
    }

    public void setCards(Cards cards) {
        this.cards = cards;
    }

    public Penalty getPenalty() {
        return penalty;
    }

    public void setPenalty(Penalty penalty) {
        this.penalty = penalty;
    }

}
