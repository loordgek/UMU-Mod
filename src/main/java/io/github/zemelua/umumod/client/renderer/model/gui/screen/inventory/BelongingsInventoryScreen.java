package io.github.zemelua.umumod.client.renderer.model.gui.screen.inventory;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import io.github.zemelua.umumod.UMUMod;
import io.github.zemelua.umumod.inventory.container.BelongingsUMUPlayerContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.screen.inventory.InventoryScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class BelongingsInventoryScreen extends ContainerScreen<BelongingsUMUPlayerContainer> {
	private static final ResourceLocation BELONGINGS_INVENTORY_BACKGROUND = new ResourceLocation(UMUMod.MOD_ID, "textures/gui/container/belongings_inventory.png");

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
		this.oldMouseX = (float) mouseX;
		this.oldMouseY = (float) mouseY;
		super.render(matrixStack, mouseX, mouseY, partialTicks);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {
		if (this.minecraft == null) return;

		RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.minecraft.getTextureManager().bindTexture(BELONGINGS_INVENTORY_BACKGROUND);
		int i = this.guiLeft;
		int j = this.guiTop;
		blit(matrixStack, i, j, this.getBlitOffset(), 0, 0, this.xSize, this.ySize, 256, 512);
		InventoryScreen.drawEntityOnScreen(i + 229, j + 75, 30, (float) (i + 229) - this.oldMouseX, (float) (j + 75 - 50) - this.oldMouseY, this.minecraft.player);
	}
}
