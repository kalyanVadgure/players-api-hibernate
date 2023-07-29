/*
 * You can use the following import statements
 * import javax.persistence.*;
 * 
 */

// Write your code here

package com.example.player.model;

import javax.persistence.*;


@Entity
@Table(name="team")
public class Player {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="playerid")
    private Integer playerId;

    @Column(name="playername")
    private String playerName;

    @Column(name="jerseynumber")
    private Integer jerseyNumber;

    @Column(name="role")
    private String role;

    public Player() {

    }

    public Player(Integer playerId, String playerName, Integer jerseyNumber, String role) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.jerseyNumber = jerseyNumber;
        this.role = role;
        
    }


    public Integer getplayerId() {
        return this.playerId;
    }

    public void setplayerId(Integer updatedPalyerId) {
        this.playerId = updatedPalyerId;
    }
    public String getPlayerName() {
        return this.playerName;
    }

    public void setPlayerName(String updatedName) {
        this.playerName = updatedName;
    }

    public Integer getJerseyNumber() {
        return this.jerseyNumber;
    }

    public void setJerseyNumber(Integer updatedJerseyNumber) {
        this.jerseyNumber = updatedJerseyNumber;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String updatedRole) {
        this.role = updatedRole;
    }

}