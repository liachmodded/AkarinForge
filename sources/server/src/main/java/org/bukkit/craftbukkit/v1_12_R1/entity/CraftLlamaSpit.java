package org.bukkit.craftbukkit.v1_12_R1.entity;

import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.entity.projectile.EntityLlamaSpit;

import org.bukkit.craftbukkit.v1_12_R1.CraftServer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LlamaSpit;
import org.bukkit.projectiles.ProjectileSource;

public class CraftLlamaSpit extends AbstractProjectile implements LlamaSpit {

    public CraftLlamaSpit(CraftServer server, EntityLlamaSpit entity) {
        super(server, entity);
    }

    @Override
    public EntityLlamaSpit getHandle() {
        return (EntityLlamaSpit) super.getHandle();
    }

    @Override
    public String toString() {
        return "CraftLlamaSpit";
    }

    @Override
    public EntityType getType() {
        return EntityType.LLAMA_SPIT;
    }

    @Override
    public ProjectileSource getShooter() {
        return (getHandle().owner != null) ? (ProjectileSource) getHandle().owner.getBukkitEntity() : null;
    }

    @Override
    public void setShooter(ProjectileSource source) {
        getHandle().owner = (source != null) ? (EntityLlama) ((CraftLivingEntity) source).getHandle() : null;
    }
}