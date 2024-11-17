package org.example.settings;


import org.example.graphics.cursorGraphics.CursorGraphix;
import org.example.settings.theme.EditorTheme;

import java.awt.*;

public class EditorSettingsImpl implements EditorSettings{
    private final EditorTheme theme;
    private final int leftMargin;
    private final Font editorFont;
    private final double lineSpacing;
    private final Class<? extends CursorGraphix> cursorGraphixType;

    public EditorSettingsImpl(EditorTheme theme, int lineHeight, int charWidth, int leftMargin, Font editorFont, double lineSpacing, Class<? extends CursorGraphix> cursorGraphixType) {
        this.theme = theme;
        this.leftMargin = leftMargin;
        this.editorFont = editorFont;
        this.lineSpacing = lineSpacing;
        this.cursorGraphixType = cursorGraphixType;
    }

    @Override
    public EditorTheme getEditorTheme() {
        return theme;
    }

    @Override
    public int getLeftMargin() {
        return leftMargin;
    }

    @Override
    public Font getEditorFont() {
        return editorFont;
    }

    @Override
    public double getLineSpacing() {
        return lineSpacing;
    }

    @Override
    public Class<? extends CursorGraphix> getCursorGraphixType() {
        return cursorGraphixType;
    }
}
