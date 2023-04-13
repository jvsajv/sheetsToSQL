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

    public Table(SheetData sheetData) {
        super("Sheet Table");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        DefaultTableModel model = new DefaultTableModel(sheetData.getHeaders().toArray(),0);
        for (List<String> row : sheetData.getData()) {
            model.addRow(row.toArray());
        }
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

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            // TODO ask table name
        }
    }
}
