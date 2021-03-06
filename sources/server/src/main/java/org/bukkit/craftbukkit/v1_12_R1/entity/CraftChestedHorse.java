package org.bukkit.craftbukkit.v1_12_R1.entity;

import net.minecraft.entity.passive.AbstractChestHorse;

import org.bukkit.craftbukkit.v1_12_R1.CraftServer;
import org.bukkit.entity.ChestedHorse;

public abstract class CraftChestedHorse extends CraftAbstractHorse implements ChestedHorse {

    public CraftChestedHorse(CraftServer server, AbstractChestHorse entity) {
        super(server, entity);
    }

    @Override
    public AbstractChestHorse getHandle() {
        return (AbstractChestHorse) super.getHandle();
    }

    @Override
    public boolean isCarryingChest() {
        return getHandle().hasChest();
    }

    @Override
    public void setCarryingChest(boolean chest) {
        if (chest == isCarryingChest()) return;
        getHandle().setChested(chest);
        getHandle().initHorseChest();
    }
}
