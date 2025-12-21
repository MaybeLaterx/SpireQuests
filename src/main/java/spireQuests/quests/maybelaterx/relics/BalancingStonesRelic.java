package spireQuests.quests.maybelaterx.relics;

import spireQuests.abstracts.AbstractSQRelic;
import spireQuests.util.Wiz;

import static spireQuests.Anniv8Mod.makeID;

public class BalancingStonesRelic extends AbstractSQRelic {

    public static final String ID = makeID(BalancingStonesRelic.class.getSimpleName());
    private static final int DRAW = 1;
    public BalancingStonesRelic() {
        super(ID, "coda", RelicTier.SPECIAL, LandingSound.MAGICAL);
    }
/*
    public void onTrigger() {
        flash();
        Wiz.p().draw(DRAW);
    }

 */
}
