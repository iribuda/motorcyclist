package com.company.shopping;

import com.company.clothes.Ammunition;
import com.company.clothes.Gloves;

public class AmmunitionIsGloves implements AmmunitionFilter{
    @Override
    public boolean check(Ammunition ammunition) {
        return ammunition instanceof Gloves;
    }
}
