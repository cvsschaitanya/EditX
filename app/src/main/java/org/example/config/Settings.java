package org.example.config;

import org.example.graphics.cursorGraphics.UnderLineCursorGraphix;
import org.example.graphics.cursorGraphics.VerticalLineCursorGraphix;
import org.example.settings.EditorSettings;
import org.example.settings.EditorSettingsImpl;
import org.example.settings.Fonts;
import org.example.settings.theme.Themes;

public class Settings {
    public static final EditorSettings DEFAULT_EDITOR_SETTINGS = new EditorSettingsImpl(
            Themes.DARK,
            20,
            10,
            10,
            Fonts.MONOX,
            1.2,
//            UnderLineCursorGraphix.class
            VerticalLineCursorGraphix.class
    );
}
