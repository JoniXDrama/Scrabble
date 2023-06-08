package view;

import javafx.beans.binding.Bindings;
import model.Model;
import model.network.GameServer;
import view_model.ViewModel;
import java.util.Observable;
import java.util.Observer;

public class View implements Observer {
    LandingPage landingPage;
    GamePage gamePage = GamePage.getGP();
    ViewModel vm = ViewModel.getViewModel();


    public View() {
        this.landingPage  = new LandingPage();
        GamePage.getGP();
    }



    public void setViewModel() {
        //The lambda expression is used to convert the integer value to a string using Integer.toString().
        //The second argument vm.score specifies that the binding should be recomputed whenever the value of vm.score changes.
        gamePage.scoreLabel.textProperty().bind(vm.score.asString());

    }


    @Override
    public void update(Observable o, Object arg) {

    }

    //GETTES
    public LandingPage getLandingPage() {return landingPage;}
    public GamePage getGamePage() {return gamePage;}
    private  static class ViewHolder{ public static final View v = new View();}
    public static View getView() {return ViewHolder.v;}



}