package pl.asie.computronics.cc;

import dan200.computercraft.api.peripheral.IPeripheral;
import dan200.computercraft.api.peripheral.IPeripheralProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import pl.asie.computronics.tile.TileEntityPeripheralBase;

public class CCPeripheralProvider implements IPeripheralProvider {
	@Override
	public IPeripheral getPeripheral(World world, int x, int y, int z, int side) {
		TileEntity t = world.getTileEntity(x, y, z);
		if(t != null && t instanceof TileEntityPeripheralBase) {
			return ((IPeripheral)t);
		} else return null;
	}
}
