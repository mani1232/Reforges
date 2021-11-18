package com.willfp.reforges.reforges

import com.willfp.eco.core.config.interfaces.JSONConfig
import com.willfp.eco.core.display.Display
import com.willfp.eco.core.items.CustomItem
import com.willfp.eco.core.items.builder.SkullBuilder
import com.willfp.eco.core.recipe.Recipes
import com.willfp.libreforge.api.conditions.Conditions
import com.willfp.libreforge.api.conditions.ConfiguredCondition
import com.willfp.libreforge.api.effects.ConfiguredEffect
import com.willfp.libreforge.api.effects.Effects
import com.willfp.libreforge.api.provider.Holder
import com.willfp.reforges.ReforgesPlugin
import com.willfp.reforges.reforges.meta.ReforgeTarget
import com.willfp.reforges.reforges.util.ReforgeUtils
import org.bukkit.inventory.ItemStack
import java.util.Objects

@Suppress("DEPRECATION")
class Reforge(
    internal val config: JSONConfig,
    plugin: ReforgesPlugin
) : Holder {
    val id = config.getString("id")

    val name = config.getFormattedString("name")

    val description: List<String> = config.getFormattedStrings("description")

    val targets = config.getStrings("targets").map { ReforgeTarget.getByName(it) }.toSet()

    override val effects = config.getSubsections("effects").map {
        val effect = Effects.getByID(it.getString("id")) ?: return@map null
        ConfiguredEffect(effect, it)
    }.filterNotNull().toSet()

    override val conditions = config.getSubsections("conditions").map {
        val condition = Conditions.getByID(it.getString("id")) ?: return@map null
        ConfiguredCondition(condition, it)
    }.filterNotNull().toSet()

    val requiresStone = config.getBool("stone.enabled")

    val stone: ItemStack = SkullBuilder().apply {
        if (config.getBool("stone.enabled")) {
            setSkullTexture(config.getString("stone.texture"))
            setDisplayName(config.getFormattedString("stone.name").replace("%reforge%", name))
            addLoreLines(
                config.getFormattedStrings("stone.lore").map { "${Display.PREFIX}${it.replace("%reforge%", name)}" })
        }
    }.build()

    val stonePrice = config.getIntOrNull("stone.price") ?: -1

    init {
        Reforges.addNewReforge(this)

        ReforgeUtils.setReforgeStone(stone, this)

        Display.display(stone)

        CustomItem(
            plugin.namespacedKeyFactory.create("stone_" + this.id),
            { test -> ReforgeUtils.getReforgeStone(test) == this },
            stone
        ).register()

        if (config.getBool("stone.craftable") && config.getBool("stone.enabled")) {
            Recipes.createAndRegisterRecipe(
                plugin,
                "stone_" + this.id,
                stone,
                config.getStrings("stone.recipe", false)
            )
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        if (other !is Reforge) {
            return false
        }

        return other.id == this.id
    }

    override fun hashCode(): Int {
        return Objects.hash(id)
    }

    override fun toString(): String {
        return "Reforge{$id}"
    }
}