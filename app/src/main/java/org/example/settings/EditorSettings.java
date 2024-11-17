package org.example.settings;

import org.example.graphics.cursorGraphics.CursorGraphix;
import org.example.settings.theme.EditorTheme;

import java.awt.*;

public interface EditorSettings {
    EditorTheme getEditorTheme();
    int getLeftMargin();
    Font getEditorFont();
    double getLineSpacing();
    Class<? extends CursorGraphix> getCursorGraphixType();
}
