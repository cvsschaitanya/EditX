package org.example.graphics.cursorGraphics;

import org.example.editorData.cursor.Cursor;
import org.example.settings.EditorSettings;

import java.lang.reflect.InvocationTargetException;

public class CursorGraphixFactory {
    public static CursorGraphix create(Cursor cursor, EditorSettings settings) {
        try {
            return settings.getCursorGraphixType()
                    .getDeclaredConstructor(Cursor.class, EditorSettings.class)
                    .newInstance(cursor, settings);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
