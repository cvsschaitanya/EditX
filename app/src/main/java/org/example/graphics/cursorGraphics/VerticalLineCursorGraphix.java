package org.example.graphics.cursorGraphics;

import org.example.editorData.cursor.Cursor;
import org.example.settings.EditorSettings;

import java.awt.*;

public class VerticalLineCursorGraphix extends CursorGraphix{

    public static final int THICKNESS = 2;

    public VerticalLineCursorGraphix(Cursor cursor, EditorSettings settings) {
        super(cursor, settings);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(settings.getEditorTheme().getCursorColor());

        int charWidth = g.getFontMetrics().charWidth('m');
        final int Y = (int) (settings.getLineSpacing() * g.getFontMetrics().getHeight());
        final int y = g.getFontMetrics().getHeight();
        int baseLine = (Y + y) / 2;
        int topLine = (Y - y) / 2;

        g.fillRect(
                settings.getLeftMargin() + (cursor.col) * charWidth - 1,
                (cursor.row) * Y + topLine,
                THICKNESS,
                y
        );

    }
}
