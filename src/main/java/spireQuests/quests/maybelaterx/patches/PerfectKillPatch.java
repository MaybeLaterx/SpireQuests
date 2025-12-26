package spireQuests.quests.maybelaterx.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpireInsertPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePrefixPatch;
import com.google.gson.JsonArray;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.IntangiblePlayerPower;
import com.megacrit.cardcrawl.powers.IntangiblePower;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.rewards.chests.BossChest;
import org.apache.logging.log4j.Logger;
import spireQuests.Anniv8Mod;
import spireQuests.patches.BestiaryIntegrationPatch;
import spireQuests.quests.coda.relics.KeyringRelic;
import spireQuests.quests.maybelaterx.relics.BalancingStonesRelic;

import java.util.stream.Collectors;


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