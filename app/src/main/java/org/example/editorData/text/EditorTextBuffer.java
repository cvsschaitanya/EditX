package org.example.editorData.text;

import org.example.editorData.cursor.CursorManager;

import java.util.List;

public interface EditorTextBuffer {

    List<String> getLines();

    void typeCharacter(CursorManager cursorManager, char c);
}
