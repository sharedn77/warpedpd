package xyz.gabriwar.warpedpixeldungeon.ui;

import xyz.gabriwar.warpedpixeldungeon.scenes.GameScene;
import xyz.gabriwar.warpedpixeldungeon.windows.WndOptions;

public class ModMenu {

    public static void show() {
        GameScene.show(new WndOptions(
            "Warped Mod Menu",
            "Pilih fitur:",
            "Test Fitur",
            "Tutup"
        ) {
            @Override
            protected void onSelect(int index) {
                if (index == 0) {
                    GameScene.show(new WndOptions("Info", "Mod jalan!", "OK", null));
                }
            }
        });
    }
}