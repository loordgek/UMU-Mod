package io.github.zemelua.umumod.client.gui.screen.inventory;

import com.mojang.blaze3d.matrix.MatrixStack;
import io.github.zemelua.umumod.inventory.container.HasTankContainer;
import io.github.zemelua.umumod.inventory.container.element.tank.Tank;
import io.github.zemelua.umumod.util.UMURenderUtil;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.container.PlayerContainer;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.fluids.FluidStack;

import javax.annotation.Nullable;

public abstract class HasTankContainerScreen<T extends HasTankContainer> extends ContainerScreen<T> {
	@Nullable
	protected Tank hoveredTank;
	@Nullable
	protected Tank clickedTank;

	public HasTankContainerScreen(T screenContainer, PlayerInventory inv, ITextComponent titleIn) {
		super(screenContainer, inv, titleIn);
	}

	@Override
	@SuppressWarnings("NullableProblems")
	public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		super.render(matrixStack, mouseX, mouseY, partialTicks);
		this.renderTanks(matrixStack, mouseX, mouseY, partialTicks);
	}

	protected void renderTanks(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		for (Tank tank : this.container.getInventoryTanks()) {
			if (tank.isEnabled()) {
				this.renderFluid(matrixStack, tank);
			}
		}
	}

	private void renderFluid(MatrixStack matrixStack, Tank tank) {
		int x = tank.getXPos();
		int y = tank.getYPos();

		// FluidStack fluidStack = tank.getStack();
		FluidStack fluidStack = new FluidStack(Fluids.FLOWING_WATER, 1);

		UMURenderUtil.setColorRGBA(fluidStack.getFluid().getAttributes().getColor(fluidStack));

		TextureAtlasSprite fluidSprite = this.minecraft.getAtlasSpriteGetter(PlayerContainer.LOCATION_BLOCKS_TEXTURE)
				.apply(fluidStack.getFluid().getAttributes().getStillTexture(fluidStack));

		this.minecraft.getTextureManager().bindTexture(fluidSprite.getAtlasTexture().getTextureLocation());

		int fluidWidth = 12 + 11 * (fluidStack.getAmount() - 1);
		int floor = (int) Math.floor(fluidWidth / 16D);
		for (int i = 0; i < floor; i++) {
			HasTankContainerScreen.blitFluidVertical(
					matrixStack, this.guiLeft + x + 34 - 16 * (i + 1), this.guiTop + y, this.getBlitOffset(),
					16, 0, 16, fluidSprite
			);
		}

		int fluidEndWidth = fluidWidth - 16 * floor;
		HasTankContainerScreen.blitFluidVertical(
				matrixStack, this.guiLeft + x + 34 - 16 * floor - fluidEndWidth, this.guiTop + y, this.getBlitOffset(),
				fluidEndWidth, 16 - fluidEndWidth, fluidEndWidth, fluidSprite
		);

		UMURenderUtil.setColorNormal();
	}

	private static void blitFluidVertical(MatrixStack matrixStack, int x, int y, int blitOffset, int width,
											int textureUOffset, int textureWidth, TextureAtlasSprite sprite) {
		UMURenderUtil.blit(matrixStack, x,     y, blitOffset, width,  4, textureUOffset, 12, textureWidth,  4, sprite);
		UMURenderUtil.blit(matrixStack, x, y + 4, blitOffset, width, 16, textureUOffset,  0, textureWidth, 16, sprite);
	}
}
