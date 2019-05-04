/*
 * Akarin Forge
 */
package org.bukkit.craftbukkit.v1_12_R1.command;

import java.util.Set;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ProxiedCommandSender;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;

public class ProxiedNativeCommandSender
implements ProxiedCommandSender {
    private final bn orig;
    private final CommandSender caller;
    private final CommandSender callee;

    public ProxiedNativeCommandSender(bn orig, CommandSender caller, CommandSender callee) {
        this.orig = orig;
        this.caller = caller;
        this.callee = callee;
    }

    public bn getHandle() {
        return this.orig;
    }

    @Override
    public CommandSender getCaller() {
        return this.caller;
    }

    @Override
    public CommandSender getCallee() {
        return this.callee;
    }

    @Override
    public void sendMessage(String message) {
        this.getCaller().sendMessage(message);
    }

    @Override
    public void sendMessage(String[] messages) {
        this.getCaller().sendMessage(messages);
    }

    @Override
    public Server getServer() {
        return this.getCallee().getServer();
    }

    @Override
    public String getName() {
        return this.getCallee().getName();
    }

    @Override
    public boolean isPermissionSet(String name) {
        return this.getCaller().isPermissionSet(name);
    }

    @Override
    public boolean isPermissionSet(Permission perm) {
        return this.getCaller().isPermissionSet(perm);
    }

    @Override
    public boolean hasPermission(String name) {
        return this.getCaller().hasPermission(name);
    }

    @Override
    public boolean hasPermission(Permission perm) {
        return this.getCaller().hasPermission(perm);
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value) {
        return this.getCaller().addAttachment(plugin, name, value);
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin) {
        return this.getCaller().addAttachment(plugin);
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value, int ticks) {
        return this.getCaller().addAttachment(plugin, name, value, ticks);
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, int ticks) {
        return this.getCaller().addAttachment(plugin, ticks);
    }

    @Override
    public void removeAttachment(PermissionAttachment attachment) {
        this.getCaller().removeAttachment(attachment);
    }

    @Override
    public void recalculatePermissions() {
        this.getCaller().recalculatePermissions();
    }

    @Override
    public Set<PermissionAttachmentInfo> getEffectivePermissions() {
        return this.getCaller().getEffectivePermissions();
    }

    @Override
    public boolean isOp() {
        return this.getCaller().isOp();
    }

    @Override
    public void setOp(boolean value) {
        this.getCaller().setOp(value);
    }

    @Override
    public CommandSender.Spigot org_bukkit_command_CommandSender$Spigot_spigot() {
        return this.getCaller().org_bukkit_command_CommandSender$Spigot_spigot();
    }
}

