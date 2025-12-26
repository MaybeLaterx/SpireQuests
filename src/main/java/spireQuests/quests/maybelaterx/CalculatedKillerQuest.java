package spireQuests.quests.maybelaterx;

import basemod.helpers.CardPowerTip;
import basemod.patches.whatmod.RelicTips;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.blue.Claw;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.PowerTip;
import spireQuests.patches.QuestTriggers;
import spireQuests.quests.AbstractQuest;
import spireQuests.quests.QuestReward;
import spireQuests.quests.maybelaterx.relics.BalancingStonesRelic;
import spireQuests.quests.theabest.relics.NailPolish;

import java.util.List;
import java.util.Objects;

public class CalculatedKillerQuest extends AbstractQuest {

    public CalculatedKillerQuest() {
        super(QuestType.SHORT, QuestDifficulty.NORMAL);
        new TriggerTracker<>(QuestTriggers.PLAY_CARD, 30)
                .triggerCondition((card) -> Objects.equals(card.cardID, Claw.ID))
                .add(this);
        addReward(new QuestReward.RelicReward(new BalancingStonesRelic()));
    }
}
