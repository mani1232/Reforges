package com.willfp.reforges.reforges.util;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Trident;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public interface Watcher {
    /**
     * Called when an entity shoots another entity with an arrow.
     *
     * @param attacker The shooter.
     * @param victim   The victim.
     * @param arrow    The arrow entity.
     * @param event    The event that called this watcher.
     */
    default void onArrowDamage(@NotNull final LivingEntity attacker,
                               @NotNull final LivingEntity victim,
                               @NotNull final Arrow arrow,
                               @NotNull final EntityDamageByEntityEvent event) {
        // Empty default as enchantments only override required watchers.
    }

    /**
     * Called when an entity damages another entity with a trident throw.
     *
     * @param attacker The shooter.
     * @param victim   The victim.
     * @param trident  The trident entity.
     * @param event    The event that called this watcher.
     */
    default void onTridentDamage(@NotNull final LivingEntity attacker,
                                 @NotNull final LivingEntity victim,
                                 @NotNull final Trident trident,
                                 @NotNull final EntityDamageByEntityEvent event) {
        // Empty default as enchantments only override required watchers.
    }

    /**
     * Called when a player jumps.
     *
     * @param player The player.
     * @param event  The event that called this watcher.
     */
    default void onJump(@NotNull final Player player,
                        @NotNull final PlayerMoveEvent event) {
        // Empty default as enchantments only override required watchers.
    }

    /**
     * Called when an entity attacks another entity with a melee attack.
     *
     * @param attacker The attacker.
     * @param victim   The victim.
     * @param event    The event that called this watcher.
     */
    default void onMeleeAttack(@NotNull final LivingEntity attacker,
                               @NotNull final LivingEntity victim,
                               @NotNull final EntityDamageByEntityEvent event) {
        // Empty default as enchantments only override required watchers.
    }

    /**
     * Called when an entity shoots a bow.
     *
     * @param shooter The entity that shot the bow.
     * @param arrow   The arrow that was shot.
     * @param event   The event that called this watcher.
     */
    default void onBowShoot(@NotNull final LivingEntity shooter,
                            @NotNull final Arrow arrow,
                            @NotNull final EntityShootBowEvent event) {
        // Empty default as enchantments only override required watchers.
    }

    /**
     * Called when an entity shoots a projectile.
     *
     * @param shooter    The entity that shot the bow.
     * @param projectile The projectile that was shot.
     * @param event      The event that called this watcher.
     */
    default void onProjectileLaunch(@NotNull final LivingEntity shooter,
                                    @NotNull final Projectile projectile,
                                    @NotNull final ProjectileLaunchEvent event) {
        // Empty default as enchantments only override required watchers.
    }

    /**
     * Called when an entity takes fall damage.
     *
     * @param faller The entity that took the fall damage.
     * @param event  The event that called this watcher.
     */
    default void onFallDamage(@NotNull final LivingEntity faller,
                              @NotNull final EntityDamageEvent event) {
        // Empty default as enchantments only override required watchers.
    }

    /**
     * Called when an arrow hits a block or entity.
     *
     * @param shooter The entity that shot the arrow.
     * @param event   The event that called this watcher.
     */
    default void onArrowHit(@NotNull final LivingEntity shooter,
                            @NotNull final ProjectileHitEvent event) {
        // Empty default as enchantments only override required watchers.
    }

    /**
     * Called when a trident hits a block or entity.
     *
     * @param shooter The entity that threw the trident.
     * @param event   The event that called this watcher.
     */
    default void onTridentHit(@NotNull final LivingEntity shooter,
                              @NotNull final ProjectileHitEvent event) {
        // Empty default as enchantments only override required watchers.
    }

    /**
     * Called when an entity takes damage wearing armor.
     *
     * @param victim The entity that took damage.
     * @param event  The event that called this watcher.
     */
    default void onDamageWearingArmor(@NotNull final LivingEntity victim,
                                      @NotNull final EntityDamageEvent event) {
        // Empty default as enchantments only override required watchers.
    }

    /**
     * Called when an entity throws a trident.
     *
     * @param shooter The entity that threw the trident.
     * @param trident The trident that was thrown.
     * @param event   The event that called this watcher.
     */
    default void onTridentLaunch(@NotNull final LivingEntity shooter,
                                 @NotNull final Trident trident,
                                 @NotNull final ProjectileLaunchEvent event) {
        // Empty default as enchantments only override required watchers.
    }
}