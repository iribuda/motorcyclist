package com.company.shopping;

import com.company.clothes.Ammunition;
import com.company.clothes.Pants;

public class AmmunitionIsPants implements AmmunitionFilter{
    @Override
    public boolean check(Ammunition ammunition) {
        return ammunition instanceof Pants;
    }
}
