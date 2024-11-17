package org.example.settings;


import org.example.settings.theme.EditorTheme;

import java.awt.*;

public class EditorSettingsImpl implements EditorSettings{
    private final EditorTheme theme;
    private final int leftMargin;
    private final Font editorFont;
    private final double lineSpacing;

    public EditorSettingsImpl(EditorTheme theme, int lineHeight, int charWidth, int leftMargin, Font editorFont, double lineSpacing) {
        this.theme = theme;
        this.leftMargin = leftMargin;
        this.editorFont = editorFont;
        this.lineSpacing = lineSpacing;
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
}
