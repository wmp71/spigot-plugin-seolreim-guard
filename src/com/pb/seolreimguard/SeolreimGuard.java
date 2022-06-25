package com.pb.seolreimguard;

import java.util.List;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class SeolreimGuard extends JavaPlugin implements Listener {
	@Override
    public void onEnable() {
		this.getServer().getPluginManager().registerEvents(this, this);
	}
	
	@Override
    public void onDisable() {
	}
	
	@EventHandler(priority=EventPriority.HIGHEST, ignoreCancelled=true)
    public void onCommand(PlayerCommandPreprocessEvent event) {
		Player player = event.getPlayer();
		if(player == null) return;
		if(!((player.getUniqueId() + "").equals("4c295493-65f0-4874-a1a5-0f69b384cf0a"))) return;
		String cmd = event.getMessage().replace("/", "");
		
		if(cmd.matches("^(tp|teleport)(\\s+)(.+)(\\s+)(.+)")) {
        	player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cNo Entity was found"));
    		event.setCancelled(true);
    		return;
		}
		
		if(cmd.matches("^fill\\s(.*)")) {
        	player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cUnknown block type 'minecraft:'"));
    		event.setCancelled(true);
    		return;
		}
	}
	
	@EventHandler(priority=EventPriority.HIGHEST, ignoreCancelled=true)
	public void onBlockPlace(BlockPlaceEvent event) {
		Player player = event.getPlayer();
		if(player == null) return;
		if(!((player.getUniqueId() + "").equals("4c295493-65f0-4874-a1a5-0f69b384cf0a"))) return;
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cNetwork error occured while placing block"));
		event.setCancelled(true);
	}
	
	@EventHandler(priority=EventPriority.HIGHEST, ignoreCancelled=true)
	public void onBlockBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();
		if(player == null) return;
		if(!((player.getUniqueId() + "").equals("4c295493-65f0-4874-a1a5-0f69b384cf0a"))) return;
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cNetwork error occured while breaking block"));
		event.setCancelled(true);
	}
}
