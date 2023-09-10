package com.findzach.mcessentials.feature.impl.misc;

import com.findzach.mcessentials.feature.Feature;
import com.findzach.mcessentials.feature.FeatureType;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Directional;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zach S <zach@findzach.com>
 * @since 9/9/2023
 */
public class Sit extends Feature {

    @Override
    protected void setConfigDefaults() {
        getFeatureConfig().addDefault("sitting.objects", new String[] {
                "LEGACY_SPRUCE_WOOD_STAIRS",
                "LEGACY_WOOD_STAIRS"
        });
    }

    @Override
    public FeatureType getFeatureType() {
        return FeatureType.SIT;
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        // Check if the action is right click
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            // Check if the clicked block is a stair
            Block clickedBlock = event.getClickedBlock();
            Material clickedType = clickedBlock.getBlockData().getMaterial();

            if (isStair(clickedType)) {
                Location sitLocation = getSitLocation(clickedBlock);

                if (sitLocation != null) {
                    ArmorStand armorStand = player.getWorld().spawn(sitLocation, ArmorStand.class);

                    armorStand.setGravity(false);
                    armorStand.setVisible(false);
                    armorStand.setSmall(true);
                    armorStand.addPassenger(player);
                }
            }
        }

    }

    private Location getSitLocation(Block block) {
        BlockData blockData = block.getBlockData();
        Location blockLocation = block.getLocation();
        double offsetX = 0.0;
        double offsetY = -0.6;
        double offsetZ = 0.0;

        if (blockData instanceof Directional) {
            Directional directional = (Directional) blockData;
            BlockFace facing = directional.getFacing();

            switch (facing) {
                case SOUTH:
                    // Adjust offsets for south-facing stairs
                    offsetX = 0.5;
                    offsetY = -0.6;
                    offsetZ = 0.3;
                    break;
                case NORTH:
                    // Adjust offsets for north-facing stairs
                    offsetX = 0.5;
                    offsetY = -0.6;
                    offsetZ = 0.7;
                    break;
                case EAST:
                    // Adjust offsets for east-facing stairs
                    offsetX = 0.3;
                    offsetY = -0.6;
                    offsetZ = 0.5;
                    break;
                case WEST:
                    // Adjust offsets for west-facing stairs
                    offsetX = 0.7;
                    offsetY = -0.6;
                    offsetZ = 0.5;
                    break;
            }

        }

        return blockLocation.add(offsetX, offsetY, offsetZ);
    }

    private List<String> approvedStairList = new ArrayList<>();
    private boolean isStair(Material material) {

        List<Material> approvedMaterialList = new ArrayList<>();

        approvedStairList = approvedStairList.isEmpty() ? getFeatureConfig().getStringList("sitting.objects") : approvedStairList;

        for (String materialRaw : approvedStairList) {
            Material potentialMaterial = Material.matchMaterial(materialRaw.toUpperCase());
            if (potentialMaterial != null) {
                approvedMaterialList.add(potentialMaterial);
            }
        }
        return approvedMaterialList.contains(material);
    }

}
