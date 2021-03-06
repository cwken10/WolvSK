package fr.nashoba24.wolvsk;

import java.io.File;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import ch.njol.skript.Skript;
import fr.nashoba24.wolvsk.askyblock.WolvSKASkyBlock;
import fr.nashoba24.wolvsk.essentials.WolvSKEssentials;
import fr.nashoba24.wolvsk.guardianbeamapi.WolvSKGuardianBeamAPI;
import fr.nashoba24.wolvsk.maths.WolvSKMaths;
import fr.nashoba24.wolvsk.minigames.Minigames;
import fr.nashoba24.wolvsk.misc.WolvSKMisc;
import fr.nashoba24.wolvsk.playerpoints.WolvSKPlayerPoints;
import fr.nashoba24.wolvsk.pvparena.WolvSKPvpArena;
import fr.nashoba24.wolvsk.quests.WolvSKQuests;
import fr.nashoba24.wolvsk.serverquery.WolvSKPing;
import fr.nashoba24.wolvsk.supertrails.WolvSKSuperTrails;
import fr.nashoba24.wolvsk.wolvmc.WolvSKWolvMC;

public class WolvSK extends JavaPlugin implements Listener {
	
	private static WolvSK instance;
	public static HashMap<String, Long> cooldowns = new HashMap<String, Long>();
	  
	  @Override
	  public void onDisable()
	  {
		  Bukkit.getLogger().info(ChatColor.translateAlternateColorCodes('&', "&bWolvSK Disabled!"));
	  }
	  
	  @Override
	  public void onEnable()
	  {
		   instance = this;
		   File file = new File(WolvSK.getInstance().getDataFolder() + "/");
		   if(!file.exists()) {
			   file.mkdir();
		   }
		   Skript.registerAddon(this);
		   WolvSKASkyBlock.registerAll();
		   WolvSKEssentials.registerAll();
		   WolvSKGuardianBeamAPI.registerAll();
		   WolvSKMisc.registerAll();
		   WolvSKPvpArena.registerAll();
		   WolvSKPing.registerAll();
		   WolvSKSuperTrails.registerAll();
		   WolvSKWolvMC.registerAll();
		   WolvSKPlayerPoints.registerAll();
		   WolvSKMaths.registerAll();
		   //WolvSKQuests.registerAll();
		   Bukkit.getPluginManager().registerEvents(new Minigames(), this);
		   getCommand("minigames").setExecutor(new Minigames());
		   Minigames.registerAll();
		   Minigames.load();
		   Bukkit.getLogger().info(ChatColor.translateAlternateColorCodes('&', "&aWolvSK Enabled!"));
	  }

	  
	  public static WolvSK getInstance() {
		    return WolvSK.instance;
	  }
}
