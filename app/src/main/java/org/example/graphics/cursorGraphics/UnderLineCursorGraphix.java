package org.example.graphics.cursorGraphics;

import org.example.editorData.cursor.Cursor;
import org.example.settings.EditorSettings;

import java.awt.*;

public class UnderLineCursorGraphix extends CursorGraphix {

    public static final int THICKNESS = 3;

    public UnderLineCursorGraphix(Cursor cursor, EditorSettings settings) {
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
                settings.getLeftMargin() + cursor.col * charWidth,
                (cursor.row + 1) * Y - THICKNESS,
                charWidth,
                THICKNESS
        );
    }
}
