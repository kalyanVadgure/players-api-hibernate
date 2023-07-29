/*
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 * 
 */

package com.example.player.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.*;
import com.example.player.model.*;
import com.example.player.repository.*;


@Service
public class PlayerJpaService implements PlayerRepository {
  @Autowired 
  public PlayerJpaRepository playerJpaRepository;

  @Override
  public ArrayList<Player> getPlayers() {
    List<Player> playerList = playerJpaRepository.findAll();
    ArrayList<Player> players = new ArrayList<>(playerList);

    return players;
  }

  @Override
  public Player getPlayerbyId(int playerId) {
    try {
      Player player = playerJpaRepository.findById(playerId).get();
      return player;

    } catch(Exception e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
  } 

  @Override
  public Player addPlayer(Player player) {
    playerJpaRepository.save(player);
    return player;
  }

  @Override 
  public Player updatePlayer(int playerId, Player player) {
    try {
      Player newPlayer = playerJpaRepository.findById(playerId).get();
      if(player.getPlayerName() != null) {
        newPlayer.setPlayerName(player.getPlayerName());
      }

      if(player.getJerseyNumber() != null) {
        newPlayer.setJerseyNumber(player.getJerseyNumber());
      }

      if(player.getRole() != null) {
        newPlayer.setRole(player.getRole());
      }

      playerJpaRepository.save(newPlayer);
      return newPlayer;

    } catch(Exception e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
  }

  @Override 
  public void deletePlayer(int playerId) {
    try {
      playerJpaRepository.deleteById(playerId);

    } catch(Exception e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
  }

}



