package spireQuests.quests.maybelaterx;

import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.MeatOnTheBone;
import spireQuests.patches.QuestTriggers;
import spireQuests.quests.AbstractQuest;
import spireQuests.quests.QuestReward;
import spireQuests.quests.maybelaterx.relics.BalancingStonesRelic;

public class DeadMeatQuest extends AbstractQuest {

    public DeadMeatQuest() {
        super(QuestType.LONG, QuestDifficulty.HARD);
        new TriggerTracker<>(QuestTriggers.VICTORY, 5)
                .triggerCondition((x) -> ((float)AbstractDungeon.player.currentHealth / (float)AbstractDungeon.player.maxHealth) <= 0.25)
                .add(this);
        addReward(new QuestReward.RelicReward(new MeatOnTheBone()));

    }
}