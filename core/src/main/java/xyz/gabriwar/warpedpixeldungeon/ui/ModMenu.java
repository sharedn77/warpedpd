package xyz.gabriwar.warpedpixeldungeon.ui;

import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.windows.WndOptions;
import com.watabou.noosa.Game;

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