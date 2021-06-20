package io.github.zemelua.umumod.client.gui.screen.inventory;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import io.github.zemelua.umumod.UMUMod;
import io.github.zemelua.umumod.inventory.container.BelongingsUMUPlayerContainer;
import io.github.zemelua.umumod.inventory.container.element.tank.Tank;
import io.github.zemelua.umumod.util.UMUEntityUtil;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.screen.inventory.InventoryScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class BelongingsInventoryScreen extends HasTankContainerScreen<BelongingsUMUPlayerContainer> {
	private static final ResourceLocation BELONGINGS_INVENTORY_BACKGROUND = new ResourceLocation(UMUMod.MOD_ID, "textures/gui/container/belongings_inventory.png");
	private static final TranslationTextComponent BACKPACK_TITLE = new TranslationTextComponent("container.backpack");
	private static final TranslationTextComponent QUIVER_TITLE = new TranslationTextComponent("container.quiver");
	private static final TranslationTextComponent TANK_TITLE = new TranslationTextComponent("container.tank");

	private float oldMouseX;
	private float oldMouseY;

	public BelongingsInventoryScreen(BelongingsUMUPlayerContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
		super(screenContainer, inv, titleIn);
		this.xSize = 354;
		this.ySize = 186;
		this.titleX = 186;
		this.titleY = 6;
		this.playerInventoryTitleX = 186;
		this.playerInventoryTitleY = 92;
	}

	@Override
	protected void init() {
		super.init();
	}

	@Override
	public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		if (this.minecraft == null) return;

		this.oldMouseX = (float) mouseX;
		this.oldMouseY = (float) mouseY;
		super.render(matrixStack, mouseX, mouseY, partialTicks);

		this.minecraft.getTextureManager().bindTexture(BELONGINGS_INVENTORY_BACKGROUND);
		for (Tank tank : this.container.getInventoryTanks()) {
			if (tank.isEnabled()) {
				AbstractGui.blit(
						matrixStack, this.guiLeft + tank.getXPos(), this.guiTop + tank.getYPos(), this.getBlitOffset(),
						0, 226, 33, 20, 256, 512
				);
			}
		}

		this.renderHoveredTooltip(matrixStack, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack matrixStack, int x, int y) {
		super.drawGuiContainerForegroundLayer(matrixStack, x, y);

		this.font.drawText(matrixStack, BelongingsInventoryScreen.BACKPACK_TITLE, 8, 6, 4210752);
		this.font.drawText(matrixStack, BelongingsInventoryScreen.QUIVER_TITLE, 8, 103, 4210752);
		this.font.drawText(matrixStack, BelongingsInventoryScreen.TANK_TITLE, 8, 146, 4210752);
	}

	@Override
	@SuppressWarnings({"deprecation", "NullableProblems"})
	protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {
		if (this.minecraft == null) return;
		if (this.minecraft.player == null) return;

		RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.minecraft.getTextureManager().bindTexture(BELONGINGS_INVENTORY_BACKGROUND);
		AbstractGui.blit(matrixStack, this.guiLeft, this.guiTop, this.getBlitOffset(), 0, 0, this.xSize, this.ySize, 256, 512);

		PlayerEntity player = this.container.getPlayer();
		if (UMUEntityUtil.hasBackpack(player)) {
			for (int i = 0; i < UMUEntityUtil.getBackpackSize(player); i++) {
				AbstractGui.blit(
						matrixStack, this.guiLeft + 7, this.guiTop + 17 + 18 * i, this.getBlitOffset(), 0, 186, 162, 18, 256, 512
				);
			}
		}
		if (UMUEntityUtil.hasQuiver(player)) {
			AbstractGui.blit(matrixStack, this.guiLeft + 7, this.guiTop + 114, this.getBlitOffset(), 0, 186, 162, 18, 256, 512);
		}
		if (UMUEntityUtil.hasTank(player)) {

		}

		InventoryScreen.drawEntityOnScreen(
				this.guiLeft + 229, this.guiTop + 75, 30, (float) (this.guiLeft + 229) - this.oldMouseX,
				(float) (this.guiTop + 75 - 50) - this.oldMouseY, this.minecraft.player
		);
	}
}
