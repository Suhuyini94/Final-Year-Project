package frames;

import Backend_database.Storeroom;
import ConnectorP.Performcollection;
import database.collections;

import javax.swing.*;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws Exception {
        Performcollection controller=new Performcollection();
        collections DB=new collections();

        Appsettings app=new Appsettings();
        app.setSize(600,600);
        app.setVisible(true);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        if(controller.getAllusers().size() >0){
            app.dispose();
            DB.disconnected();
        }

    }

}

