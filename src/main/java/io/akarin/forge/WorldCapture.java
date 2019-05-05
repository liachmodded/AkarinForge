/*
 * Decompiled with CFR 0_119.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 */
package io.akarin.forge;

import com.google.common.collect.Lists;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.world.WorldServer;

import java.util.List;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class WorldCapture {
    private WorldServer world;
    private boolean capture;
    private EntityPlayerMP curPlayer;
    private ItemStack curItemStack;
    private EnumHand curHand;
    private List<EntitySnap> entitySnap = Lists.newArrayList();
    private List<ItemSnap> itemSnap = Lists.newArrayList();

    public WorldCapture(WorldServer world) {
        this.world = world;
    }

    public void startCapture(EntityPlayerMP player, ItemStack stack, EnumHand hand) {
        this.curPlayer = player;
        this.curItemStack = stack;
        this.curHand = hand;
        this.entitySnap.clear();
        this.itemSnap.clear();
        this.capture = true;
    }

    public void stopCapture() {
        this.capture = false;
    }

    public boolean isCapture() {
        return this.capture;
    }

    public void apply() {
        for (EntitySnap snap : this.entitySnap) {
            snap.apply();
        }
        for (ItemSnap snap : this.itemSnap) {
            snap.apply();
        }
    }

    public void restore() {
        this.curPlayer.a(this.curHand, this.curItemStack);
    }

    public void addEntitySnap(vg entity, CreatureSpawnEvent.SpawnReason reason) {
        if (this.world.restoringBlockSnapshots) {
            return;
        }
        this.entitySnap.add(new EntitySnap(entity, reason));
    }

    public void addItemSnap(aed player, aip stack) {
        if (this.world.restoringBlockSnapshots) {
            return;
        }
        this.itemSnap.add(new ItemSnap(player, stack));
    }

    class ItemSnap {
        private final EntityPlayerMP player;
        private final ItemStack stack;
        private boolean isApply;

        public ItemSnap(EntityPlayerMP player, ItemStack stack) {
            this.player = player;
            this.stack = stack;
        }

        public void apply() {
            if (!this.isApply) {
                if (this.player.bv.e(this.stack)) {
                    this.player.l.a(new acl(this.player.l, this.player.p, this.player.q, this.player.r, this.stack));
                }
                this.isApply = true;
            }
        }
    }

    class EntitySnap {
        private final Entity entity;
        private final CreatureSpawnEvent.SpawnReason reason;
        private boolean isApply;

        public EntitySnap(Entity entity, CreatureSpawnEvent.SpawnReason reason) {
            this.entity = entity;
            this.reason = reason;
        }

        public void apply() {
            if (!this.isApply) {
                WorldCapture.this.world.addEntity(this.entity, this.reason);
                this.isApply = true;
            }
        }
    }

}

