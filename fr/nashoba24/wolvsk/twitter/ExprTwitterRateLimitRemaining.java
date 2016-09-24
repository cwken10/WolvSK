package fr.nashoba24.wolvsk.twitter;

import javax.annotation.Nullable;

import org.bukkit.event.Event;

import twitter4j.TwitterException;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;

public class ExprTwitterRateLimitRemaining extends SimpleExpression<Integer>{
	
	@Override
	public boolean isSingle() {
		return true;
	}
	
	@Override
	public Class<? extends Integer> getReturnType() {
		return Integer.class;
	}
	
	@Override
	public boolean init(Expression<?>[] expr, int matchedPattern, Kleenean paramKleenean, ParseResult paramParseResult) {
		return true;
	}
	
	@Override
	public String toString(@Nullable Event e, boolean paramBoolean) {
		return "rate limit remaining";
	}
	
	@Override
	@Nullable
	protected Integer[] get(Event e) {
		if(WolvSKTwitter.tf==null) { return null; }
		try {
			return new Integer[] { WolvSKTwitter.tf.getInstance().getAccountSettings().getRateLimitStatus().getRemaining() };
		} catch (TwitterException e1) {
			e1.printStackTrace();
			return null;
		}
	}
}

