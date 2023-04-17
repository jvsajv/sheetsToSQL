package org.sheetstosql.app.GUI;

import org.sheetstosql.Utils.InsertStringBuilder;
import org.sheetstosql.models.SheetData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserPreferences extends JFrame implements ActionListener {

    private final JTextField tableNameTextField;
    private final JRadioButton singleLineRadioButton;

    private SheetData sheetData;

    private InsertStringBuilder insertStringBuilder = new InsertStringBuilder();

    public UserPreferences(SheetData sheetData){

        this.sheetData = sheetData;

        // Configurações do JFrame
        setTitle("Conversão de Inserts");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 200));
        setLayout(new GridLayout(4, 1));

        // Criação dos componentes
        JLabel tableNameLabel = new JLabel("Database Table Name:");
        tableNameTextField = new JTextField();
        singleLineRadioButton = new JRadioButton("Linha Única");
        JRadioButton multiLineRadioButton = new JRadioButton("Linhas Múltiplas");
        ButtonGroup lineGroup = new ButtonGroup();
        lineGroup.add(singleLineRadioButton);
        lineGroup.add(multiLineRadioButton);
        JButton convertButton = new JButton("Converter");

        add(tableNameLabel);
        add(tableNameTextField);
        add(singleLineRadioButton);
        add(multiLineRadioButton);
        add(convertButton);

        convertButton.addActionListener(this);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String tableName = tableNameTextField.getText();
        boolean singleLine = singleLineRadioButton.isSelected();

        // Chama o método de conversão e gera o relatório
        convert(tableName, singleLine);
    }

    private void convert(String tableName, boolean singleLine) {
        if(singleLine){
            System.out.println(insertStringBuilder.singleLineInsert(tableName, sheetData));
        } else {
            System.out.println(insertStringBuilder.multipleLinesInsert(tableName, sheetData));
        }
    }
}
