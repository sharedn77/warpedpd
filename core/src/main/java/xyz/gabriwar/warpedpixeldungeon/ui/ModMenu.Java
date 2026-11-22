package com.shatteredpixel.shatteredpixeldungeon.ui;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.items.Gold;
import com.shatteredpixel.shatteredpixeldungeon.items.Item;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfHealing;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfStrength;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.ScrollOfUpgrade;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.ScrollOfIdentify;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.Bomb;
import com.shatteredpixel.shatteredpixeldungeon.items.Ankh;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;

public class ModMenu extends Window {

    private static int jumlah = 1;
    private static int itemDipilih = 0;

    private static String[] namaItem = {
        "Gold",
        "Potion Heal",
        "Potion Strength",
        "Scroll Upgrade",
        "Scroll Identify",
        "Bomb",
        "Ankh"
    };

    public ModMenu() {
        super();
        resize(140, 170);

        // Tombol ini sekaligus jadi tampilan jumlah, biar gak error di Warped
        RedButton txtJumlah = new RedButton("JUMLAH: " + jumlah) {
            @Override
            protected void onClick() {
                // Kalo dipencet, reset jadi 1
                jumlah = 1;
                refresh();
            }
        };
        txtJumlah.setRect(30, 0, 80, 20);
        add(txtJumlah);

        RedButton btnMinus = new RedButton("-") {
            @Override
            protected void onClick() {
                if (jumlah > 1) jumlah--;
                refresh();
            }
        };
        btnMinus.setRect(5, 0, 20, 20);
        add(btnMinus);

        RedButton btnPlus = new RedButton("+") {
            @Override
            protected void onClick() {
                jumlah++;
                if (jumlah > 999) jumlah = 999;
                refresh();
            }
        };
        btnPlus.setRect(115, 0, 20, 20);
        add(btnPlus);

        RedButton btnPlus10 = new RedButton("+10") {
            @Override
            protected void onClick() {
                jumlah += 10;
                if (jumlah > 999) jumlah = 999;
                refresh();
            }
        };
        btnPlus10.setRect(15, 25, 55, 20);
        add(btnPlus10);

        RedButton btnPlus100 = new RedButton("+100") {
            @Override
            protected void onClick() {
                jumlah += 100;
                if (jumlah > 999) jumlah = 999;
                refresh();
            }
        };
        btnPlus100.setRect(75, 25, 55, 20);
        add(btnPlus100);

        // Tampilan Item, pake tombol juga
        RedButton txtItem = new RedButton("ITEM: " + namaItem[itemDipilih]) {
            @Override
            protected void onClick() {}
        };
        txtItem.setRect(30, 55, 80, 20);
        add(txtItem);

        RedButton btnPrev = new RedButton("<") {
            @Override
            protected void onClick() {
                itemDipilih--;
                if (itemDipilih < 0) itemDipilih = namaItem.length - 1;
                refresh();
            }
        };
        btnPrev.setRect(5, 55, 20, 20);
        add(btnPrev);

        RedButton btnNext = new RedButton(">") {
            @Override
            protected void onClick() {
                itemDipilih++;
                if (itemDipilih >= namaItem.length) itemDipilih = 0;
                refresh();
            }
        };
        btnNext.setRect(115, 55, 20, 20);
        add(btnNext);

        // Tombol Kasih
        RedButton btnGive = new RedButton("KASIH ITEM!") {
            @Override
            protected void onClick() {
                kasihItem();
                hide();
            }
        };
        btnGive.setRect(5, 85, 130, 25);
        add(btnGive);

        // Tombol Tutup
        RedButton btnClose = new RedButton("TUTUP") {
            @Override
            protected void onClick() {
                hide();
            }
        };
        btnClose.setRect(5, 115, 130, 20);
        add(btnClose);
    }

    private void refresh() {
        hide();
        GameScene.show(new ModMenu());
    }

    private void kasihItem() {
        if (itemDipilih == 0) {
            new Gold(jumlah).collect();
            return;
        }
        for (int i = 0; i < jumlah; i++) {
            Item item = null;
            if (itemDipilih == 1) item = new PotionOfHealing();
            else if (itemDipilih == 2) item = new PotionOfStrength();
            else if (itemDipilih == 3) item = new ScrollOfUpgrade();
            else if (itemDipilih == 4) item = new ScrollOfIdentify();
            else if (itemDipilih == 5) item = new Bomb();
            else if (itemDipilih == 6) item = new Ankh();

            if (item != null) {
                // Cara Warped / Shattered lama, lebih aman
                item.collect();
            }
        }
    }

    public static void show() {
        GameScene.show(new ModMenu());
    }
}