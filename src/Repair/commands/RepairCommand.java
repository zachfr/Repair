package Repair.commands;

import Repair.Main;
import com.sun.istack.internal.NotNull;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class RepairCommand implements CommandExecutor {

    private Main plugin;

    public RepairCommand(Main plugin){
        this.plugin = plugin;
        plugin.getCommand("repair").setExecutor(this);
    }

    @Override
    @NotNull
    @Deprecated
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("You are not player");
            return true;
        }

        Player player =(Player) sender;

        if (player.hasPermission("Repair.use")) {
            player.getItemInHand().setDurability((short) 0);
            player.sendMessage("You have successful repair your item!");
            return true;
        }else{
            player.sendMessage("You don't have permission");
        }

        return false;
    }
}
