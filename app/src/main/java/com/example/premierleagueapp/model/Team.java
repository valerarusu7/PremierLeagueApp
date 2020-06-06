package com.example.premierleagueapp.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity(tableName = "favorite_team_table")
public class Team {
    @PrimaryKey(autoGenerate = true)
    private int uid;
    @NonNull
    @Ignore
    private int id;
    @Ignore
    private Area area;
    @Ignore
    private ArrayList<Competition> activeCompetitions;
    private String name;
    private String shortName;
    private String tla;
    private String crestUrl;
    private String address;
    private String phone;
    private String website;
    private String email;
    private int founded;
    private String clubColors;
    private String venue;
    @Ignore
    private ArrayList<Player> squad;
    private String lastUpdated;

    public Team(int id, Area area, ArrayList<Competition> activeCompetitions, String name, String shortName, String tla, String crestUrl, String address, String phone, String website, String email, int founded, String clubColors, String venue, ArrayList<Player> squad, String lastUpdated) {
        this.id = id;
        this.area = area;
        this.activeCompetitions = activeCompetitions;
        this.name = name;
        this.shortName = shortName;
        this.tla = tla;
        this.crestUrl = crestUrl;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.email = email;
        this.founded = founded;
        this.clubColors = clubColors;
        this.venue = venue;
        this.squad = squad;
        this.lastUpdated = lastUpdated;
    }

    public Team() {
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public ArrayList<Competition> getActiveCompetitions() {
        return activeCompetitions;
    }

    public void setActiveCompetitions(ArrayList<Competition> activeCompetitions) {
        this.activeCompetitions = activeCompetitions;
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

    public String getCrestUrl() {
        return crestUrl;
    }

    public void setCrestUrl(String crestUrl) {
        this.crestUrl = crestUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getFounded() {
        return founded;
    }

    public void setFounded(int founded) {
        this.founded = founded;
    }

    public String getClubColors() {
        return clubColors;
    }

    public void setClubColors(String clubColors) {
        this.clubColors = clubColors;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public ArrayList<Player> getSquad() {
        return squad;
    }

    public void setSquad(ArrayList<Player> squad) {
        this.squad = squad;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return name;
    }
}

