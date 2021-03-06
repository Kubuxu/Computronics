package pl.asie.computronics.integration.gregtech;

import gregtech.api.interfaces.tileentity.IDigitalChest;
import li.cil.oc.api.network.Arguments;
import li.cil.oc.api.network.Callback;
import li.cil.oc.api.network.Context;
import li.cil.oc.api.network.ManagedEnvironment;
import li.cil.oc.api.prefab.DriverTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import pl.asie.computronics.integration.ManagedEnvironmentOCTile;

public class DriverDigitalChest extends DriverTileEntity {
	public class ManagedEnvironmentDC extends ManagedEnvironmentOCTile<IDigitalChest> {
		public ManagedEnvironmentDC(IDigitalChest tile, String name) {
			super(tile, name);
		}

		@Callback(direct = true)
		public Object[] getContents(Context c, Arguments a) {
			return new Object[] { tile.getStoredItemData() };
		}
	}

	@Override
	public Class<?> getTileEntityClass() {
		return IDigitalChest.class;
	}

	@Override
	public boolean worksWith(World world, int x, int y, int z) {
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		return tileEntity != null && tileEntity instanceof IDigitalChest
			&& ((IDigitalChest) tileEntity).isDigitalChest();
	}

	@Override
	public ManagedEnvironment createEnvironment(World world, int x, int y, int z) {
		return new ManagedEnvironmentDC((IDigitalChest) world.getTileEntity(x, y, z), "digital_chest");
	}
}
