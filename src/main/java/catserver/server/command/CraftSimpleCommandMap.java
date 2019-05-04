/*
 * Decompiled with CFR 0_119.
 */
package catserver.server.command;

import catserver.server.command.ModCustomCommand;
import java.util.Arrays;
import java.util.regex.Pattern;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;

public class CraftSimpleCommandMap
extends SimpleCommandMap {
    private static final Pattern PATTERN_ON_SPACE = Pattern.compile(" ", 16);
    private bn vanillaConsoleSender;

    public CraftSimpleCommandMap(Server server) {
        super(server);
    }

    @Override
    public boolean dispatch(CommandSender sender, String commandLine) throws CommandException {
        String[] args = PATTERN_ON_SPACE.split(commandLine);
        if (args.length == 0) {
            return false;
        }
        String sentCommandLabel = args[0].toLowerCase();
        Command target = this.getCommand(sentCommandLabel);
        if (target == null) {
            return false;
        }
        try {
            if (target instanceof ModCustomCommand) {
                if (!target.testPermission(sender)) {
                    return true;
                }
                if (sender instanceof ConsoleCommandSender) {
                    FMLCommonHandler.instance().getMinecraftServerInstance().N().a(this.vanillaConsoleSender, commandLine);
                } else {
                    FMLCommonHandler.instance().getMinecraftServerInstance().N().a(((CraftPlayer)sender).getHandle(), commandLine);
                }
            } else {
                target.execute(sender, sentCommandLabel, Arrays.copyOfRange(args, 1, args.length));
            }
        }
        catch (CommandException ex2) {
            throw ex2;
        }
        catch (Throwable ex3) {
            throw new CommandException("Unhandled exception executing '" + commandLine + "' in " + target, ex3);
        }
        return true;
    }

    public void setVanillaConsoleSender(bn console) {
        this.vanillaConsoleSender = console;
    }
}

