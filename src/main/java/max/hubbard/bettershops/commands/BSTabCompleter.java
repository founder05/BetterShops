package max.hubbard.bettershops.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class BSTabCompleter implements TabCompleter {

    @Override public List<String> onTabComplete(@NotNull CommandSender sender, Command cmd,
        @NotNull String alias, String[] args) {
        if (cmd.getName().equalsIgnoreCase("bs") || cmd.getName().equalsIgnoreCase("bettershop")) {
            if (!(sender instanceof Player)) {
                return null;
            }

            List<String> list = new ArrayList<>();
            List<String> auto = new ArrayList<>();

            if (args.length == 1) {
                if (sender.hasPermission("bettershop.tabcompleter")) {
                    list.add("info");
                    list.add("config");
                    list.add("language");
                    list.add("blacklist");
                    list.add("open");
                    list.add("move");
                    list.add("remove");
                    list.add("list");
                    list.add("migrate");
                    list.add("update");

                    for (String s : list) {
                        if (s.startsWith(args[args.length - 1])) {
                            auto.add(s);
                        }
                    }
                    return auto.isEmpty() ? list : auto;

                }
            }
            return null;
        }
        return null;
    }
}
