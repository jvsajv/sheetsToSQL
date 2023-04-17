package org.sheetstosql.app.GUI;

import org.sheetstosql.models.SheetData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Table extends JFrame implements ActionListener {
    private final JButton button;
    private SheetData sheetData;
    public Table(SheetData sheetData) {
        super("Sheet Table");
        this.sheetData = sheetData;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        DefaultTableModel model;
        model = loadSheetDataIntoTable(sheetData);

        JTable table = new JTable(model);

        button = new JButton("Next Step");

        button.addActionListener(this);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        panel.add(button, BorderLayout.SOUTH);

        getContentPane().removeAll();
        getContentPane().add(panel);
        revalidate();

        setVisible(true);
    }

    public DefaultTableModel loadSheetDataIntoTable(SheetData sheetData){
        return loadDataIntoTable(sheetData, loadHeadersIntoTable(sheetData));
    }

    public DefaultTableModel loadHeadersIntoTable(SheetData sheetData){
        return new DefaultTableModel(sheetData.getHeaders().toArray(),0);
    }
    public DefaultTableModel loadDataIntoTable(SheetData sheetData, DefaultTableModel model) {

        for (List<String> row : sheetData.getData()) {
            model.addRow(row.toArray());
        }

        return model;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            setVisible(false);
            new UserPreferences(sheetData);
        }
    }
}
