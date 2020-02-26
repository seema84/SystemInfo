package me.thevipershow.systeminfo.commands;

import me.thevipershow.systeminfo.enums.Messages;
import me.thevipershow.systeminfo.interfaces.Command;
import me.thevipershow.systeminfo.oshi.SystemValues;
import me.thevipershow.systeminfo.utils.Utils;
import org.bukkit.command.CommandSender;

public class CommandVmstat implements Command {

    private SystemValues systemValues = SystemValues.getInstance();

    private void vmstat(CommandSender sender) {
        sender.sendMessage(Utils.color("&2«« &7Memory info &2»»"));
        sender.sendMessage(String.format(Utils.color("&7Available memory: &a%s"), systemValues.getAvailableMemory()));
        sender.sendMessage(String.format(Utils.color("&7Allocated memory: &a%s"), systemValues.getUsedMemory()));
        sender.sendMessage(String.format(Utils.color("&7Total memory: &a%s"), systemValues.getMaxMemory()));
        sender.sendMessage(String.format(Utils.color("&7Swap total memory: &a%s"), systemValues.getTotalSwap()));
        sender.sendMessage(Utils.color(String.format("&7Swap used memory: &a%s", systemValues.getUsedSwap())));
    }

    @Override
    public void action(CommandSender sender, String name, String[] args) {
        if (name.equals("vmstat")) {
            if (args.length == 0) {
                if (sender.hasPermission("systeminfo.commands.vmstat")) {
                    vmstat(sender);
                } else {
                    sender.sendMessage(Messages.NO_PERMISSIONS.value(true));
                }
            } else {
                sender.sendMessage(Messages.OUT_OF_ARGS.value(true));
            }
        }
    }
}
