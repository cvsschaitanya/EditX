package org.example.editorData;

import org.example.editorData.cursor.Cursor;

import java.util.List;

public interface EditorData {
    void handleKeyEvent(int event);

    void typeCharacter(char c);

    List<String> getLines();

    Cursor getCursor();
}
