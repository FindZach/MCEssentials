package com.findzach.mcessentials.feature.impl.misc;

import com.findzach.mcessentials.feature.Feature;
import com.findzach.mcessentials.feature.FeatureType;
import org.bukkit.Location;
import org.bukkit.Material;
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

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        // Check if the action is right click
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            // Check if the clicked block is a stair
            Material clickedType = event.getClickedBlock().getBlockData().getMaterial();
            if (isStair(clickedType)) {
                Location sitLocation = event.getClickedBlock().getLocation().add(0.5, -0.5, 0.5); // Adjust these numbers as needed
                ArmorStand armorStand = player.getWorld().spawn(sitLocation, ArmorStand.class);

                armorStand.setGravity(false);
                armorStand.setVisible(false);
                armorStand.setSmall(true);
                armorStand.addPassenger(player);
            }

        }
    }

    private List<String> approvedStairList = new ArrayList<>();
    private boolean isStair(Material material) {

        List<Material> approvedMaterialList = new ArrayList<>();

        approvedStairList = approvedStairList.isEmpty() ? getFeatureConfig().getStringList("sitting.objects") : approvedStairList;

        for (String materialRaw : approvedStairList) {
            System.out.println("Material clicked: " + material);
            Material potentialMaterial = Material.matchMaterial(materialRaw.toUpperCase());
            System.out.println("Material Raw: " + materialRaw.toUpperCase());
            if (potentialMaterial != null) {
                approvedMaterialList.add(potentialMaterial);
            }
        }
        return approvedMaterialList.contains(material);
    }
}
