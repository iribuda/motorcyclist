package com.company.shopping;

import com.company.clothes.Ammunition;
import com.company.clothes.Boots;

public class AmmunitionIsBoots implements AmmunitionFilter{
    @Override
    public boolean check(Ammunition ammunition) {
        return ammunition instanceof Boots;
    }
}
