package com.company.shopping;

import com.company.clothes.Ammunition;
import com.company.clothes.Helmet;

public class AmmunitionIsHelmet implements AmmunitionFilter{
    @Override
    public boolean check(Ammunition ammunition) {
        return ammunition instanceof Helmet;
    }
}
