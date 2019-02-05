package me.realized.tokenmanager.util.inventory;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;

public final class InventoryUtil {

    private InventoryUtil() {}

    public static Inventory deepCopyOf(final Inventory other) {
        final Inventory result = Bukkit.createInventory(null, other.getSize(), other.getTitle());

        for (int i = 0; i < other.getSize(); i++) {
            result.setItem(i, other.getItem(i).clone());
        }

        return result;
    }

    public static boolean isInventoryFull(final Player player) {
        return player.getInventory().firstEmpty() == -1;
    }

    public static Inventory getClickedInventory(final int rawSlot, final InventoryView view) {
        if (view.getTopInventory() != null && rawSlot < view.getTopInventory().getSize()) {
            return view.getTopInventory();
        } else {
            return view.getBottomInventory();
        }
    }
}
