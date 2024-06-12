package de.fhkiel.tsw;

import de.fhkiel.tsw.armyoffrogs.Color;
import de.fhkiel.tsw.armyoffrogs.Game;
import de.fhkiel.tsw.armyoffrogs.Position;

import java.util.*;

///
public class Gamelogic implements Game {
    private Player[] players;
    private List<Player> playerList;
    private Bag gameBag;
    private boolean spielLaueft;
    private int numOfPlayers = 0;
    private int gameRound;
    private boolean frogonBoard = false;
    private int x;
    private int y;
    private List<Frog> frogsOnBoard = new ArrayList<>();
    private Set<Position> board;
    private Color selectedFrog;

    @Override
    public boolean newGame(int numberOfPlayers) {

        if (numberOfPlayers < 2 || numberOfPlayers > 4){
            spielLaueft = false;
            return false;
        }

        gameRound = 0;
        numOfPlayers = numberOfPlayers;
        players = new Player[numberOfPlayers];
        //playerList = new ArrayList<>();

        Color color[] = {Color.Red, Color.Blue, Color.Green, Color.Black,Color.White,Color.Black};
        List<Color> colorList = new ArrayList<>();
        colorList.add(Color.Red);
        colorList.add(Color.Blue);
        colorList.add(Color.Green);
        colorList.add(Color.Black);

        //Collections.shuffle(colorList);
        if (numberOfPlayers < colorList.size()) {
            // If num is smaller, remove elements to decrease the size
            for (int i = colorList.size() - 1; i >= numberOfPlayers; i--) {
                colorList.remove(i);
            }
        }


        board = new HashSet<>();
        for(int i = 0; i < numberOfPlayers; ++i){
            players[i] = new Player(colorList.get(i));
        }


//        int j =0;
//        for(Color singleColor : colorList){
//
//            if( j < numberOfPlayers){
//                players[j]= new Player(singleColor);
//                j++;
//            }
//
//        }

        gameBag = new Bag(numberOfPlayers*10,colorList);
       // startGame(numberOfPlayers,gameBag);
        return true;
    }


    @Override
    public Color[] players() {

        List<Color> test = new ArrayList<>();
        for(Player playCol : this.players){
            test.add(playCol.getPlayerColor());
        }

        Color[] test2 = new Color[test.size()];
        int i = 0;
        for(Color oneColor: test){
            test2[i]= oneColor;
            i++;
        }

        return test2;
    }

    public int numberOfPlayers() {
        return numOfPlayers;
    }

    public int numofFrogsPlayed(){
        int frogsPlayed = 0;
        for(Player player : players){
            frogsPlayed += gameBag.getFrogsInBag(player.getPlayerColor()).size();
        }
        return gameBag.getNumoffrogs();
    }

    @Override
    public String getInfo() {
        return null;
    }

    @Override
    public List<Color> getFrogsInHand(Color player) {
        List<Color> frogsInHand = new ArrayList<>();
        for(Player play : players){
            if(play.getPlayerColor() == player){
                for(Frog frog : play.getFrogsInHand()){
                    frogsInHand.add(frog.getFrogColor());
                }
            }
        }
        return frogsInHand;
    }

    @Override
    public Set<Position> getBoard() {
        return board;
    }

    @Override
    public void clicked(Position position) {
        /*if (currentPhase == GamePhase.ANLEGEN && selectedFrog != null) {
            if (isPositionOccupied(position)) {
                System.out.println("Position " + position + " ist bereits besetzt.");
            } else {
                board.add(new Position(selectedFrog, position.x(), position.y(), position.border()));
                selectedFrog = null;
                System.out.println("clicked(" + position + ") ausgeführt.");
                // Automatically proceed to the next phase (Nachziehen)
                currentPhase = GamePhase.NACHZIEHEN;
                drawFrog();
                endTurn();
            }
        } else {
            System.out.println("Invalid action for current phase or no frog selected.");
        }*/

        //board.add()
    }

    @Override
    public void selectedFrogInHand(Color player, Color frog) {

    for (Player play : players) {
        if (play.getPlayerColor() == player) {
            //play.setFrogsInHand(new Frog(frog));
            selectedFrog = frog;
            play.setFrogsInHand(new Frog(frog));
            play.getFrogs().removeIf(frog1 -> frog1.getFrogColor() == frog);
        }
    }

    }

