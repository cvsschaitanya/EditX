package org.example.editor;

import org.example.settings.EditorSettings;
import org.example.settings.EditorSettingsImpl;
import org.example.settings.Fonts;
import org.example.editorData.EditorData;
import org.example.editorData.EditorDataImpl;
import org.example.settings.theme.Themes;

import javax.swing.*;

public class EditorX {
    private final JFrame frame;
    private final EditorTextPanel textPanel;

    public EditorX() {
        frame = new JFrame("Custom Text Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        EditorData editorData = new EditorDataImpl();
        EditorSettings settings = new EditorSettingsImpl(
                Themes.DARK,
                20,
                10,
                10,
                Fonts.MONOX,
                1.2
        );
        textPanel = new EditorTextPanel(editorData, settings);
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