package gay.j10a1n15.customscoreboard.mixins;

import gay.j10a1n15.customscoreboard.api.events.RenderHudElementEvent;
import gay.j10a1n15.customscoreboard.api.events.RenderHudEvent;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.PlayerRideableJumping;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Gui.class)
public class GuiMixin {

    @Unique
    private static boolean renderEvent(RenderHudElementEvent.Element element) {
        return RenderHudElementEvent.getEVENT().fire(new RenderHudElementEvent(element)).isCancelled();
    }

    @Inject(method = "renderItemHotbar", at = @At("HEAD"), cancellable = true)
    private void onHotbarRender(GuiGraphics guiGraphics, DeltaTracker deltaTracker, CallbackInfo ci) {
        if (renderEvent(RenderHudElementEvent.Element.HOTBAR)) {
            ci.cancel();
        }
    }

    @Inject(method = "renderJumpMeter", at = @At("HEAD"), cancellable = true)
    private void onJumpBarRender(PlayerRideableJumping playerRideableJumping, GuiGraphics guiGraphics, int i, CallbackInfo ci) {
        if (renderEvent(RenderHudElementEvent.Element.JUMP_BAR)) {
            ci.cancel();
        }
    }

    @Inject(method = "renderExperienceBar", at = @At("HEAD"), cancellable = true)
    private void onExperienceBarRender(GuiGraphics guiGraphics, int i, CallbackInfo ci) {
        if (renderEvent(RenderHudElementEvent.Element.EXPERIENCE)) {
            ci.cancel();
        }
    }

    @Inject(method = "displayScoreboardSidebar", at = @At("HEAD"), cancellable = true)
    private void onScoreboardRender(CallbackInfo ci) {
        if (renderEvent(RenderHudElementEvent.Element.SCOREBOARD)) {
            ci.cancel();
        }
    }

    @Inject(method = "renderHearts", at = @At("HEAD"), cancellable = true)
    private void onRenderHearts(GuiGraphics guiGraphics, Player player, int i, int j, int k, int l, float f, int m, int n, int o, boolean bl, CallbackInfo ci) {
        if (renderEvent(RenderHudElementEvent.Element.HEALTH)) {
            ci.cancel();
        }
    }

    @Inject(method = "renderVehicleHealth", at = @At("HEAD"), cancellable = true)
    private void onVehicleHealthRender(GuiGraphics guiGraphics, CallbackInfo ci) {
        if (renderEvent(RenderHudElementEvent.Element.HEALTH)) {
            ci.cancel();
        }
    }

    @Inject(method = "renderEffects", at = @At("HEAD"), cancellable = true)
    private void onEffectsRender(GuiGraphics guiGraphics, DeltaTracker deltaTracker, CallbackInfo ci) {
        if (renderEvent(RenderHudElementEvent.Element.EFFECTS)) {
            ci.cancel();
        }
    }

    @Inject(method = "renderArmor", at = @At("HEAD"), cancellable = true)
    private static void onArmorRender(GuiGraphics guiGraphics, Player player, int i, int j, int k, int l, CallbackInfo ci) {
        if (renderEvent(RenderHudElementEvent.Element.ARMOR)) {
            ci.cancel();
        }
    }

    @Inject(method = "renderFood", at = @At("HEAD"), cancellable = true)
    private void onFoodRender(GuiGraphics guiGraphics, Player player, int i, int j, CallbackInfo ci) {
        if (renderEvent(RenderHudElementEvent.Element.HUNGER)) {
            ci.cancel();
        }
    }

    @Inject(method = "renderPlayerHealth", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/profiling/ProfilerFiller;popPush(Ljava/lang/String;)V", ordinal = 2, shift = At.Shift.BEFORE), cancellable = true)
    private void onAirRender(GuiGraphics guiGraphics, CallbackInfo ci) {
        if (renderEvent(RenderHudElementEvent.Element.AIR)) {
            Minecraft.getInstance().getProfiler().pop();
            ci.cancel();
        }
    }

    @Inject(
            method = "renderSleepOverlay",
            at = @At("HEAD")
    )
    private void onRender(GuiGraphics guiGraphics, DeltaTracker deltaTracker, CallbackInfo ci) {
        RenderHudEvent.getEVENT().fire(new RenderHudEvent(guiGraphics));
    }
}
