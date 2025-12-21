package spireQuests.quests.maybelaterx.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePrefixPatch;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.IntangiblePlayerPower;
import com.megacrit.cardcrawl.powers.IntangiblePower;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.rewards.chests.BossChest;
import spireQuests.quests.coda.relics.KeyringRelic;
import spireQuests.quests.maybelaterx.relics.BalancingStonesRelic;

import java.util.stream.Collectors;

@SpirePatch(clz = AbstractMonster.class, method = "damage")
public class PerfectKillPatch {
    public static void Prefix(AbstractMonster m, DamageInfo info) {
        if (m.isDeadOrEscaped()) return;

        int currentHp = m.currentHealth;
        int damage = info.output;

        if (damage == currentHp) {
            for (AbstractRelic relic : AbstractDungeon.player.relics) {
                if (relic != null && BalancingStonesRelic.ID.equals(relic.relicId)) {
                    relic.onTrigger();
                }
            }
        }
    }
}



/*
public class PerfectKillPatch {
    @SpirePatch(
            clz = AbstractCreature.class,
            method = "damage"
    )
    public static class PerfectKillDamagePatch {
        @SpirePrefixPatch
        public static void DamagePatch(AbstractCreature __instance, DamageInfo info) {




        }
    }
}


 */