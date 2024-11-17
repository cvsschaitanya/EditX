package org.example.editor;

import org.example.editorData.EditorData;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInputHandler implements KeyListener {

    private final Component component;
    private final EditorData editorData;

    public KeyInputHandler(Component component, EditorData editorData) {
        this.component = component;
        this.editorData = editorData;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();

        editorData.typeCharacter(c);
        component.repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        editorData.handleKeyEvent(keyCode);
        component.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}
