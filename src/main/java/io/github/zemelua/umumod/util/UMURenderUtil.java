package io.github.zemelua.umumod.util;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldVertexBufferUploader;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.math.vector.Matrix4f;

public class UMURenderUtil {
	private UMURenderUtil() {
	}

	public static void setColorNormal() {
		RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F );
	}

	public static void setColorRGBA(int color) {
		RenderSystem.color4f(
				(float) (color >> 16 &  255) / 255.0F,
				(float) (color >>  8 &  255) / 255.0F,
				(float) (color       &  255) / 255.0F,
				(float) (color >> 24 & 0xFF) / 255.0F
		);
	}

	public static void blit(MatrixStack matrixStack, int x, int y, int blitOffset, int width, int height,
							int textureUOffset, int textureVOffset, int textureWidth, int textureHeight, TextureAtlasSprite sprite) {
		innerBlit(
				matrixStack.getLast().getMatrix(), x, x + width, y, y + height, blitOffset,
				(sprite.getMinU() + ((sprite.getMaxU() - sprite.getMinU()) * (float) textureUOffset / sprite.getWidth())),
				(sprite.getMinU() + ((sprite.getMaxU() - sprite.getMinU()) * (float) (textureUOffset + textureWidth) / sprite.getWidth())),
				(sprite.getMinV() + ((sprite.getMaxV() - sprite.getMinV()) * (float) textureVOffset / sprite.getHeight())),
				(sprite.getMinV() + ((sprite.getMaxV() - sprite.getMinV()) * (float) (textureVOffset + textureHeight) / sprite.getHeight()))
		);

	}

	private static void innerBlit(Matrix4f matrix, int x1, int x2, int y1, int y2, int blitOffset, float minU, float maxU, float minV, float maxV) {
		BufferBuilder bufferbuilder = Tessellator.getInstance().getBuffer();
		bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
		bufferbuilder.pos(matrix, (float)x1, (float)y2, (float)blitOffset).tex(minU, maxV).endVertex();
		bufferbuilder.pos(matrix, (float)x2, (float)y2, (float)blitOffset).tex(maxU, maxV).endVertex();
		bufferbuilder.pos(matrix, (float)x2, (float)y1, (float)blitOffset).tex(maxU, minV).endVertex();
		bufferbuilder.pos(matrix, (float)x1, (float)y1, (float)blitOffset).tex(minU, minV).endVertex();
		bufferbuilder.finishDrawing();
		RenderSystem.enableAlphaTest();
		WorldVertexBufferUploader.draw(bufferbuilder);
	}
}
