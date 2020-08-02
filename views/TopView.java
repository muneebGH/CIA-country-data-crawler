package mine.views;

import javax.swing.*;

public class TopView {
    JLabel arrangeText;
    JComboBox<String> options;
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
        options.addItem("Death rate");
        options.addItem("Birth Rate");
        options.addItem("Median Age");
        options.addItem("Electricity consumption");
        options.addItem("Elevation");



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
}
