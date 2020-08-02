package mine.views;

import mine.Controller.ResourceHouse;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopView {
    JLabel arrangeText;
    public static JComboBox<String> options;
    JButton button;
    JLabel filterText;
    JTextField flagFilter;
    JPanel panel;


    public TopView() {
        arrangeText =new JLabel("Arrange By");
        filterText=new JLabel("Filter Flag Symbol");
        flagFilter=new JTextField("Enter Symbol");
        button=new JButton("Filter");
        options=new JComboBox();
        options.addItem("Default");
        options.addItem("Death Rate");
        options.addItem("Population");
        options.addItem("Birth Expectancy");
        options.addItem("Median Age");
        options.addItem("Electricity consumption");
        options.addItem("Forest Coverage");
        options.addItem("Agriculture Coverage");
        applyComboBoxListner();



        //add in panel
        panel=new JPanel();

        panel.add(arrangeText);
        panel.add(options);

        panel.add(filterText);
        panel.add(flagFilter);
        panel.add(button);

    }


    public JComponent getView(){

        return panel;
    }

    private void applyComboBoxListner(){
        options.addActionListener(e -> {
            String selectedItem=options.getSelectedItem().toString().trim();
            if(selectedItem.equals("Death Rate")){
                ResourceHouse.controller.sortByDeathRate();

            }else if(selectedItem.equals("Electricity consumption")){


                ResourceHouse.controller.sortByElectricityConsumption();

            }else if(selectedItem.equals("Median Age")){

                ResourceHouse.controller.sortByMedianAge();

            }else if(selectedItem.equals("Birth Expectancy")){

                ResourceHouse.controller.sortByBirthExpectancy();

            }
            else if(selectedItem.equals("Population")){

                ResourceHouse.controller.sortByPopulation();

            }else if(selectedItem.equals("Forest Coverage")){

                ResourceHouse.controller.sortByForestCoverage();

            }else if(selectedItem.equals("Agriculture Coverage")){

                ResourceHouse.controller.sortByAgricultureCoverage();

            }
            else{
                ResourceHouse.controller.sortByDefault();
            }
        });
    }
}
