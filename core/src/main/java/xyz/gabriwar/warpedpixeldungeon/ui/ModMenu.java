package xyz.gabriwar.warpedpixeldungeon.ui;

import xyz.gabriwar.warpedpixeldungeon.Dungeon;
import xyz.gabriwar.warpedpixeldungeon.scenes.GameScene;
import xyz.gabriwar.warpedpixeldungeon.windows.WndOptions;
import xyz.gabriwar.warpedpixeldungeon.items.Item;
import xyz.gabriwar.warpedpixeldungeon.items.EnergyCrystal;
import xyz.gabriwar.warpedpixeldungeon.items.potions.PotionOfStrength;
import xyz.gabriwar.warpedpixeldungeon.items.potions.PotionOfExperience;
import xyz.gabriwar.warpedpixeldungeon.items.scrolls.ScrollOfUpgrade;
import xyz.gabriwar.warpedpixeldungeon.items.scrolls.ScrollOfTransmutation;

public class ModMenu {

    public static void show() {
        GameScene.show(new WndOptions(
            "Warped Mod Menu",
            "Mau dikasih item apa?",
            "Scroll Multi Upgrade x5",
            "Potion of Strength x3",
            "Potion of Experience x3",
            "Alchemy Power x5",
            "Scroll Transmutasi x3",
            "Tutup"
        ) {
            @Override
            protected void onSelect(int index) {
                if (index == 0) {
                    for (int i = 0; i < 5; i++) giveItem(new ScrollOfUpgrade());
                } else if (index == 1) {
                    for (int i = 0; i < 3; i++) giveItem(new PotionOfStrength());
                } else if (index == 2) {
                    for (int i = 0; i < 3; i++) giveItem(new PotionOfExperience());
                } else if (index == 3) {
                    for (int i = 0; i < 5; i++) giveItem(new EnergyCrystal());
                } else if (index == 4) {
                    for (int i = 0; i < 3; i++) giveItem(new ScrollOfTransmutation());
                }
                if (index >= 0 && index <= 4) {
                    GameScene.show(new WndOptions("Berhasil!", "Item udah masuk tas!", "OK", null));
                }
            }
        });
    }

    private static void giveItem(Item item) {
        if (!item.collect()) {
            Dungeon.level.drop(item, Dungeon.hero.pos);
        }
    }
}