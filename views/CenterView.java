package mine.views;

import mine.Controller.ResourceHouse;
import mine.Model.CountryModel;
import orig.Country;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class CenterView {

    private static DefaultListModel<String> listModel;
    private static JList list;
    private static JScrollPane scrollPane;
    private static JSplitPane jSplitPane;
    private  static JTextArea text;
    public CenterView() throws InterruptedException {
        jSplitPane=new JSplitPane();
        text=new JTextArea("Lorem ipsum dolor sit amet, consectetur adipis\n" +
                "cing elit, sed do eiusmod tempor incididunt ut labore et do\n" +
                "lore magna aliqua. Ut enim ad minim veniam, quis nostrud exerci\n" +
                "tation ullamco laboris nisi ut aliquip ex ea commodo consequat. \n" +
                "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum\n" +
                " dolore eu fugiat nulla pariatur. Excepteur sint \n" +
                "occaecat cupidatat non proident, sunt\n" +
                " in culpa qui officia deserunt mollit anim id est laborum.\n");
        text.setEditable(false);
        renderList();
        jSplitPane.setRightComponent(text);





    }

    public JSplitPane getView(){
        return jSplitPane;
    }

    public static void renderList(){
        listModel=new DefaultListModel<>();

        ArrayList<CountryModel> countries=ResourceHouse.controller.getList();
        for (CountryModel c:countries
             ) {
            if(shouldIAdd(c)){
                listModel.addElement(c.getName());
            }
        }

        list=new JList(listModel);
        list.setFixedCellHeight(30);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addListSelectionListener(e -> {
            for (CountryModel c:countries
                 ) {
                if(c.getName().toLowerCase().trim().equals(list.getSelectedValue().toString().toLowerCase().trim())){

                    beautifyAndInsert(c);

                    break;
                }
            }

        });
        scrollPane = new JScrollPane(list);
        jSplitPane.setLeftComponent(scrollPane);
        jSplitPane.setDividerLocation(150);

    }


    private static void beautifyAndInsert(CountryModel c){
        text.setText(c.toString());
    }


    private static boolean shouldIAdd(CountryModel c){
        String selectedVal;
        try {
           selectedVal =TopView.options.getSelectedItem().toString().trim();
        }catch (Exception e){
            return true;
        }


        if(selectedVal.equals("Death Rate")){

            if(c.getDeathRate()<0){
                return false;
            }
            return true;
        }else if(selectedVal.equals("Birth Expectancy")){
            if(c.getLifeExpectancyAtBirth()<0){
                return false;
            }
            return true;

        }else if(selectedVal.equals("Median Age")){
            if(c.getMedianAge()<0){
                return false;
            }
            return true;

        }else if(selectedVal.equals("Electricity consumption")){
            if(c.getElectricityConsumpCapita()<0){
                return false;
            }
            return true;

        }else{
            return true;
        }
    }
}