    @Override
    public Color winner() {

        boolean testWinner = false;
        List<Color> currentPlayerColors = new ArrayList<>();
        List<Position> positionsOfSinglePlayer = new ArrayList<>();
        for(Player play : players){
            currentPlayerColors.add(play.getPlayerColor());
        }
        for (Color playerColor: currentPlayerColors){

            for(Position pos : board){
                if(pos.frog() == playerColor){
                    positionsOfSinglePlayer.add(pos);
                }
            }
            if(positionsOfSinglePlayer.size() >= 7){

                for(int i= 0; i < positionsOfSinglePlayer.size() - 1; i++){

                    int q1 = positionsOfSinglePlayer.get(i).x();
                    int r1 = positionsOfSinglePlayer.get(i).y();
                    int q2 = positionsOfSinglePlayer.get(i+1).x();
                    int r2 = positionsOfSinglePlayer.get(i+1).y();
                    if(areNeighbours(q1,r1,q2,r2)){
                        testWinner = true;
                    }
                    else{
                        testWinner = false;
                    }
                }

                if(testWinner){
                    return playerColor;
                }

            }

        }


        return null;
    }

    @Override
    public boolean save(String filename) {
        return false;
    }

    @Override
    public boolean load(String filename) {


        return false;
    }

    //private Bag bag = new Bag();

    @Override
    public int frogsInBag() {
        return gameBag.getNumoffrogs();
    }

    public int frogsInBag_withColor(Color color) {
        return gameBag.getFrogsInBag(color).size();
    }

    public void startGame(int spieler, Bag gamebag) {
        //bag = new Bag(spieler*10);
        for (int i = 0; i < 2*spieler; ++i){
            gamebag.takeFrog();
        }
    }

    public void takeFrogFromBag() {
        for(Player player : players){
                if(player.getFrogsInHand().size() < 2)  {
                    gameBag.takeFrog(player.getPlayerColor());
                    player.setMyFrogs(gameBag.getFrogsInBag(player.getPlayerColor()));
                    player.setFrogsInHand(new Frog(player.getPlayerColor()));
                }

        }
    }

    public void takeFrogFromBag(Color color) {


        for(Player player : players){
            if(player.getPlayerColor() == color && player.getFrogsInHand().size() < 2)  {
                    gameBag.takeFrog(color);
                    player.setMyFrogs(gameBag.getFrogsInBag(color));
                    player.setFrogsInHand(new Frog(color));
                }

        }


    }

    public boolean endGame() {
        spielLaueft = false;
        return !spielLaueft;
    }

    public void setGameRound(int gameRound) {
        this.gameRound = gameRound;
    }

    public boolean isFrogonBoard() {
        return frogonBoard;
    }

    public Bag getGameBag() {
        return gameBag;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void anlegen(Frog frog,int x, int y) {

        try{

            for (Position pos : board){
                if(pos.x() == frog.getPosition().x() && pos.y() == frog.getPosition().y()){
                    throw new Exception("Frog already on board");
                }
            }

            Position currentFrogPosition = new Position(frog.getFrogColor(),x,y,Color.None);
            frog.setPosition(currentFrogPosition);
            frog.setFrogInGame(true);
            frogsOnBoard.add(frog);
            board.add(frog.getPosition());

        }catch (Exception e){
            e.printStackTrace();
        }

       Position currentFrogPosition = new Position(frog.getFrogColor(),x,y,Color.None);
       frog.setPosition(currentFrogPosition);
        frog.setFrogInGame(true);

    }

    public void bewegen(Frog frog, int x, int y) {

        try{
            if(!frog.isFrogInGame()){
                return;
            }

            for (Position pos : board){
                if(pos.x() == frog.getPosition().x() && pos.y() == frog.getPosition().y()){
                    board.remove(pos);
                    break;
                }
            }
            frog.setPosition(null);
            Color borderColor = Color.None;

            for(Frog frog1 : frogsOnBoard){
                if(frog1.getPosition().x() == x && frog1.getPosition().y() == y){
                    frog1.setPosition(null);
                    return;
                }

                if(frog1.getPosition().x() == x || frog1.getPosition().y() == y){
                    borderColor = frog1.getPosition().border();
                }

            }
            Position currentFrogPosition = new Position(frog.getFrogColor(),x,y,borderColor);
            frog.setPosition(currentFrogPosition);

        }
        catch (Exception e){
            e.printStackTrace();}


    }

    public void nachzeihen(Color color) {
        takeFrogFromBag();
    }

    public boolean areNeighbours(int q1,int r1, int q2, int r2) {

        return (q2 == q1 + 1 && r2 == r1) || // Right neighbor
                (q2 == q1 - 1 && r2 == r1) || // Left neighbor
                (q2 == q1 && r2 == r1 + 1) || // Upper-right neighbor
                (q2 == q1 && r2 == r1 - 1) || // Lower-left neighbor
                (q2 == q1 + 1 && r2 == r1 - 1) || // Upper-left neighbor
                (q2 == q1 - 1 && r2 == r1 + 1); // Lower-right neighbor
    }

}
