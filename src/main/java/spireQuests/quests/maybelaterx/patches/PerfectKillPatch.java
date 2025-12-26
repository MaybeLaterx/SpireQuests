package spireQuests.quests.maybelaterx.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpireInsertPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import spireQuests.quests.maybelaterx.relics.BalancingStonesRelic;

@SpirePatch(
        clz = AbstractMonster.class,
        method = "damage"
)
public class PerfectKillPatch {
    @SpireInsertPatch(rloc = 77)
    public static void Insert(AbstractMonster __instance) {
        if (__instance.currentHealth == 0) {
            for (AbstractRelic relic : AbstractDungeon.player.relics) {
                if (relic instanceof BalancingStonesRelic) {
                    relic.onTrigger();
                }
            }
        }
    }
}