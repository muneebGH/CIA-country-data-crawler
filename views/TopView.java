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
        options.addItem("Birth Expectancy");
        options.addItem("Median Age");
        options.addItem("Electricity consumption");
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
            if(options.getSelectedItem().toString().toLowerCase().trim().equals("death rate")){
                ResourceHouse.controller.sortByDeathRate();


            }else if(options.getSelectedItem().toString().toLowerCase().trim().equals("electricity consumption")){


                ResourceHouse.controller.sortByElectricityConsumption();

            }else if(options.getSelectedItem().toString().toLowerCase().trim().equals("median age")){

                ResourceHouse.controller.sortByMedianAge();

            }else if(options.getSelectedItem().toString().toLowerCase().trim().equals("birth expectancy")){

                ResourceHouse.controller.sortByBirthExpectancy();

            }
            else{
                ResourceHouse.controller.sortByDefault();
            }
        });
    }
}
