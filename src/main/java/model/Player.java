package model;

import model.concrete.Board;
import model.concrete.Tile;
import model.concrete.Word;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Player {
    String playerName;
    int id;
    List<Tile> playerHand;
    int handSize; // physical size of tiles
    int sumScore;
    static String wordQuery;

boolean isTurnOver;

    public Player(){
        this.id = 0;
        this.playerHand = new ArrayList<>();
        this.handSize = 7;
        this.sumScore = 0;
        isTurnOver = false;
    }

//    public int makeMove(Word w, GameState gameState){
//        // if makeMove fails this integer will stay 0.
//        int tmpMoveScore = 0;
//
//        // if tiles are over
//        if(handSize == 0){
//            System.out.println("Tiles are over");
//            return tmpMoveScore;
//        }
//        // if the player wants to place a word with not enough tiles
//        else if(w.getTiles().length > handSize){
//            System.out.println("Tiles are over");
//            return tmpMoveScore;
//        }
//        // if the player don't have all the tiles for the word
//        else if(!isContain(w)){
//            System.out.println("Not all word tiles are existed");
//            return tmpMoveScore;
//        }
//        tmpMoveScore += gameState.board.tryPlaceWord(w); // placing the word at the same board
//        // after all checks,decline the words size from pack and init pack back to 7.
//        if(tmpMoveScore != 0){
//            handSize -= w.getTiles().length;
//            initHandAfterMove(w);
//        }
//        sumScore += tmpMoveScore;
//        //if tmpMoveScore is 0 then one of the checks is failed
//        return tmpMoveScore;
//    }


    //checking if the word tiles ar in player pack
//    private boolean isContain(Word w) {
//        for(Tile t: playerHand){
//            if(!(Arrays.stream(w.getTiles()).toList().contains(t))){
//                return false;
//            }
//        }
//        return true;
//    }


    // func for re-packing the player hand with tiles after placing word on board
//    public void initHandAfterMove(Word w) {
//        List<Tile>tmpWordList = Arrays.stream(w.getTiles()).toList();
//        playerHand = playerHand.stream().filter((t)->!tmpWordList.contains(t)).collect(Collectors.toList());
//        while(!handIsFull()){
//            playerHand.add(GameState.bag.getRand());
//            handSize++;
//        }
//    }
//    // first initialization of players pack.
//
//    public void initHand(){
//        for(int i = 0; i < handSize; i++){
//            playerHand.add(GameState.getBag().getRand());
//        }
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id == player.id && handSize == player.handSize && sumScore == player.sumScore && isTurnOver == player.isTurnOver && Objects.equals(playerName, player.playerName) && Objects.equals(playerHand, player.playerHand) && Objects.equals(wordQuery, player.wordQuery);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName, id, playerHand, handSize, sumScore, wordQuery, isTurnOver);
    }

    //Getters
    public boolean handIsFull()
    {
        return playerHand.size() == 7;
    }

    public int getHandSize()
    {
        return handSize;
    }

    public List<Tile> getPlayerHand()
    {
        return this.playerHand;
    }

    public String getWordQuery()
    {
        return wordQuery;
    }

    public int getId() {return id;}

    public static void setWordQuery(String q)
    {
        wordQuery = q;
    }

public void setName(String name)
{
    this.playerName = name;
}

}