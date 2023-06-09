package view_model;

import javafx.application.Platform;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Model;
import model.network.GameServer;
import view.View;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ViewModel extends Observable implements Observer {
    public Model m = Model.getModel();
    public IntegerProperty score;
    public StringProperty playerQuery;
    public ListProperty<String> playerHand;

    public ViewModel() {
        this.score = new SimpleIntegerProperty(0);
        this.playerHand = new SimpleListProperty<>();
        this.playerQuery = new SimpleStringProperty("");
    }

    public void hostGame(int port, String name) {
        m.hostGame(port, name);
    }

    public void joinGame(String ip, int port, String name) {
        m.joinGame(ip, port, name);
    }

    public void initPlayersBoard() {
        GameServer.broadcastToClients("/start");
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o == m) {
            Platform.runLater(() -> {
                score.set(m.getPlayerScore());
            });
            playerHand.set(FXCollections.observableList(m.getPlayerHand()));
            View.getView().setPlayerHand();
            // converting the m.getPlayerHand() to observableList (Only way to make apply the set)
            playerQuery.unbind();
            playerQuery.set(m.getPlayerQuery());

        }
    }




    //GETTERS
        public Model getModel () {
            return m;
        }
        public int getScore () {
            return score.get();
        }
        private static class ViewModelHolder {
            public static final ViewModel vm = new ViewModel();
        }
        public static ViewModel getViewModel () {
            return ViewModelHolder.vm;
        }

}
