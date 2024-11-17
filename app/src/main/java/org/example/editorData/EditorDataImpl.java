package org.example.editorData;

import org.example.editorData.cursor.Cursor;
import org.example.editorData.cursor.CursorEvent;
import org.example.editorData.cursor.CursorManager;
import org.example.editorData.cursor.CursorManagerImpl;
import org.example.editorData.text.EditorTextBuffer;
import org.example.editorData.text.EditorTextBufferImpl;

import java.awt.event.KeyEvent;
import java.util.List;

public class EditorDataImpl implements EditorData {
    private final EditorTextBuffer textBuffer;
    private final CursorManager cursorManager;

    public EditorDataImpl() {
        textBuffer = new EditorTextBufferImpl();
        cursorManager = new CursorManagerImpl();
    }

    @Override
    public void handleKeyEvent(int event) {
        switch (event) {
            case KeyEvent.VK_UP:
                cursorManager.handleKeyEvent(textBuffer, CursorEvent.UP);
                break;
            case KeyEvent.VK_DOWN:
                cursorManager.handleKeyEvent(textBuffer, CursorEvent.DOWN);
                break;
            case KeyEvent.VK_LEFT:
                cursorManager.handleKeyEvent(textBuffer, CursorEvent.LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                cursorManager.handleKeyEvent(textBuffer, CursorEvent.RIGHT);
                break;
            default:
                break;
        }
    }

    @Override
    public void typeCharacter(char c) {
        textBuffer.typeCharacter(cursorManager, c);
    }

    @Override
    public List<String> getLines() {
        return textBuffer.getLines();
    }

    @Override
    public Cursor getCursor() {
        return cursorManager.getCursor();
    }

}
