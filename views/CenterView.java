package mine;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CenterView {

    private static DefaultListModel<String> listModel;
    private static JList list;
    private static JScrollPane scrollPane;
    private static JSplitPane jSplitPane;
    private  static JTextArea text;
    public CenterView() throws InterruptedException {
        jSplitPane=new JSplitPane();
        renderList();






    }

    public JSplitPane getView(){
        return jSplitPane;
    }

    public static void renderList(ArrayList<CountryModel> countries){
        text=new JTextArea("No Items Selected : select items to display details");
        Font font;
        font = new Font("Verdana", Font.PLAIN, 13);
        text.setFont(font);
        text.setBackground(Color.blue);
        text.setForeground(Color.WHITE);
        text.setEditable(false);
        listModel=new DefaultListModel<>();

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
        jSplitPane.setRightComponent(text);

    }



    public static void renderList(){
        renderList(ResourceHouse.controller.getList());
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

        }else if(selectedVal.equals("Population")){
            if(c.getPopulation()<0){
                return false;
            }
            return true;

        }else if(selectedVal.equals("Forest Coverage")){
            if(c.getForestCoverage()<0){
                return false;
            }
            return true;

        }else if(selectedVal.equals("Agriculture Coverage")){
            if(c.getAgricultureCoverage()<0){
                return false;
            }
            return true;

        }else{
            return true;
        }
    }
}
