package io.github.zemelua.umumod.client.gui.screen.inventory;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.ToggleWidget;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

@OnlyIn(Dist.CLIENT)
public class InventoryTabToggleWidget extends ToggleWidget {
	private final InventoryTabCategories category;

	public InventoryTabToggleWidget(int yIn, InventoryTabCategories category) {
		super(0, yIn, 35, 27, false);
		this.category = category;
		this.initTextureValues(153, 2, 35, 0, UMUInventoryScreen.INVENTORY_TAB);
	}

	public InventoryTabCategories getCategories() {
		return this.category;
	}

	public void setActive() {
		this.setStateTriggered(true);
	}

	@Override
	public final void renderWidget(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		Minecraft minecraft = Minecraft.getInstance();
		minecraft.getTextureManager().bindTexture(this.resourceLocation);
		RenderSystem.disableDepthTest();

		int uOffset = this.xTexStart;
		int yvOffset = this.yTexStart;
		if (this.stateTriggered) {
			uOffset += this.xDiffTex;
		}

		if (this.isHovered()) {
			yvOffset += this.yDiffTex;
		}

		int x = this.x;
		if (this.stateTriggered) {
			x -= 2;
		}

		RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.blit(matrixStack, x, this.y, uOffset, yvOffset, this.width, this.height);
		RenderSystem.enableDepthTest();
		this.renderIcon(minecraft.getItemRenderer());
	}

	private void renderIcon(ItemRenderer p_193920_1_) {
		List<ItemStack> list = this.category.getIcons();
		int xOffset = this.stateTriggered ? -2 : 0;
		if (list.size() == 1) {
			p_193920_1_.renderItemAndEffectIntoGuiWithoutEntity(list.get(0), this.x + 9 + xOffset, this.y + 5);
		} else if (list.size() == 2) {
			p_193920_1_.renderItemAndEffectIntoGuiWithoutEntity(list.get(0), this.x + 3 + xOffset, this.y + 5);
			p_193920_1_.renderItemAndEffectIntoGuiWithoutEntity(list.get(1), this.x + 14 + xOffset, this.y + 5);
		}
	}
}
