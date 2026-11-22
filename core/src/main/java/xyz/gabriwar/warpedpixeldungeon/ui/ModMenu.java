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
                    giveItem(new ScrollOfUpgrade().quantity(5));
                } else if (index == 1) {
                    giveItem(new PotionOfStrength().quantity(3));
                } else if (index == 2) {
                    giveItem(new PotionOfExperience().quantity(3));
                } else if (index == 3) {
                    giveItem(new EnergyCrystal().quantity(5));
                } else if (index == 4) {
                    giveItem(new ScrollOfTransmutation().quantity(3));
                }
            }
        });
    }

    private static void giveItem(Item item) {
        try {
            if (!Dungeon.hero.belongings.backpack.collect(item)) {
                Dungeon.level.drop(item, Dungeon.hero.pos);
            }
            Item.updateQuickslot();
        } catch (Exception e) {
            // biar gak force close kalau gagal
        }
    }
}