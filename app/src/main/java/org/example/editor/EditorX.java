package org.example.editor;

import org.example.config.Settings;
import org.example.settings.EditorSettings;
import org.example.editorData.EditorData;
import org.example.editorData.EditorDataImpl;

import javax.swing.*;

public class EditorX {
    private final JFrame frame;
    private final EditorTextPanel textPanel;

    public EditorX() {
        frame = new JFrame("Custom Text Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        EditorData editorData = new EditorDataImpl();
        EditorSettings settings = Settings.DEFAULT_EDITOR_SETTINGS;
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