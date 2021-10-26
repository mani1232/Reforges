package com.willfp.reforges.effects.effects

import com.willfp.eco.core.config.interfaces.JSONConfig
import com.willfp.reforges.effects.Effect
import com.willfp.reforges.vault.EconomyHandler
import org.bukkit.block.Block
import org.bukkit.entity.Player
import org.bukkit.event.block.BlockBreakEvent

class EffectRewardBlockBreak : Effect("reward_block_break") {
    override fun onBlockBreak(
        player: Player,
        block: Block,
        event: BlockBreakEvent,
        config: JSONConfig
    ) {
        if (EconomyHandler.isEnabled()) {
            EconomyHandler.getInstance().depositPlayer(player, config.getDouble("amount"))
        }
    }
}