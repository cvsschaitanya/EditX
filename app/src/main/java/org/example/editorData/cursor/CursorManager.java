package org.example.editorData.cursor;

import org.example.editorData.text.EditorTextBuffer;

public interface CursorManager {

    Cursor getCursor();

    void setCursor(int row, int col);

    void handleKeyEvent(EditorTextBuffer editorTextBuffer, CursorEvent cursorEvent);
}
