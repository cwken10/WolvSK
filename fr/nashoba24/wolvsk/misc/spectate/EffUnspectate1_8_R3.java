package fr.nashoba24.wolvsk.misc.spectate;

import javax.annotation.Nullable;

import net.minecraft.server.v1_8_R3.PacketPlayOutCamera;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;

public class EffUnspectate1_8_R3 extends Effect {
	
	private Expression<Player> player;
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] expr, int matchedPattern, Kleenean paramKleenean, ParseResult paramParseResult) {
		player = (Expression<Player>) expr[0];
		return true;
	}
	
	@Override
	public String toString(@Nullable Event e, boolean b) {
		return "unspectate";
	}
	
	@Override
	protected void execute(Event e) {
	    PacketPlayOutCamera camera2 = new PacketPlayOutCamera(((CraftPlayer) player.getSingle(e)).getHandle());
	    ((CraftPlayer)player.getSingle(e)).getHandle().playerConnection.sendPacket(camera2);
	}
}
