package io.github.zemelua.umumod.client.gui.screen.inventory;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import io.github.zemelua.umumod.inventory.container.BelongingsUMUPlayerContainer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.screen.inventory.CreativeScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.PlayerContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class UMUInventoryScreen extends ContainerScreen<PlayerContainer> {
	protected static final ResourceLocation INVENTORY_TAB = new ResourceLocation("textures/gui/recipe_book.png");

	private static final ImmutableList<InventoryTabCategories> categoriesList = ImmutableList.<InventoryTabCategories>builder()
			.add(InventoryTabCategories.PLAYER_BELONGINGS)
			.add(InventoryTabCategories.PLAYER_CRAFTING)
			.add(InventoryTabCategories.PLAYER_MAP)
			.add(InventoryTabCategories.PLAYER_ENCYCLOPEDIA)
			.build();
	private final ImmutableList<InventoryTabToggleWidget> inventoryTabs;
	private InventoryTabToggleWidget currentTab;
	private Screen currentScreen;

	public UMUInventoryScreen(PlayerEntity player) {
		super(player.container, player.inventory, new TranslationTextComponent("container.inventory_title"));

		ImmutableList.Builder<InventoryTabToggleWidget> builder = ImmutableList.builder();
		for (int i = 0; i < categoriesList.size(); i++) {
			builder.add(new InventoryTabToggleWidget(i * 28, categoriesList.get(i)));
		}
		this.inventoryTabs = builder.build();
	}

	@Override
	protected void init() {
		if (this.minecraft == null) return;
		if (this.minecraft.playerController == null) return;
		if (this.minecraft.player == null) return;

		if (this.minecraft.playerController.isInCreativeMode()) {
			this.minecraft.displayGuiScreen(new CreativeScreen(this.minecraft.player));
		}

		currentTab = inventoryTabs.get(0);
		currentTab.setStateTriggered(true);
		//this.currentScreen = InventoryTabCategories.createScreen(currentTab.getCategories());
		//this.currentScreen.init(this.minecraft, this.width, this.height);
		this.children.add(new BelongingsInventoryScreen(new BelongingsUMUPlayerContainer(0, playerInventory, null), playerInventory, StringTextComponent.EMPTY));
		super.init();
	}

	@Override
	public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		for (InventoryTabToggleWidget inventoryTab : this.inventoryTabs) {
			inventoryTab.renderWidget(matrixStack, mouseX, mouseY, partialTicks);
		}
		//if (currentScreen.getMinecraft() != null) {
			//currentScreen.render(matrixStack, mouseX, mouseY, partialTicks);
		//}
		super.render(matrixStack, mouseX, mouseY, partialTicks);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {

	}

	@Override
	public boolean mouseClicked(double mouseX, double mouseY, int button) {
		for (InventoryTabToggleWidget inventoryTab : this.inventoryTabs) {
			if (inventoryTab.mouseClicked(mouseX, mouseY, button)) {
				if (this.currentTab != inventoryTab) {
					this.currentTab.setStateTriggered(false);
					this.currentTab = inventoryTab;
					this.currentTab.setStateTriggered(true);
				}
			}
		}
		return true;
	}
}
