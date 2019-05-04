/*
 * Decompiled with CFR 0_119.
 */
package catserver.server.command;

import catserver.server.CatServer;
import java.io.IOException;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class PermissionCommand
extends Command {
    public PermissionCommand(String name) {
        super(name);
        this.description = "Reload fake player permission file";
        this.usageMessage = "/fakefile reload";
        this.setPermission("catserver.command.fakefile");
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (!this.testPermission(sender)) {
            return true;
        }
        if (args.length != 1) {
            return false;
        }
        if (!args[0].equals("reload")) {
            return false;
        }
        try {
            CatServer.reloadFakePlayerPermissions();
            sender.sendMessage("SUCCESS");
            return true;
        }
        catch (IOException e2) {
            e2.printStackTrace();
            sender.sendMessage("FAIL");
            return true;
        }
    }
}

