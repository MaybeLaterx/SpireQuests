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
        //paramtypez = { DamageInfo.class }
)
public class PerfectKillPatch {
    /*
    @SpireInsertPatch(locator = BestiaryIntegrationPatch.Locator.class, localvars = {"arr"})
    public static void AddMonsters(Object __instance, JsonArray arr) {
        logger.info("Loading Bestiary entries for modded monsters");
        for (String packageName : Anniv8Mod.questPackages) {
            addPackageMonstersForLanguage(arr, packageName, "eng");
            if (Settings.language != Settings.GameLanguage.ENG)
            {
                addPackageMonstersForLanguage(arr, packageName, Settings.language.toString().toLowerCase());
            }
        }
    }
     */
    public static final Logger logger = Anniv8Mod.logger;

    @SpireInsertPatch(rloc = 77, localvars={"damageAmount"})
    public static void Insert(AbstractMonster __instance, int damageAmount) {
        logger.error("damageAmount: " + damageAmount + ", currentHealth: " + __instance.currentHealth);
        if (__instance.currentHealth == 0) {
            CardCrawlGame.sound.play("SHOP_PURCHASE"); // remove
            for (AbstractRelic relic : AbstractDungeon.player.relics) {
                if (relic instanceof BalancingStonesRelic) {
                    relic.onTrigger();
                }
            }
        }
    }
}