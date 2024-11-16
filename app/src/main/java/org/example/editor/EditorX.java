package org.example.editor;

import org.example.settings.EditorSettings;
import org.example.settings.EditorSettingsImpl;
import org.example.settings.Fonts;
import org.example.text.EditorTextData;
import org.example.text.EditorTextDataImpl;
import org.example.settings.theme.Themes;

import javax.swing.*;

public class EditorX {
    private JFrame frame;
    private EditorTextPanel textPanel;

    public EditorX() {
        frame = new JFrame("Custom Text Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        EditorTextData textData = new EditorTextDataImpl();
        EditorSettings settings = new EditorSettingsImpl(
                Themes.LIGHT,
                20,
                10,
                10,
                Fonts.MONOX
        );
        textPanel = new EditorTextPanel(textData, settings);
        frame.add(textPanel);
    }

    public void start() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EditorX customTextEditor = new EditorX();
        customTextEditor.start();
    }
}