package spireQuests.quests.maybelaterx;

import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.BloodVial;
import com.megacrit.cardcrawl.rooms.*;
import spireQuests.patches.QuestTriggers;
import spireQuests.quests.AbstractQuest;
import spireQuests.quests.QuestReward;

public class AsceticismQuest extends AbstractQuest {

    public AsceticismQuest() {
        super(QuestType.SHORT, QuestDifficulty.EASY);
        new TriggerTracker<>(QuestTriggers.LEAVE_ROOM, 3)
                .triggerCondition((node) -> node.room instanceof MonsterRoom)
                .setFailureTrigger(QuestTriggers.ADD_CARD, (c ->
                                        (AbstractDungeon.getCurrRoom() instanceof MonsterRoom ||
                                        AbstractDungeon.getCurrRoom() instanceof MonsterRoomElite ||
                                        AbstractDungeon.getCurrRoom() instanceof MonsterRoomBoss ||
                                        (AbstractDungeon.getCurrRoom() instanceof EventRoom && AbstractDungeon.getCurrRoom().monsters != null)) &&
                                    AbstractDungeon.getCurrRoom().isBattleOver))
                .add(this);
        addReward(new QuestReward.RelicReward(new BloodVial()));

    }

    boolean isFightRoom(AbstractRoom r) {
        if (r instanceof MonsterRoom)
            return true;
        if (r instanceof MonsterRoomElite)
            return true;
        if (r instanceof MonsterRoomBoss)
            return true;

    }
}