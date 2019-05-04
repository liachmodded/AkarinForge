/*
 * Decompiled with CFR 0_119.
 */
package catserver.api.bukkit.entity;

import catserver.api.bukkit.entity.CustomEntityClass;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityManager {
    public static List<CustomEntityClass> getCustomEntityList() {
        ArrayList<CustomEntityClass> list = new ArrayList<CustomEntityClass>();
        for (Map.Entry<String, Class<? extends vg>> entitySet : EntityRegistry.entityClassMap.entrySet()) {
            list.add(new CustomEntityClass(entitySet.getKey(), entitySet.getValue()));
        }
        return list;
    }
}

