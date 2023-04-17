package org.sheetstosql.app.GUI;

import org.sheetstosql.Utils.SheetProcessor;
import org.sheetstosql.models.SheetData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FileSelection extends JFrame implements ActionListener {
    private final JButton button;
    private final SheetProcessor sheetProcessor = new SheetProcessor();

    public FileSelection(){
        setTitle("Sheets to SQL Insert");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        button = new JButton("Select file");

        button.addActionListener(this);
        button.setMargin(new Insets(8, 8, 8, 8));

        JPanel panel = new JPanel(new GridBagLayout());
        panel.add(button);
        panel.setPreferredSize(new Dimension(400, 300));

        add(panel, BorderLayout.CENTER);

        pack();

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                try {
                    SheetData sheetData = sheetProcessor.processSheetIntoData(selectedFile);
                    setVisible(false);
                    new Table(sheetData);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }
}
