package org.example.graphics.cursorGraphics;

import org.example.editorData.cursor.Cursor;
import org.example.graphics.Graphix;
import org.example.settings.EditorSettings;

public abstract class CursorGraphix implements Graphix {
    protected final Cursor cursor;
    protected final EditorSettings settings;

    public CursorGraphix(Cursor cursor, EditorSettings settings) {
        this.cursor = cursor;
        this.settings = settings;
    }
}
