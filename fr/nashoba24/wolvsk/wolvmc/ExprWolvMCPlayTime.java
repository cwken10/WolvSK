package fr.nashoba24.wolvsk.wolvmc;

import javax.annotation.Nullable;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import ch.njol.skript.classes.Changer;
import ch.njol.skript.classes.Changer.ChangeMode;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import ch.njol.util.coll.CollectionUtils;
import fr.nashoba24.wolvmc.WolvMC;

public class ExprWolvMCPlayTime extends SimpleExpression<Integer>{
	private Expression<Player> player;
	
	@Override
	public boolean isSingle() {
		return true;
	}
	
	@Override
	public Class<? extends Integer> getReturnType() {
		return Integer.class;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] expr, int matchedPattern, Kleenean paramKleenean, ParseResult paramParseResult) {
		player = (Expression<Player>) expr[0];
		return true;
	}
	
	@Override
	public String toString(@Nullable Event e, boolean paramBoolean) {
		return "play time of player";
	}
	
	@Override
	@Nullable
	protected Integer[] get(Event e) {
		return new Integer[]{ WolvMC.getTime(player.getSingle(e).getName()) };
	}
	
	@Override
	public void change(Event e, Object[] delta, Changer.ChangeMode mode){
		if (mode == ChangeMode.SET) {
			WolvMC.setTime(player.getSingle(e).getName(), ((Number) delta[0]).intValue());
		}
		else if (mode == ChangeMode.RESET) {
			WolvMC.setTime(player.getSingle(e).getName(), 0);
		}
		else if(mode == ChangeMode.ADD) {
			WolvMC.setTime(player.getSingle(e).getName(), WolvMC.getTime(player.getSingle(e).getName()) + ((Number) delta[0]).intValue());
		}
		else if(mode == ChangeMode.REMOVE) {
			WolvMC.setTime(player.getSingle(e).getName(), WolvMC.getTime(player.getSingle(e).getName()) - ((Number) delta[0]).intValue());
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Class<?>[] acceptChange(final Changer.ChangeMode mode) {
		if (mode == ChangeMode.SET || mode == ChangeMode.RESET || mode == ChangeMode.ADD || mode == ChangeMode.REMOVE)
			return CollectionUtils.array(Number.class);
		return null;
	}
}

