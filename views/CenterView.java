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

public class CenterView {

    private DefaultListModel<String> listModel;
    private JList list;
    private JScrollPane scrollPane;
    private JSplitPane jSplitPane;
    private JTextArea text;
    public CenterView() {
        jSplitPane=new JSplitPane();
        listModel=new DefaultListModel<>();
        text=new JTextArea("Lorem ipsum dolor sit amet, consectetur adipis\n" +
                "cing elit, sed do eiusmod tempor incididunt ut labore et do\n" +
                "lore magna aliqua. Ut enim ad minim veniam, quis nostrud exerci\n" +
                "tation ullamco laboris nisi ut aliquip ex ea commodo consequat. \n" +
                "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum\n" +
                " dolore eu fugiat nulla pariatur. Excepteur sint \n" +
                "occaecat cupidatat non proident, sunt\n" +
                " in culpa qui officia deserunt mollit anim id est laborum.\n");
        text.setEditable(false);
        ArrayList<CountryModel> countries= ResourceHouse.controller.getList();
        listModel.addElement("abc");
        listModel.addElement("def");
        listModel.addElement("ghi");
        listModel.addElement("jkl");
        listModel.addElement("mno");
        listModel.addElement("pqr");
        listModel.addElement("stu");
        listModel.addElement("vwx");
        listModel.addElement("yza");
        listModel.addElement("bcd");
        listModel.addElement("efg");
        listModel.addElement("hij");
        listModel.addElement("klm");
        listModel.addElement("nop");

//        for(CountryModel c:countries){
//            listModel.addElement(c.getName());
//        }
        list=new JList(listModel);
        list.setFixedCellHeight(30);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addListSelectionListener(e -> {
//            for (CountryModel c:countries
//                 ) {
//                if(c.getName().toLowerCase().trim().equals(list.getSelectedValue().toString().toLowerCase().trim())){
//                    beautifyAndInsert(c);
//                    break;
//                }
//            }

        });
        scrollPane = new JScrollPane(list);


        jSplitPane.setLeftComponent(scrollPane);
        jSplitPane.setRightComponent(text);
        jSplitPane.setDividerLocation(150);

    }

    public JSplitPane getView(){
        return jSplitPane;
    }

    public void beautifyAndInsert(CountryModel c){
        text.setText(c.toString());
    }
}
